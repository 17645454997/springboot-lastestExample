//package com.jiaxinghe.www.strategy.checkPrePay;
//
//
//import com.hellobike.hitchjourney.dto.detail.PassengerJourneyDto;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import com.hellobike.infrastructure.util.BeanUtils;
//
///**
// * @author  hejiaxing
// * @desc
// */
//
//public class StrategyFactory {
//
//    /**
//     * 获取检查策略
//     * @param request
//     * @return
//     */
//    public static com.hellobike.infrastructure.strategy.prepay.Strategy getStrategy(PassengerJourneyDto request) {
//        EnumPaxJourneyType journeyType = EnumPaxJourneyType.parse(request.getJourneyType());
//        if (journeyType == null) {
//            return null;
//        }
//        switch (journeyType) {
//            case HITCH_PASSENGER:
//                return BeanUtils.getBean("HitchJourneyStrategy", HitchJourneyStrategy.class);
//            case TAXI_PASSENGER:
//                return BeanUtils.getBean("TaxiJourneyStrategy", TaxiJourneyStrategy.class);
//            case HITCH_GOODS:
//                return BeanUtils.getBean("DeliverJourneyStrategy", DeliverJourneyStrategy.class);
//            default:
//                return null;
//        }
//    }
//}
