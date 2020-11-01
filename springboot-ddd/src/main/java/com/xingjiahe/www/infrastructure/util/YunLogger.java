//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.yukon.core.LoggerTrack;
//import com.hellobike.yukon.core.YukonLoggerFactory;
//
//import java.util.Map;
//
//public abstract class YunLogger {
//
//    private static LoggerTrack loggerTrack = YukonLoggerFactory.getLogger("hitch-driver");
//
//    public static class YunLoggerTask {
//        public void metric(String key, double value, Map<String, Object> logMap) {
//            com.hellobike.infrastructure.util.ThreadPools.getInstance().submitLoggerTask(new Runnable() {
//                @Override
//                public void run() {
//                    loggerTrack.metric(key, value, logMap);
//                }
//            });
//
//        }
//    }
//
//    public final static YunLoggerTask yun = new YunLoggerTask();
//}