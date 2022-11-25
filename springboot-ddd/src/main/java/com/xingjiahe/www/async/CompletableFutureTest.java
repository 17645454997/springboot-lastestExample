package com.xingjiahe.www.async;

import org.springframework.util.StopWatch;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/24 3:52 PM
 */
public class CompletableFutureTest {
    public static void main(String args[]) throws Exception {
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
         StopWatch watch = new StopWatch();
         watch.start();
         Long userId = 1238983131L;
         //换成公司的线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<UserInfo>  completableUserInfoFuture  =  CompletableFuture.supplyAsync(()-> userInfoService.getUserInfo(userId),executor)
                .exceptionally(e->{
                    //异常处理
                    return null;
                });

        CompletableFuture<UserInfo> resCompletableFuture = completableUserInfoFuture.whenComplete(((userInfo, throwable) -> {
            if (Objects.nonNull(userInfo) && userId.equals(userInfo.getUserId())) {
               //更新数据信息
            }
        }));
        watch.stop();
        System.out.println(watch.getTotalTimeMillis());
        System.out.println("开始执行了");
        Thread.sleep(3000);
        CompletableFuture<MedalInfo> completableMedalInfoFuture = CompletableFuture.supplyAsync(() -> medalService.getMedalInfo(userId));
        UserInfo userInfo = completableUserInfoFuture.get(2, TimeUnit.SECONDS);
        MedalInfo medalInfo = completableMedalInfoFuture.get();
        System.out.println(resCompletableFuture.get());
        System.out.println(userInfo.getUserId());
        System.out.println(medalInfo.getUserId());
        System.out.println(watch.getTotalTimeMillis());
    }
}
