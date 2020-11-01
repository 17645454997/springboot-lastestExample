//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.constant.Consts;
//import com.hellobike.domain.request.BaseABTestRequest;
//
///**
// * @author xianqiugeng
// */
//public class AbTestUtil {
//
//    /**
//     * 接单30分钟有冲突订单，系统自动拼单
//     * @param userNewId
//     * @return
//     */
//    public static BaseABTestRequest receiveOrderWithTimeDurationAbTest(Long userNewId) {
//        BaseABTestRequest abTestRequest = BaseABTestRequest.BaseABTestRequestBuilder.aBaseABTestRequest()
//                .withAbTestUserNewId(userNewId)
//                .withAbTestExecuteKey(Consts.RECEIVE_ORDER_TIME_DURATION_EXECUTE_ABTEST_KEY)
//                .withAbTestExecuteValue(Consts.RECEIVE_ORDER_TIME_DURATION_EXECUTE_ABTEST_VALUE).build();
//        return abTestRequest;
//    }
//
//    /**
//     * 接单30分钟有冲突订单，系统自动拼单
//     * @param userNewId
//     * @return
//     */
//    public static BaseABTestRequest finRateAbTest(Long userNewId) {
//        BaseABTestRequest abTestRequest = BaseABTestRequest.BaseABTestRequestBuilder.aBaseABTestRequest()
//                .withAbTestUserNewId(userNewId)
//                .withAbTestExecuteKey(Consts.RECEIVE_ORDER_LOW_FIN_RATE_ABTEST_KEY)
//                .withAbTestExecuteValue(Consts.RECEIVE_ORDER_LOW_FIN_RATE_ABTEST_VALUE).build();
//        return abTestRequest;
//    }
//
//    /**
//     * 行程详情页低完单率车主预警提示灰度
//     */
//    public static BaseABTestRequest lowFinishRateWarningAbTest(Long userNewId) {
//        BaseABTestRequest abTestRequest = BaseABTestRequest.BaseABTestRequestBuilder.aBaseABTestRequest()
//                .withAbTestUserNewId(userNewId)
//                .withAbTestExecuteKey(Consts.JOURNEY_DETAIL_LOW_FINISH_RATE_WARNING_ABTEST_KEY)
//                .withAbTestExecuteValue(Consts.JOURNEY_DETAIL_LOW_FINISH_RATE_WARNING_ABTEST_VALUE).build();
//        return abTestRequest;
//    }
//
//    /**
//     * 无常用路线，显示地图模式
//     * @param userNewId
//     * @return
//     */
//    public static BaseABTestRequest showMapModelAbTest(Long userNewId){
//        BaseABTestRequest abTestRequest = BaseABTestRequest.BaseABTestRequestBuilder.aBaseABTestRequest()
//                .withAbTestUserNewId(userNewId)
//                .withAbTestExecuteKey(Consts.SHOW_MAP_MODEL_EXECUTE_ABTEST_KEY)
//                .withAbTestExecuteValue(Consts.SHOW_MAP_MODEL_EXECUTE_ABTEST_VALUE).build();
//        return abTestRequest;
//    }
//
//}
