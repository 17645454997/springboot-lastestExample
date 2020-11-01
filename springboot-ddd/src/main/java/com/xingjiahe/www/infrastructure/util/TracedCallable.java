//package com.xingjiahe.www.infrastructure.util;
//
//import com.carkey.etrack.Etrack;
//import com.carkey.etrack.Pack;
//
//import java.util.concurrent.Callable;
//
///**
// * Description
// * Copyright HelloBike
// *
// * @author limingjun
// * @version 1.0
// * @date 2019/11/26
// */
//public abstract class TracedCallable<V> implements Callable<V> {
//
//    private Pack pack = Etrack.exportPack();
//
//    @Override
//    public V call() throws Exception {
//        Etrack.importPack(pack);
//        return doCall();
//    }
//
//    public abstract V doCall() throws Exception;
//}
