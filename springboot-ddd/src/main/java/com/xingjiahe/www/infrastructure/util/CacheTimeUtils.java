package com.xingjiahe.www.infrastructure.util;

/**
 * create yushiwei
 * <p>
 * on 2019-01-25
 */
public class CacheTimeUtils {

    private static final int oneMinute = 1 * 60;
    private static final int towMinute = 2 * 60;
    private static final int fiveMinute = 5 * 60;
    private static final int tenMinute = 10 * 60;
    private static final int thirtyMinute = 30 * 60;
    private static final int oneHour = 60 * 60;
    private static final int oneDay = 24 * 60 * 60;
    private static final int twoDay = 48 * 60 * 60;
    private static final int sevenDay = 7 * 24 * 60 * 60;
    private static final int oneMonth = 31 * 24 * 60 * 60;

    public static int getTwoDayCacheSecond(){
        return twoDay;
    }

    public static int getOneMinuteCacheSecond() {
        return oneMinute;
    }

    public static int getTowMinuteCacheSecond() {
        return towMinute;
    }

    public static int getFiveMinuteCacheSecond() {
        return fiveMinute;
    }

    public static int getTenMinuteCacheSecond() {
        return tenMinute;
    }

    public static int getThirtyMinuteCacheSecond() {
        return thirtyMinute;
    }

    public static int getOneMonthCacheSecond(){
        return oneMonth;
    }

    public static int getOneHourCacheSecond() {
        return oneHour;
    }

    public static int getOneDayCacheSecond() {
        return oneDay;
    }

    public static int getSevenDayCacheSecond() {
        return sevenDay;
    }

    public static void main(String[] args) {
        System.out.println((int) oneMinute);
    }
}
