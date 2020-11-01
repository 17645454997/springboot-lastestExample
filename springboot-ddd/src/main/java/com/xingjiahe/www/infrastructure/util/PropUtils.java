//package com.xingjiahe.www.infrastructure.util;
//
//import com.google.common.base.Strings;
//import org.apache.logging.log4j.Logger;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Properties;
//
//public abstract class PropUtils {
//
//    private static Logger logger = LogUtils.COMMON;
//    private static Properties prop;
//
//    static {
//        prop = new Properties();
//        Properties commonProp = loadPropertyFromFile("configs/common.properties");
//        Properties envProp = loadPropertyFromFile("configs/config.properties");
//        prop.putAll(commonProp);
//        prop.putAll(envProp);
//    }
//
//    private static Properties loadPropertyFromFile(String filePath) {
//        Properties properties = new Properties();
//        InputStreamReader in = getPath(filePath);
//        if (in == null) {
//            logger.debug("config.properties does not exists");
//        }
//        try {
//            properties.load(in);
//        } catch (IOException e) {
//            logger.error("load config.properties error:{}", e);
//        } finally {
//            try {
//                in.close();
//            } catch (Exception e) {
//                logger.error("unable to close input stream for file config.properties:{}", e);
//            }
//        }
//
//        return properties;
//    }
//
//    public static String getProperty(String key) {
//        String value = "";
//        if (Strings.isNullOrEmpty(key)) {
//            logger.debug("ConfigProperties:key is null");
//        } else {
//            value = prop.getProperty(key);
//            if (value != null) {
//                value = value.trim();
//            } else {
//                value = "";
//            }
//        }
//        return value;
//    }
//
//    public static int getInt(String key) {
//        return Integer.parseInt(generateValue(key));
//    }
//
//    public static long getLong(String key) {
//        return Long.parseLong(generateValue(key));
//    }
//
//    public static int getInitInt(String key) {
//        String value = "";
//        if (Strings.isNullOrEmpty(key)) {
//            logger.debug("ConfigProperties:key is null");
//        } else {
//            if (prop.getProperty(key) == null) {
//                return 0;
//            }
//            value = prop.getProperty(key).trim();
//        }
//
//        return Integer.parseInt(value);
//    }
//
//    private static InputStreamReader getPath(String path) {
//        String absPath = com.hellobike.infrastructure.util.PropUtils.class.getClassLoader().getResource(path).getPath();
//        logger.debug("config.properties resourcePath:{}", absPath);
//        try {
//            InputStreamReader is = new FileReader(absPath);
//            return is;
//        } catch (FileNotFoundException e) {
//            logger.error("unable to find file:{} , error:{}", absPath, e);
//        }
//
//        return null;
//    }
//
//    private static String generateValue(String key) {
//        String value = "";
//        if (Strings.isNullOrEmpty(key)) {
//            logger.debug("ConfigProperties:key is null");
//        } else {
//            value = prop.getProperty(key);
//            if (value != null) {
//                value = value.trim();
//            } else {
//                value = "0";
//            }
//        }
//
//        return value;
//    }
//
//}
