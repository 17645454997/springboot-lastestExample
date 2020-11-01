//package com.xingjiahe.www.infrastructure.util.redis;
//
//import com.hellobike.service.DriverJourneyService;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @Author: yangyl
// * @Date: 2018/12/23
// */
//@Component
//public class Subscriber implements InitializingBean {
//
//    @Resource
//    private DriverJourneyService driverJourneyService;
//
//    @Override
//    public void afterPropertiesSet() {
//        // 司机发布行程取消的监听
////        RedisClientManagement.getInstance().psubscribe((message, pattern) -> {
////            CancelJourneyRequest cancelJourneyRequest = new CancelJourneyRequest();
////            cancelJourneyRequest.setCancelReason("系统自动取消");
////            cancelJourneyRequest.setDriverJourneyGuid(message.getBody().split(":")[1]);
////            driverJourneyService.systemCancel(cancelJourneyRequest);
////        }, new RouteKey("driverAutoCancelKey"), "__keyspace@1__:passengerUnpaidExpired:*");
//    }
//
//}
//
//
