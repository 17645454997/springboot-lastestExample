//package com.xingjiahe.www.infrastructure.util;
//
//import com.carkey.etrack.Etrack;
//import com.carkey.etrack.Pack;
//
///**
// * Description
// * Copyright HelloBike
// *
// * @author zhaofei
// * @version 1.0
// * @date 2019/12/04
// */
//public abstract class TracedRunnable implements Runnable {
//
//    private Pack pack = Etrack.exportPack();
//
//    @Override
//    public void run() {
//        Etrack.importPack(pack);
//
//        doRun();
//    }
//
//    public abstract void doRun();
//}