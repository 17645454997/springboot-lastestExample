//package com.xingjiahe.www.infrastructure.util;
//
///**
// * @author xianqiugeng
// */
//public class DistanceUtil {
//
//    public static final double TO_RADIANS = 0.017453292519943295D;
//    public static final double EARTH_MEAN_RADIUS = 6371008.7714D;
//
//    /**
//     * 曼哈顿距离
//     */
//    public static Integer getMHTDistance(double startLon, double startLat, double endLon, double endLat) {
//        double x = (startLon - endLon) * com.hellobike.infrastructure.util.DistanceUtil.TO_RADIANS * Math.cos((startLat + endLat) / 2.0 * com.hellobike.infrastructure.util.DistanceUtil.TO_RADIANS);
//        double y = (startLat - endLat) * com.hellobike.infrastructure.util.DistanceUtil.TO_RADIANS;
//        return Double.valueOf((Math.abs(x) + Math.abs(y)) * com.hellobike.infrastructure.util.DistanceUtil.EARTH_MEAN_RADIUS).intValue();
//    }
//}
