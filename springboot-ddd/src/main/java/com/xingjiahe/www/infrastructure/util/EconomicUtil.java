//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.constant.Consts;
//import com.hellobike.hitch.consts.JourneyType;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import org.apache.commons.collections4.CollectionUtils;
//
//import java.util.List;
//import java.util.Objects;
//
//import static com.hellobike.constant.Consts.ECONOMIC_CAR_FIRST_VERSION;
//
///**
// * @author mason.ke
// * @version 1.0.0
// * @date 2020/5/13
// */
//public class EconomicUtil {
//    /**
//     * 如果app版本低于即时单版本journeyType由3转1（即时单转为顺风车）
//     * @param versionStr
//     * @return
//     */
//    public static Integer convertJourneyType(String versionStr,Integer journeyType){
//        Integer newType=journeyType;
//        //不为即时单直接返回
//        if(Objects.isNull(journeyType)||journeyType!= EnumPaxJourneyType.HITCH_PASSENGER_INSTANT.getCode()){
//            return newType;
//        }
//        //不传版本号兜底
//        if(Objects.isNull(versionStr)){
//            return EnumPaxJourneyType.HITCH_PASSENGER.getCode();
//        }
//        int version = com.hellobike.infrastructure.util.VersionUtils.getVersionNo(versionStr);
//        if (version < com.hellobike.infrastructure.util.ApolloConfigUtil.getCommonIntProperty(ECONOMIC_CAR_FIRST_VERSION,Consts.ECONOMY_CAR_VERSION)) {
//            newType=EnumPaxJourneyType.HITCH_PASSENGER.getCode();
//        }
//        return newType;
//    }
//
//    /**
//     * 即时单、顺风送兼容老版本
//     *
//     * @param versionStr
//     * @param journeyTypes
//     * @return
//     */
//    public static List<Integer> parseJourneyType(String versionStr, List<Integer> journeyTypes) {
//        if (CollectionUtils.isEmpty(journeyTypes)) {
//            journeyTypes = Lists.newArrayList(JourneyType.PASSENGER.getCode(), JourneyType.ECONOMY_CAR.getCode());
//        } else {
//            if (Objects.isNull(versionStr)) {
//                return journeyTypes;
//            }
//            int version = com.hellobike.infrastructure.util.VersionUtils.getVersionNo(versionStr);
//            // 如果当前版本号低于经济车版本，要补经济车类型
//            if (version < com.hellobike.infrastructure.util.ApolloConfigUtil.getCommonIntProperty(ECONOMIC_CAR_FIRST_VERSION,Consts.ECONOMY_CAR_VERSION)) {
//                if (journeyTypes.contains(JourneyType.PASSENGER.getCode()) && !journeyTypes.contains(JourneyType.ECONOMY_CAR.getCode())) {
//                    // 增加即时单类型
//                    journeyTypes.add(JourneyType.ECONOMY_CAR.getCode());
//                }
//            }
//        }
//        return journeyTypes;
//    }
//
//}
