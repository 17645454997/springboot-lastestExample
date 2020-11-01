package com.xingjiahe.www.infrastructure.util;

public class MainlandUtils {

    public static boolean isMainland(String lon, String lat) {
        try {
            return Double.parseDouble(lon) > 73.564453 && Double.parseDouble(lon) < 135.615234 && Double.parseDouble(lat) > 17.3925792 && Double.parseDouble(lat) < 53.852526;
        } catch (Exception e) {
            LogUtils.ERROR.error("MainlandUtils.isMainland exception, lon {}, lat {}", lon, lat, e);
        }

        return false;
    }

    public static boolean isMainland(Double lon, Double lat) {
        try {
            return lon > 73.564453 && lon < 135.615234 && lat > 17.3925792 && lat < 53.852526;
        } catch (Exception e) {
            LogUtils.ERROR.error("MainlandUtils.isMainland exception, lon {}, lat {}", lon, lat, e);
        }

        return false;
    }
}
