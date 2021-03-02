//package com.jiaxinghe.www.strategy.checkPrePay;
//
//
//import com.hellobike.base.proto.Protos;
//import com.hellobike.hitchjourney.dto.detail.PassengerJourneyDto;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import com.hellobike.hitchjourney.enums.journey.EnumJourneyStatus;
//import com.hellobike.infrastructure.service.impl.pay.handler.PaymentAndRefundHandler;
//import com.hellobike.infrastructure.util.PaymentException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @author  hejiaxing
// * @desc
// */
//
//@Component
//public class DeliverJourneyStrategy extends com.hellobike.infrastructure.strategy.prepay.AbstractStrategy {
//
//    @Autowired
//    private PaymentAndRefundHandler paymentAndRefundHandler;
//
//
//    @Override
//    protected void doExecute(PassengerJourneyDto request) throws PaymentException {
//
//        //是否后付
//        boolean hasPostPay = paymentAndRefundHandler.isHasPostPay(request.getHasPostPay());
//        // 快送发单预付行程
//        boolean deliverPrePayJourney = Integer.valueOf(EnumPaxJourneyType.HITCH_GOODS.getCode()).equals(request.getJourneyType())
//                && Integer.valueOf(EnumJourneyStatus.WAIT_PUBLISH_ORDER_PAY.getCode()).equals(request.getOrderStatus());
//        // 快送 发单预付必须是5
//        if (deliverPrePayJourney && !hasPostPay && !Integer.valueOf(EnumJourneyStatus.WAIT_PUBLISH_ORDER_PAY.getCode()).equals(request.getOrderStatus())) {
//            throw new PaymentException(Protos.INVALID_STATUS_FOR_PAY);
//        }
//
//    }
//
//    @Override
//    protected void afterExecute(PassengerJourneyDto request) {
//
//    }
//}
