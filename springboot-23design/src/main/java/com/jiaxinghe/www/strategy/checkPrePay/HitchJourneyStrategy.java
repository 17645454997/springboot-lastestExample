//package com.jiaxinghe.www.strategy.checkPrePay;
//
//import com.hellobike.base.proto.Protos;
//import com.hellobike.hitchjourney.dto.detail.PassengerJourneyDto;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import com.hellobike.hitchjourney.enums.journey.EnumJourneyStatus;
//import com.hellobike.infrastructure.service.impl.pay.handler.PaymentAndRefundHandler;
//import com.hellobike.infrastructure.util.PaymentException;
//import com.jiaxinghe.www.strategy.checkPrePay.AbstractStrategy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @author  hejiaxing
// * @desc
// */
//@Component
//public class HitchJourneyStrategy extends AbstractStrategy {
//
//    @Autowired
//    private PaymentAndRefundHandler paymentAndRefundHandler;
//
//    @Override
//    protected void doExecute(PassengerJourneyDto request) throws PaymentException {
//        //是否后付
//        boolean hasPostPay = paymentAndRefundHandler.isHasPostPay(request.getHasPostPay());
//        //顺风车发单预付行程
//        boolean hitchPublishPrePay = Integer.valueOf(EnumPaxJourneyType.HITCH_PASSENGER.getCode()).equals(request.getJourneyType())
//                && request.isHitchPublishPreUnPaid()
//                && Integer.valueOf(EnumJourneyStatus.WAIT_RECEIVING.getCode()).equals(request.getOrderStatus());
//        // 顺风车 发单预付必须是10
//        if (hitchPublishPrePay && !hasPostPay && !Integer.valueOf(EnumJourneyStatus.WAIT_RECEIVING.getCode()).equals(request.getOrderStatus())) {
//            throw new PaymentException(Protos.INVALID_STATUS_FOR_PAY);
//        }
//
//    }
//
//
//    @Override
//    protected void afterExecute(PassengerJourneyDto request) {
//
//    }
//}
