//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.yukon.core.LoggerTrack;
//import com.hellobike.yukon.core.YukonLoggerFactory;
//
//import java.util.Map;
//
//public abstract class NewYunLogger {
//
//    private static LoggerTrack loggerTrack = YukonLoggerFactory.getLogger("hitch-driver-new");
//
//    public static class YunLoggerTask {
//        public void metric(String key, double value, Map<String, Object> logMap) {
//            ThreadPools.getInstance().submitLoggerTask(new Runnable() {
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