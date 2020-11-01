//package com.xingjiahe.www.infrastructure.util;
//
//import cn.hutool.core.map.MapUtil;
//import com.alibaba.fastjson.JSON;
//import com.easybike.user.model.UserInfo;
//import com.hellobike.constant.Consts;
//import com.hellobike.domain.dto.ReceiveRiskDTO;
//import com.hellobike.domain.dto.TagStrategyMetricDTO;
//import com.hellobike.domain.request.ReceiveOrderRequest;
//import com.hellobike.domain.vo.DriverToPassengerVo;
//import com.hellobike.domain.vo.PassengerJourneyVo;
//import com.hellobike.enums.EnumBountyType;
//import com.hellobike.enums.EnumBuryType;
//import com.hellobike.enums.EnumSendMsgScene;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import com.hellobike.rcp.common.constants.Decision;
//import com.hellobike.rcp.flowctrl.iface.RcpRiskCtrlRequest;
//import com.hellobike.rcp.flowctrl.iface.RcpRiskCtrlResponse;
//import org.apache.commons.lang3.StringUtils;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.*;
//
///**
// * <pre>
// *
// * </pre>
// *
// * @author zhouqingchun E-mail:zhouqingchun@hellobike.com
// * @version 1.0.0
// * @since 2018年9月21日 下午4:49:51
// */
//public class YunLoggerUtils {
//
//    public static final String RECEIVE_ORDER_RISK_METRIC = "receive_order_risk_metric";
//
//
//    public static void bury(EnumBuryType buryType, Map<String, Object> logData) {
//        try {
//            YunLogger.yun.metric(buryType.name(), 0.0, logData);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("YunLoggerUtils#bury error key = {},data = {},", buryType.name(), JSON.toJSONString(logData));
//        }
//    }
//
//    public static void writeToEs(String key, Map<String, Object> data) {
//        try {
//            YunLogger.yun.metric(key, 0.0, data);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("YunLoggerUtils#writeToEs error key = {},data = {},", key, data.toString());
//        }
//    }
//
//    public static void autoPublishDriverJourneyLog(String driverJourneyGuid, String newDriverJourneyGuid,
//                                                   String metric) {
//        Map<String, Object> data = new HashMap<>();
//        data.put("driverJourneyGuid", driverJourneyGuid);
//        data.put("newDriverJourneyGuid", newDriverJourneyGuid);
//        writeToEs(metric, data);
//    }
//
//    /**
//     * 功能描述:司机接单分控拦截埋点
//     * @see #receiveOrderForRisk(RcpRiskCtrlRequest, RcpRiskCtrlResponse, Long)
//     */
//    @Deprecated
//    public static void receiveOrderForRisk(String driverMobile, Long userNewId, String rejectGuid, List<String> rescode) {
//        Map<String, Object> data = new HashMap<>();
//        data.put("driverMobile", driverMobile);
//        data.put("userNewId", userNewId);
//        data.put("logtime", com.hellobike.infrastructure.util.LocalTimeUtils.formatLocalDateTime(com.hellobike.infrastructure.util.LocalTimeUtils.get()));
//        data.put("rejectGuid", rejectGuid);
//        data.put("rescode", rescode);
//        writeToEs(RECEIVE_ORDER_RISK_METRIC, data);
//    }
//
//    /**
//     * 车主接单风控拦截埋点，字段：
//     * seqNo:请求流水号
//     * user_new_id:送货人uid
//     * userMobile:送货人手机号
//     * logtime:拦截时间
//     * paxJourneyGuid:送货人不可接订单号
//     * isFirstOrder:是否送货人首单
//     * hitRules:命中风险规则
//     * decisionScore:风控风险分
//     * journeyType:业务标记 1 顺风车 2 哈啰快送
//     * @param request
//     * @param response
//     */
//    public static void receiveOrderForRisk(RcpRiskCtrlRequest request, RcpRiskCtrlResponse response, Long driverUserNewId) {
//        if (request == null || MapUtil.isEmpty(request.getRiskParams()) || response == null) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("risk check failed, request:{}, response:{}", request, response);
//            return;
//        }
//        // 仅风控失败埋点
//        if (!Decision.REJECT.equals(response.getDecision())) {
//            return;
//        }
//        Map<String, Object> data = Maps.newHashMapWithExpectedSize(16);
//        Map<String, Object> params = request.getRiskParams();
//        data.put("seqNo", request.getSeqNo());
//        data.put("userNewId", params.get("uid"));
//        data.put("userMobile", params.get("userMobile"));
//        data.put("logtime", com.hellobike.infrastructure.util.LocalTimeUtils.formatLocalDateTime(com.hellobike.infrastructure.util.LocalTimeUtils.get()));
//        data.put("paxJourneyGuid", params.get("paxJourneyGuid"));
//        data.put("isFirstOrder", params.get("isFirstOrder"));
//        data.put("hitRules", response.getHitRules());
//        data.put("decisionScore", Optional.ofNullable(response.getExtMap()).map(map -> map.get("decisionScore")).orElse(StringUtils.EMPTY));
//        data.put("journeyType", Optional.ofNullable(params.get("journeyType")).orElse(String.valueOf(EnumPaxJourneyType.HITCH_PASSENGER.getCode())));
//        writeToEs(RECEIVE_ORDER_RISK_METRIC, data);
//        //支付流程埋点 -- 风控拒绝
//        try {
//            riskRejectMetric((String) params.get("paxJourneyGuid"), driverUserNewId);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("Risk reject pay process metric failed, paxOrderId:{}, driverUserNewId:{}", params.get("paxJourneyGuid"), driverUserNewId);
//        }
//    }
//
//    /**
//     * 高顺路个性化阈值灰度埋点
//     *
//     * @param driverId
//     * @param driverToPassengerVo
//     * @param enumSendMsgScene
//     */
//    public static void driverMatchPassengerPersonalRate(Long driverId, DriverToPassengerVo driverToPassengerVo, EnumSendMsgScene enumSendMsgScene) {
//        Map<String, Object> data = new HashMap<>();
//        data.put("driverUserNewId", driverId);
//        data.put("driverOrderId", driverToPassengerVo.getDriverOrderId());
//        data.put("frequentlyJourneyId", driverToPassengerVo.getFrequentlyJourneyId());
//        data.put("passengerOrderId", driverToPassengerVo.getPassengerOrderId());
//        data.put("hitchRate", driverToPassengerVo.getHitchRate());
//        data.put("timeStamp", System.currentTimeMillis());
//        data.put("grayHit", !EnumSendMsgScene.NORMAL.equals(enumSendMsgScene));
//        data.put("enumSendMsgScene", enumSendMsgScene.getCode());
//        writeToEs("driver_personal_rate_hit", data);
//    }
//
//    /**
//     * 接单概率埋点
//     * @param journeyGuid
//     * @param receiveBountyDTO
//     * @param code
//     * @param driverUserNewId
//     * @param paxUserNewId
//     * @param allowanceAmount
//     */
//    public static void receiveProbability(String journeyGuid, Double receiveProbability, Integer code, Long driverUserNewId, Long paxUserNewId, BigDecimal allowanceAmount) {
//        Map<String, Object> receiveProbabilityMap = new HashMap<>();
//        receiveProbabilityMap.put("paxJourneyGuid", journeyGuid);
//        receiveProbabilityMap.put("receiveProbability", receiveProbability);
//        receiveProbabilityMap.put("createTime", LocalDateTime.now().format(com.hellobike.infrastructure.util.LocalTimeUtils.DATETIME_FORMATTER));
//        receiveProbabilityMap.put("scene", EnumBountyType.parse(code).getMsg());
//        receiveProbabilityMap.put("driverUserNewId", driverUserNewId);
//        receiveProbabilityMap.put("paxUserNewId", paxUserNewId);
//        receiveProbabilityMap.put("allowanceAmount", allowanceAmount);
//        writeToEs("receiver.probability.predict", receiveProbabilityMap);
//    }
//
//    /**
//     * 系统自动拼单埋点
//     *
//     * @param userNewId
//     * @param driverJourneyGuid
//     * @param paxJourneyGuid
//     */
//    public static void systemAutoPooling(Long userNewId, String driverJourneyGuid, String paxJourneyGuid) {
//        Map<String, Object> systemPoolLogMap = Maps.newHashMap();
//        systemPoolLogMap.put("userNewId", userNewId);
//        systemPoolLogMap.put("driverJourneyGuid", driverJourneyGuid);
//        systemPoolLogMap.put("paxJourneyGuid", paxJourneyGuid);
//        systemPoolLogMap.put("createTime", LocalDateTime.now().format(com.hellobike.infrastructure.util.LocalTimeUtils.DATETIME_FORMATTER));
//        systemPoolLogMap.put("scene", "自动拼单完成拼单");
//        writeToEs("system.auto.pooling.success", systemPoolLogMap);
//    }
//
//    public static void metricLog(String metricKey, Long driverUserNewId, String paxJourneyGuid, int orderStatus) {
//        metricLog(metricKey,driverUserNewId,paxJourneyGuid,orderStatus,null);
//    }
//
//    public static void metricLog(String metricKey, Long driverUserNewId, String paxJourneyGuid, int orderStatus,String reason) {
//        try {
//            Map<String, Object> log = Maps.newHashMap();
//            log.put("fireTime", System.currentTimeMillis());
//            log.put("driverUserNewId", driverUserNewId);
//            log.put("paxJourneyGuid", paxJourneyGuid);
//            log.put("orderStatus", orderStatus);
//            log.put("reason", reason);
//            com.hellobike.infrastructure.util.YunLoggerUtils.writeToEs(metricKey, log);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error(metricKey.concat(".error"), e);
//        }
//    }
//
//    public static void postPayCheckForRisk(ReceiveOrderRequest receiveOrderRequest, PassengerJourneyVo passengerJourneyVo, UserInfo driverUserInfo, ReceiveRiskDTO riskResult) {
//        Map<String, Object> metrics = Maps.newHashMap();
//        metrics.put("paxJourneyGuid", receiveOrderRequest.getPaxJourneyGuid());
//        metrics.put("driverUserNewId", receiveOrderRequest.getUserNewId());
//        metrics.put("driverMobile", driverUserInfo.getMobilePhone());
//        metrics.put("passengerUserNewId", passengerJourneyVo.getPassengerId());
//        metrics.put("passengerMobile", passengerJourneyVo.getMobilePhone());
//        metrics.put("systemCode", receiveOrderRequest.getSystemCode());
//        metrics.put("remoteIp", receiveOrderRequest.getIp());
//        if (Objects.nonNull(riskResult.getDecision())) {
//            metrics.put("decision", riskResult.getDecision().getResult());
//        }
//        metrics.put("result", riskResult.getResult());
//        metrics.put("currTime", System.currentTimeMillis());
//        writeToEs("postpay.risk.check", metrics);
//    }
//
//    public static void riskRejectMetric(String paxOrderId, Long driverUserNewId){
//        Map<String, Object> data = new HashMap<>();
//        data.put("pax_order_guid", paxOrderId);
//        data.put("driver_new_id", driverUserNewId);
//        data.put(Consts.PayProcess.KEY_REASON_TO_PROCESS, Consts.PayProcess.RISK_REJECT_REASON_CODE);
//        data.put(Consts.PayProcess.KEY_OUGHT_PAY_PROCESS, Consts.PayProcess.PRE_PAY_PROCESS_CODE);
//        YunLogger.yun.metric("hitch.avenger.pay.way", 0.0, data);
//    }
//
//    public static void tagStrategyMetric(TagStrategyMetricDTO tagStrategyMetricDTO){
//        Map<String, Object> metrics = Maps.newHashMap();
//        metrics.put("driver_user_new_id", tagStrategyMetricDTO.getDriverUserNewId());
//        metrics.put("permanent_city", tagStrategyMetricDTO.getPermanentCity());
//        metrics.put("history_attendance_type", tagStrategyMetricDTO.getHistoryAttendanceType());
//        metrics.put("history_receiving_type", tagStrategyMetricDTO.getHistoryReceivingType());
//        metrics.put("history_complete_type", tagStrategyMetricDTO.getHistoryCompleteType());
//        metrics.put("passive_evaluate_type", tagStrategyMetricDTO.getPassiveEvaluateType());
//        metrics.put("passenger_type",tagStrategyMetricDTO.getPassengerType());
//        metrics.put("active_evaluate_type", tagStrategyMetricDTO.getActiveEvaluateType());
//        metrics.put("passenger_user_new_id", tagStrategyMetricDTO.getPassengerUserNewId());
//        metrics.put("grey_result", tagStrategyMetricDTO.getGreyResult());
//        metrics.put("pass_tag_strategy", tagStrategyMetricDTO.getPassTagStrategy());
//        metrics.put("tag_strategy_scene", tagStrategyMetricDTO.getEnumTagStrategyScene().getCode());
//        metrics.put("pax_journey_guid", tagStrategyMetricDTO.getPaxJourneyGuid());
//        com.hellobike.infrastructure.util.NewYunLogger.yun.metric("hitch.avenger.hitch.tag.strategy", 0.0, metrics);
//    }
//
//}
