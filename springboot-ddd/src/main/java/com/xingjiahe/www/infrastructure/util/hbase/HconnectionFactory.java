//package com.xingjiahe.www.infrastructure.util.hbase;
//
//
//import com.hellobike.hbase.core.HBaseApplication;
//import com.hellobike.infrastructure.util.LogUtils;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//
//@Configuration
//public class HconnectionFactory {
//
//    @PostConstruct
//    public void init() {
//        try {
//            HBaseApplication.start();
//        } catch (IOException e) {
//            LogUtils.ERROR.error("hbase客户端初始化失败", e);
//            System.exit(0);
//        }
//    }
//}