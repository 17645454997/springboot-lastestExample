//package com.jiaxinghe.www.strategy.checkPrePay;
//
//import com.alibaba.fastjson.JSON;
//import com.hellobike.base.proto.Protos;
//import com.hellobike.base.proto.error.BizError;
//import com.hellobike.biz.request.Result;
//import com.hellobike.hitchjourney.dto.detail.PassengerJourneyDto;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import com.hellobike.hitchjourney.enums.journey.EnumJourneyStatus;
//import com.hellobike.infrastructure.service.impl.pay.handler.PaymentAndRefundHandler;
//import com.hellobike.infrastructure.util.LogUtils;
//import com.hellobike.infrastructure.util.PaymentException;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
///**
// * @author  hejiaxing
// * @desc
// */
//
//public abstract class AbstractStrategy  implements com.hellobike.infrastructure.strategy.prepay.Strategy {
//
//    @Autowired
//    private PaymentAndRefundHandler paymentAndRefundHandler;
//
//    @Override
//    public Result execute(PassengerJourneyDto request) {
//
//        Result result = null;
//        try {
//            // 前置处理
//            beforeExecute(request);
//            // 核心逻辑
//           doExecute(request);
//        } catch (PaymentException e) {
//            result = Result.fail(e.getProto().getCode(), e.getMessage(), e);
//        } catch (Exception e) {
//            LogUtils.ERROR.error("strategy execute failed, unexpected error, request:{}", JSON.toJSONString(request), e);
//            result = Result.fail(BizError.SYSTEM_ERROR.getCode(), BizError.SYSTEM_ERROR.getMsg(), e);
//        } finally {
//            try {
//                // 后置处理
//                afterExecute(request);
//            } catch (Throwable e) {
//                LogUtils.ERROR.error("strategy after execute failed, request:{}, result:{}", JSON.toJSONString(request), result, e);
//            }
//        }
//        return result;
//
//    }
//
//
//    /**
//     * 前置处理，失败则终止策略
//     * @param request
//     * @param
//     */
//    protected  void beforeExecute(PassengerJourneyDto request) throws PaymentException {
//        if (Integer.valueOf(EnumJourneyStatus.CANCELED.getCode()).equals(request.getOrderStatus())) {
//            throw new PaymentException(Protos.ORDER_CANCELED);
//        }
//        //是否后付
//        boolean hasPostPay = paymentAndRefundHandler.isHasPostPay(request.getHasPostPay());
//        // 哈啰打车的行程
//        boolean taxiJourney = Integer.valueOf(EnumPaxJourneyType.TAXI_PASSENGER.getCode()).equals(request.getJourneyType());
//
//        // 快送发单预付行程
//        boolean deliverPrePayJourney = Integer.valueOf(EnumPaxJourneyType.HITCH_GOODS.getCode()).equals(request.getJourneyType())
//                && Integer.valueOf(EnumJourneyStatus.WAIT_PUBLISH_ORDER_PAY.getCode()).equals(request.getOrderStatus());
//        //顺风车发单预付行程
//        boolean hitchPublishPrePay = Integer.valueOf(EnumPaxJourneyType.HITCH_PASSENGER.getCode()).equals(request.getJourneyType())
//                && request.isHitchPublishPreUnPaid()
//                && Integer.valueOf(EnumJourneyStatus.WAIT_RECEIVING.getCode()).equals(request.getOrderStatus());
//        if (!taxiJourney && !deliverPrePayJourney && !hitchPublishPrePay
//                && (Integer.valueOf(EnumJourneyStatus.WAIT_RECEIVING.getCode()).equals(request.getOrderStatus())
//                || StringUtils.isEmpty(request.getDriverJourneyGuid()))) {
//            throw new PaymentException(Protos.ORDER_NOT_RECEVIED);
//        }
//
//        // 后付状态不是60
//        if (hasPostPay && !Integer.valueOf(EnumJourneyStatus.ARRIVAL.getCode()).equals(request.getOrderStatus())) {
//            throw new PaymentException(Protos.INVALID_STATUS_FOR_PAY);
//        }
//        // 预付状态不是20
//        if (!deliverPrePayJourney && !taxiJourney && !hasPostPay && !hitchPublishPrePay
//                && !Integer.valueOf(EnumJourneyStatus.WAIT_PAY.getCode()).equals(request.getOrderStatus())) {
//            throw new PaymentException(Protos.INVALID_STATUS_FOR_PAY);
//        }
//
//    }
//
//    /**
//     * 核心逻辑
//     * @param request
//     * @param
//     * @return
//     */
//    protected abstract void doExecute(PassengerJourneyDto request) throws PaymentException;
//
//    /**
//     * 后置处理
//     * @param request
//     *
//     */
//    protected abstract void afterExecute(PassengerJourneyDto request);
//}
