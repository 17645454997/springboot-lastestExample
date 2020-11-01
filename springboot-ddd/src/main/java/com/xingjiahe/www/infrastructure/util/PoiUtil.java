//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.constant.Consts;
//import com.hellobike.enums.EnumPOIType;
//
///**
// * @author xianqiugeng
// */
//public class PoiUtil {
//
//    public static String getPoi(String[] poiTypes) {
//
//        String poi_type_1 = "";
//        String poi_type_2 = "";
//        if (poiTypes != null) {
//            if (poiTypes.length == 1){
//                poi_type_1 = poiTypes[0];
//            } else if (poiTypes.length >= 2) {
//                poi_type_1 = poiTypes[0];
//                poi_type_2 = poiTypes[1];
//            }
//        }
//        String poi = EnumPOIType.OTHER.getCode();
//        if (poi_type_1.equals(Consts.TRAFFIC_INSTALLATION)) {
//            poi = EnumPOIType.DEPOT.getCode();
//        } else if (poi_type_1.equals(Consts.COMPANY_ENTERPRISE)) {
//            poi = EnumPOIType.COMPANY.getCode();
//        } else if (poi_type_1.equals(Consts.SCIENCE_EDUCATION_CULTURE_SERVICE)) {
//            poi = EnumPOIType.SCHOOL.getCode();
//        } else if (poi_type_1.equals(Consts.COMMERCIAL_HOUSE)) {
//            if (poi_type_2.equals(Consts.HOUSE_AREA)) {
//                poi = EnumPOIType.HOUSE.getCode();
//            } else {
//                poi = EnumPOIType.COMPANY.getCode();
//            }
//        }
//        return poi;
//    }
//}
