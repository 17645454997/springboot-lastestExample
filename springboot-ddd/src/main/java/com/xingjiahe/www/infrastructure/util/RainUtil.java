//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.constant.Consts;
//import com.hellobike.enums.EnumRainType;
//import com.hellobike.infrastructure.util.hbase.HBaseUtil;
//import org.apache.hadoop.hbase.Cell;
//import org.apache.hadoop.hbase.CellUtil;
//import org.apache.hadoop.hbase.client.Result;
//
//import java.util.List;
//
///**
// * @author xianqiugeng
// */
//public class RainUtil {
//
//    public static int getRainType(String adCode, String stamp) {
//        int wType = EnumRainType.CLOUDY_SUNNY.getCode();
//        try {
//            List<Result> results = HBaseUtil.get(Consts.HBASE_QUERY_WEATHER_TABLE_NAME, adCode.concat(Consts.UNDERLINE).concat(stamp));
//            if (results == null || results.size() == 0) {
//                com.hellobike.infrastructure.util.LogUtils.COMMON.debug("getRainType #hbase return null...");
//                return wType;
//            }
//            Cell[] cells = results.get(0).rawCells();
//            String weather = Consts.WeatherType.CLOUDY;
//            for (Cell cell : cells) {
//                String cellValue = new String(CellUtil.cloneValue(cell));
//                String cellQualifier = new String(CellUtil.cloneQualifier(cell));
//                if (Consts.WEATHER.equals(cellQualifier)) {
//                    weather = cellValue;
//                    break;
//                }
//            }
//            switch (weather) {
//                case Consts.WeatherType.CLOUDY:
//                case Consts.WeatherType.CLOUDY_V2:
//                case Consts.WeatherType.SUNNY:
//                    wType = EnumRainType.CLOUDY_SUNNY.getCode();
//                    break;
//                case Consts.WeatherType.LIGHT_RAIN:
//                    wType = EnumRainType.LIGHT_RAIN.getCode();
//                    break;
//                case Consts.WeatherType.RAIN:
//                    wType = EnumRainType.RAIN.getCode();
//                    break;
//                case Consts.WeatherType.HEAVY_RAIN:
//                    wType = EnumRainType.HEAVY_RAIN.getCode();
//                    break;
//                case Consts.WeatherType.TORRENTIAL_RAIN:
//                case Consts.WeatherType.TORRENTIAL_RAIN_II:
//                case Consts.WeatherType.TORRENTIAL_RAIN_III:
//                    wType = EnumRainType.TORRENTIAL_RAIN.getCode();
//                    break;
//                default:
//                    wType = EnumRainType.OTHER.getCode();
//            }
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("Query weather info error:{}", e);
//        }
//        return wType;
//    }
//}
