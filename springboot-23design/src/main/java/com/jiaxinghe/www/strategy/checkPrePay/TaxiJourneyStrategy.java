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
//public class TaxiJourneyStrategy extends AbstractStrategy {
//
//
//    @Autowired
//    private PaymentAndRefundHandler paymentAndRefundHandler;
//
//
//    @Override
//    protected void doExecute(PassengerJourneyDto request) throws PaymentException {
//        // 哈啰打车的行程
//        boolean taxiJourney = Integer.valueOf(EnumPaxJourneyType.TAXI_PASSENGER.getCode()).equals(request.getJourneyType());
//        // 是否后付
//        boolean hasPostPay = paymentAndRefundHandler.isHasPostPay(request.getHasPostPay());
//        // 哈啰打车 预付状态必须是10
//        if (taxiJourney && !hasPostPay && !Integer.valueOf(EnumJourneyStatus.WAIT_RECEIVING.getCode()).equals(request.getOrderStatus())) {
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
