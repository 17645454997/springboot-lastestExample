//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.aiplatform.aibrian.hitch.bounty.model.dto.ReceiveBountyDTO;
//import com.hellobike.base.hammer.concurrent.HamExecutors;
//import com.hellobike.base.hammer.concurrent.HamThreadFactory;
//import com.hellobike.hitch.user.dto.DriverFinishDetailDTO;
//import com.hitch.rewarduse.service.model.driver.HitchDriverBonusComBO;
//import org.apache.commons.lang.exception.ExceptionUtils;
//
//import java.util.Map;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * 线程池添加task时的执行过程：
// * 1. 如果池中线程数小于核心线程数，直接创建一个线程入池并执行此task
// * 2. 如果池中线程数大于或等于核心线程数，则判断队列中task数量：
// * <1>如果队列中task数量未达到队列容量，则task直接进队列（不创建新线程，因为线程是很重的资源，能不新建就不新建，例外情况是
// * 如果核心线程数是0，则新建一个线程）
// * <2>如果队列中task数量达到队列最大容量，且池中线程数量未达到最大线程数，则创建一个线程入池，并用此线程执行
// * 此task（注意，是直接执行本次要添加的task，而不是从队列里拿task）
// * <3>如果队列中task数量达到队列最大容量，且池中线程数量达到最大线程数，则根据指定的RejectPolicy来决定：
// * CallerRunsPolicy: 用提交task的线程来执行此task，不扔RejectedExecutionException
// * AbortPolicy: 直接丢弃此task，扔RejectedExecutionException; 此策略为未指定RejectedExecutionHandler时的默认策略
// * DiscardPolicy: 直接丢弃此task，不扔RejectedExecutionException
// * DiscardOldestPolicy: 丢弃队列中最老的task，并将此task放入队尾，不扔RejectedExecutionException
// * 线程池构造函数：
// * int corePoolSize,                   核心线程数
// * int maximumPoolSize,                最大线程数
// * long keepAliveTime,                 线程闲置时保持存活的时间数量
// * TimeUnit unit,                      线程闲置时保持存活的时间单位
// * BlockingQueue<Runnable> workQueue,  线程任务队列
// * ThreadFactory threadFactory,        线程池用于创建线程的工厂类
// * RejectedExecutionHandler handler    线程池满且队列满时的任务提交策略
// *
// * @author jiangwei
// */
//
//public class ThreadPools {
//
//    /**
//     * 拒绝并抛出异常
//     */
//    private static final RejectedExecutionHandler ABORT = new ThreadPoolExecutor.AbortPolicy();
//    /**
//     * 调用线程执行
//     */
//    private static final RejectedExecutionHandler CALLER_RUN = new ThreadPoolExecutor.CallerRunsPolicy();
//    /**
//     * 抛弃
//     */
//    private static final RejectedExecutionHandler DISCARD = new ThreadPoolExecutor.DiscardPolicy();
//
//    //tcp推送
//    private ExecutorService tcpNotifyMsgPool;
//
//    private ExecutorService logPool;
//
//    private ExecutorService driverAuditNotifyPool;
//
//    private ExecutorService httpNotifyMsgPool;
//
//    private ExecutorService journeyStatusChangePool;
//
//    private ExecutorService driverMatchPassengerPool;
//
//    private ExecutorService pushPool;
//
//    private ExecutorService delayPool;
//
//    private ExecutorService unbindPool;
//
//    private ExecutorService delayForDirectPool;
//
//    private ExecutorService unbindForDirectPool;
//
//    private ExecutorService smsPool;
//
//    private ExecutorService storeDriverPool;
//
//    private ExecutorService dataRefreshSexPool;
//
//    private ExecutorService journeyCounterPool;
//
//    private ExecutorService govPushPool;
//
//    private ExecutorService bountyPool;
//
//    private ExecutorService creditPool;
//
//    private ExecutorService changeBindPool;
//
//    private ExecutorService changeDriverDiscountPool;
//
//    private ExecutorService reportLocationPool;
//
//    private ExecutorService planStartTimeNotifyPool;
//
//    private ExecutorService saveToHbasePool;
//
//    private ExecutorService waitByCarDelayNotifyPool;
//
//    private ExecutorService sendDelayMsgPool;
//
//    private ExecutorService arrivePaxStartNotifyPool;
//
//    private ExecutorService heartbeatUploadPool;
//
//    private ExecutorService driverTcpNotifyPoll;
//
//    private ExecutorService asynNotifyDriverBack;
//
//    private ExecutorService historyDestinationUpdatePool;
//
//    private ExecutorService removeMatchOrderPool;
//
//    /**
//     * HamExecutorService封装了ThreadPoolExecutor，支持自动完成串联调用链
//     */
//    private ExecutorService saveJourneyStreetPool;
//
//    private ExecutorService satisfyTogetherPool;
//
//    private ExecutorService effectiveStartPool;
//
//    private ExecutorService effectiveEndPool;
//
//    private ExecutorService effectiveDelayPool;
//
//    private ExecutorService shiftOrStayPool;
//
//    private ExecutorService receiveProbabilityPool;
//
//    /**
//     * 接单返回需要人脸识别时调用后付风控接口线程池
//     */
//    private ExecutorService preRiskPostPayInvokePool;
//
//    /**
//     * 接单风控接口线程池
//     */
//    private ExecutorService receiveOrderRiskCheckPool;
//
//    /**
//     * 接单时调后付检测线程池
//     */
//    private ExecutorService postPayCheckPool;
//
//    private ExecutorService sendHmsPool;
//
//    private ExecutorService weChatTagPool;
//
//    private ExecutorService healthPool;
//
//    private ExecutorService finRatePool;
//
//    /**
//     * 图片风控线程池
//     */
//    private ExecutorService imageRiskPool;
//
//    private ExecutorService asyncFireDelayMsgPool;
//
//    /**
//     * 检查IM内容为了引导发快送订单的线程池
//     */
//    private ExecutorService asyncCheckIMForGuideDeliverPool;
//
//    private ExecutorService removeFinishedJourneyCachePool;
//
//    private static class ThreadPoolManagerHolder {
//        public static com.hellobike.infrastructure.util.ThreadPools instance = new com.hellobike.infrastructure.util.ThreadPools();
//    }
//
//    public static com.hellobike.infrastructure.util.ThreadPools getInstance() {
//        return ThreadPoolManagerHolder.instance;
//    }
//
//    private ThreadPools() {
//        asyncFireDelayMsgPool = newThreadPool(4, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100000), new NamedThreadFactory("DELAY_MSG"), CALLER_RUN);
//
//        asyncCheckIMForGuideDeliverPool = newThreadPool(4, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(2048), new NamedThreadFactory("CHECK_IM_FOR_GUIDE_DELIVER"), ABORT);
//
//        historyDestinationUpdatePool = newThreadPool(2, 32, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100000), new NamedThreadFactory("HISTORY_DESTINATION"), DISCARD);
//
//        logPool = newThreadPool(1, 8, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(2048), new NamedThreadFactory("LOGGER"));
//
//        tcpNotifyMsgPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("TCP_NOTIFY"));
//
//        driverAuditNotifyPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("DRIVER_AUDIT_NOTIFY"));
//
//        httpNotifyMsgPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1024), new NamedThreadFactory("HTTP_NOTIFY"));
//
//        journeyStatusChangePool = newThreadPool(2, 32, 32, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5000), new NamedThreadFactory("JOURNEY_STATUS_CHANGE_POOL"));
//
//        driverMatchPassengerPool = newThreadPool(10, 20, 32, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5000), new NamedThreadFactory("DRIVER_MATCH_PAX_CHANGE_POOL"));
//
//        pushPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("DRIVER_PUSH"));
//
//        delayPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10240), new NamedThreadFactory("DELAY"));
//
//        unbindPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10240), new NamedThreadFactory("UNBIND_DELAY_FOR_DIRECT"));
//
//        delayForDirectPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10240), new NamedThreadFactory("UNBIND_DELAY_FOR_DIRECT"));
//
//        unbindForDirectPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10240), new NamedThreadFactory("DELAY"));
//
//        smsPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("SMS"));
//
//        journeyCounterPool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("JOURNEY_COUNTER"));
//
//        storeDriverPool = newThreadPool(0, 6, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100000), new NamedThreadFactory("STORE_DRIVER_INFO"));
//
//        dataRefreshSexPool = newThreadPool(0, 6, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100000), new NamedThreadFactory("doRefreshSex"));
//
//        govPushPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1024), new NamedThreadFactory("GOV_PUSH"));
//
//        bountyPool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100000), new HamThreadFactory("BOUNTY_POOL"));
//
//        creditPool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100000), new NamedThreadFactory("CREDIT_POOL"));
//
//        changeBindPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("MOBILE_CHANGE_BIND_POOL"));
//
//        changeDriverDiscountPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("MOBILE_CHANGE_DRIVER_DISCOUNT_POOL"));
//
//        planStartTimeNotifyPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("planStartTimeNotifyPool"));
//
//        effectiveDelayPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("effectiveDelayNotifyPool"));
//
//        removeFinishedJourneyCachePool = newThreadPool(4, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(2048), new NamedThreadFactory("REMOVE_FINISHED_JOURNEY_CACHE"), DISCARD);
//
//        saveToHbasePool = newThreadPool(2, 20, 15, TimeUnit.MINUTES,
//                new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("saveToHbasePool"),
//                new RejectedExecutionHandler() {
//                    @Override
//                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
//                        com.hellobike.infrastructure.util.LogUtils.ERROR.error("save hbase for journey's position  handle is timeout");
//                    }
//                });
//
//        //实例化待乘客确认上车线程池
//        waitByCarDelayNotifyPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1024), new NamedThreadFactory("DELAY_NOTIFY_WAIT_BY_CAR_POOL"));
//
//        reportLocationPool = newThreadPool(4, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("REPORT_LOCATION"));
//
//        sendDelayMsgPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("REPORT_LOCATION"));
//
//        arrivePaxStartNotifyPool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(50000),
//                new NamedThreadFactory("ARRIVE_PAX_START"), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
//                com.hellobike.infrastructure.util.LogUtils.ERROR.error("arrivePaxStartNotify handle for journey position is timeout");
//            }
//        });
//
//        heartbeatUploadPool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10000),
//                new NamedThreadFactory("HEART_BEAT_UPLOAD"), DISCARD);
//
//        driverTcpNotifyPoll = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10000),
//                new NamedThreadFactory("DRIVER_TCP_NOTIFY"), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
//                com.hellobike.infrastructure.util.LogUtils.ERROR.error("SatisfyTogether tcp handle is timeout");
//            }
//        });
//
//        satisfyTogetherPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10000),
//                new NamedThreadFactory("SATISFY_TOGETHER_NOTIFY"), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
//                com.hellobike.infrastructure.util.LogUtils.ERROR.error("SatisfyTogether tcp handle is timeout");
//            }
//        });
//
//        effectiveStartPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10000),
//                new NamedThreadFactory("EFFECTIVE_START_NOTIFY"), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
//                com.hellobike.infrastructure.util.LogUtils.ERROR.error("effective start handle is timeout");
//            }
//        });
//
//        effectiveEndPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10000),
//                new NamedThreadFactory("EFFECTIVE_END_NOTIFY"), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
//                com.hellobike.infrastructure.util.LogUtils.ERROR.error("effective end handle is timeout");
//            }
//        });
//
//        asynNotifyDriverBack = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("asynNotifyDriverBackPool"));
//
//        //处理rpc调用匹配服务取消行程任务
//        removeMatchOrderPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new HamThreadFactory("REMOVE_ORDER_FOR_MATCH_POOL"), CALLER_RUN);
//
//        //处理乘客发布行程异步保存街道信息任务
//        saveJourneyStreetPool = newThreadPool(2, 8, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new HamThreadFactory("DRIVER_SAVE_JOURNEY_STREET_POOL"));
//
//        //偏移，停留埋点
//        shiftOrStayPool = newThreadPool(2, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("shiftOrStayPool"));
//
//        receiveProbabilityPool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1024), new NamedThreadFactory("receiveProbabilityPool"));
//
//        //接单返回需要人脸识别时调用后付风控接口线程池
//        preRiskPostPayInvokePool = newThreadPool(8, 32, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10240), new NamedThreadFactory("preRiskPostPayInvokePool"), CALLER_RUN);
//
//        // 接单风控接口线程池
//        receiveOrderRiskCheckPool = newThreadPool(8, 32, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10240), new NamedThreadFactory("receiveOrderRiskCheckPool"));
//
//        // 接单时调后付检测线程池
//        postPayCheckPool = newThreadPool(8, 32, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(40960), new HamThreadFactory("postPayCheckPool"));
//
//        sendHmsPool = newThreadPool(2, 16, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1024), new NamedThreadFactory("SEND_HMS_POOL"));
//
//        weChatTagPool = newThreadPool(5, 10, 15, TimeUnit.MINUTES,
//                new ArrayBlockingQueue<Runnable>(50000), new NamedThreadFactory("WECHAT_TAG_POOL"));
//
//        healthPool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(4096), new HamThreadFactory("HEALTH_POOL"));
//
//        finRatePool = newThreadPool(10, 20, 15, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000), new NamedThreadFactory("FIN_RATE_POOL"));
//
//        imageRiskPool = newThreadPool(5,15,15, TimeUnit.MINUTES,new ArrayBlockingQueue<>(1024),new NamedThreadFactory("IMAGE_RISK_POOL"),DISCARD);
//    }
//
//    /***
//     * 创建线程池，默认拒绝策略：abort
//     * @param corePoolSize
//     * @param maximumPoolSize
//     * @param keepAliveTime
//     * @param unit
//     * @param workQueue
//     * @param threadFactory
//     * @return
//     */
//    private ExecutorService newThreadPool(int corePoolSize,
//                                          int maximumPoolSize,
//                                          long keepAliveTime,
//                                          TimeUnit unit,
//                                          BlockingQueue<Runnable> workQueue,
//                                          ThreadFactory threadFactory) {
//        return newThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, ABORT);
//    }
//
//    /***
//     * 创建线程池
//     * @param corePoolSize
//     * @param maximumPoolSize
//     * @param keepAliveTime
//     * @param unit
//     * @param workQueue
//     * @param threadFactory
//     * @param handler
//     * @return
//     */
//    private ExecutorService newThreadPool(int corePoolSize,
//                                          int maximumPoolSize,
//                                          long keepAliveTime,
//                                          TimeUnit unit,
//                                          BlockingQueue<Runnable> workQueue,
//                                          ThreadFactory threadFactory,
//                                          RejectedExecutionHandler handler) {
//        return HamExecutors.newThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
//    }
//
//    public void submitDelayMsg(Runnable task) {
//        try {
//            asyncFireDelayMsgPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("submitDelayMsg error", e);
//        }
//    }
//
//    public void submitCheckIMForGuidDeliver(Runnable task) {
//        try {
//            asyncCheckIMForGuideDeliverPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("checkIMForGuideDeliver error", e);
//        }
//    }
//
//    public void submitRemoveFinishedJourneyCachePool(Runnable task) {
//        try {
//            removeFinishedJourneyCachePool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("removeFinishedJourneyCache error", e);
//        }
//    }
//
//    public void updateHistoryDestination(Runnable task) {
//        try {
//            historyDestinationUpdatePool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("updateHistoryDestination error", e);
//        }
//    }
//
//    public void submitWeChatTag(Runnable task){
//        try {
//            this.weChatTagPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitWeChatTag-exception", e);
//        }
//    }
//
//    public void sendDelayMsg(Runnable task) {
//        try {
//            sendDelayMsgPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("sendDelayMsg error", e);
//        }
//    }
//
//    public void asynNotifyDriverback(Runnable task) {
//        try {
//            asynNotifyDriverBack.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("asynNotifyDriverback error", e);
//        }
//    }
//
//    public Future<Map<String, HitchDriverBonusComBO>> submitBounty(Callable task) {
//        try {
//            return bountyPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitBounty error", e);
//        }
//        return null;
//    }
//
//    public Future<ReceiveBountyDTO> submitReceiveProbability(Callable task){
//        try {
//            return receiveProbabilityPool.submit(task);
//        } catch (Exception e){
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitReceiveProbability error", e);
//        }
//        return null;
//    }
//
//    public Future<DriverFinishDetailDTO> submitFinRate(Callable task){
//        try {
//            return finRatePool.submit(task);
//        } catch (Exception e){
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitFinRate error", e);
//        }
//        return null;
//    }
//
//    public void submitPlanStartTimeNotify(Runnable task) {
//        try {
//            planStartTimeNotifyPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitPlanStartTimeNotify error", e);
//        }
//    }
//
//    public void submitPaxPayOrConfirmNotifyNotify(Runnable task) {
//        try {
//            planStartTimeNotifyPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitPaxPayOrConfirmNotifyNotify error", e);
//        }
//    }
//
//    public void submitEffectiveNotify(Runnable task) {
//        try {
//            effectiveDelayPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitEffectiveNotify error", e);
//        }
//    }
//
//    public void submitCredit(Runnable task) {
//        try {
//            creditPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("creditPool error", e);
//        }
//    }
//
//    public void submitGovPush(Runnable task) {
//        try {
//            govPushPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitGovPush error", e);
//        }
//    }
//
//    public void submitJourneyCounterTask(Runnable task) {
//        try {
//            journeyCounterPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitJourneyCounterTask error", e);
//        }
//    }
//
//    public void submitLoggerTask(Runnable task) {
//        try {
//            logPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitLoggerTask error", e);
//        }
//    }
//
//    public void submitHmsTask(Runnable task) {
//        try {
//            sendHmsPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitLoggerTask error", e);
//        }
//    }
//
//    public void dataRefreshSexPoolTask(Runnable task) {
//        try {
//            dataRefreshSexPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitLoggerTask error", e);
//        }
//    }
//
//    public void submitSMSTask(Runnable task) {
//        try {
//            smsPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("submit sms task error");
//        }
//    }
//
//    /**
//     * 推送消息至TCP网关mq
//     *
//     * @param task
//     */
//    public void pushToTcpGWMqTask(Runnable task) {
//        try {
//            tcpNotifyMsgPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("Admin notify task submit failed", e);
//        }
//    }
//
//    /**
//     * 推送消息至http网关mq
//     *
//     * @param task
//     */
//    public void puthToHttpGWMqTask(Runnable task) {
//        try {
//            httpNotifyMsgPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("http notify task submit failed");
//        }
//    }
//
//    public void executedDriverRecruitAuditTask(Runnable task) {
//        try {
//            driverAuditNotifyPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("payment credit task submit failed", e);
//        }
//    }
//
//    /**
//     * 调用推送服务
//     *
//     * @param task
//     */
//    public void executePushTask(Runnable task) {
//        try {
//            pushPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("Push task submit failed", e);
//        }
//    }
//
//    /**
//     * journey状态变化
//     *
//     * @param task
//     */
//    public void executeJourneyStatusChangePool(Runnable task) {
//        try {
//            journeyStatusChangePool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("journey status change task submit failed");
//        }
//    }
//
//    public void executeDriverMatchPaxPool(Runnable task) {
//        try {
//            driverMatchPassengerPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("driver match passenger task submit failed");
//        }
//    }
//
//    public void executeStoreDriverExtraInfo(Runnable task) {
//        try {
//            storeDriverPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("store driver info task submit failed");
//        }
//    }
//
//    /**
//     * 延迟通知
//     *
//     * @param task
//     */
//    public void submitExecDelayNotify(Runnable task) {
//        try {
//            delayPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("executeDelayNotify task failed", e);
//        }
//    }
//
//    public void submitUnbindNotify(Runnable task) {
//        try {
//            unbindPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("executeUnbindNotify task failed", e);
//        }
//    }
//
//    public void submitChangeBind(Runnable task) {
//        try {
//            changeBindPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("executeChangeBind task failed", e);
//        }
//    }
//
//    public void submitChangeDriverCoupon(Runnable task) {
//        try {
//            changeDriverDiscountPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitChangeDriverDiscount task failed", e);
//        }
//    }
//
//    public void submitExecDelayNotifyForDirect(Runnable task) {
//        try {
//            delayForDirectPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("executeDelayNotifyForDirect task failed", e);
//        }
//    }
//
//    public void submitUnbindNotifyForDirect(Runnable task) {
//        try {
//            unbindForDirectPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("executeUnbindNotifyForDirect task failed", e);
//        }
//    }
//
//    public void reportLocationTask(Runnable task) {
//        try {
//            reportLocationPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("report location task submit failed", e);
//        }
//    }
//
//    /**
//     * 延迟通知车主去提醒乘客点击【确认上车】
//     *
//     * @param task
//     */
//    public void waitByCarDelayNotifyTask(Runnable task) {
//        try {
//            waitByCarDelayNotifyPool.submit(task);
//        } catch (RejectedExecutionException e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("paxConfirmCarTask failed", e);
//        }
//    }
//
//    public void arrivePaxStartNotifyTask(Runnable task) {
//        try {
//            arrivePaxStartNotifyPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("arrivePaxStartNotifyTask failed", e);
//        }
//    }
//
//    /**
//     * 心跳上传
//     *
//     * @param task
//     */
//    public void submitHeartbeatUpload(Runnable task) {
//        try {
//            heartbeatUploadPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitHeartbeatUpload failed", e);
//        }
//    }
//
//    /**
//     * Tcp推送给司机语音提示
//     *
//     * @param task
//     */
//    public void driverTcpNotify(Runnable task) {
//        try {
//            driverTcpNotifyPoll.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("driverTcpNotifyTask failed", e);
//        }
//    }
//
//    /**
//     * Tcp推送给司机语音提示
//     *
//     * @param task
//     */
//    public void satisfyTogetherNotify(Runnable task) {
//        try {
//            satisfyTogetherPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("satisfyTogetherNotify failed", e);
//        }
//    }
//
//    /**
//     * Tcp推送给司机语音提示
//     *
//     * @param task
//     */
//    public void effectiveStartNotify(Runnable task) {
//        try {
//            effectiveStartPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("effectiveStartNotify failed", e);
//        }
//    }
//
//    /**
//     * Tcp推送给司机语音提示
//     *
//     * @param task
//     */
//    public void effectiveEndNotify(Runnable task) {
//        try {
//            effectiveEndPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("effectiveEndNotify failed", e);
//        }
//    }
//
//    public void saveToHbasePool(Runnable task) {
//        try {
//            saveToHbasePool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("saveToHbasePoll failed", e);
//        }
//    }
//
//    /**
//     * 处理司机取消行程rpc调用匹配服务取消行程接口
//     * @param task
//     */
//    public void removeMatchOrderTask(Runnable task) {
//        try {
//            removeMatchOrderPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("removeMatchOrderTask-exception", e);
//        }
//    }
//
//    public void saveJourneyStreet(Runnable task) {
//        try {
//            saveJourneyStreetPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("saveJourneyStreet-exception", e);
//        }
//    }
//
//    public void shiftOrStayPool(Runnable task) {
//        try {
//            shiftOrStayPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("shiftOrStayPool-exception", e);
//        }
//    }
//
//    public void preRiskPostPay(Runnable task) {
//        try {
//            preRiskPostPayInvokePool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("preRiskPostPayInvokePool-exception", e);
//        }
//    }
//
//    public Future submitHealth(Callable task) {
//        try {
//            return healthPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("submitHealth exception {}", ExceptionUtils.getFullStackTrace(e));
//        }
//        return null;
//    }
//
//    public void submitImageRisk(Runnable task) {
//        try {
//            this.imageRiskPool.submit(task);
//        } catch (Exception e) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.debug("submitImageRisk error", e);
//        }
//    }
//
//    public ExecutorService getReceiveOrderRiskCheckPool() {
//        return receiveOrderRiskCheckPool;
//    }
//
//    public ExecutorService getPostPayCheckPool() {
//        return postPayCheckPool;
//    }
//
//    public ExecutorService getFinRatePool() {
//        return finRatePool;
//    }
//
//    public void setFinRatePool(ExecutorService finRatePool) {
//        this.finRatePool = finRatePool;
//    }
//
//    private static class NamedThreadFactory implements ThreadFactory {
//        private static final AtomicInteger poolNumber = new AtomicInteger(1);
//        private final ThreadGroup group;
//        private final AtomicInteger threadNumber = new AtomicInteger(1);
//        private final String namePrefix;
//
//        public NamedThreadFactory(String name) {
//            SecurityManager s = System.getSecurityManager();
//            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
//            namePrefix = "pool-" + poolNumber.getAndIncrement() + "-" + name + "-thread-";
//        }
//
//        @Override
//        public Thread newThread(Runnable r) {
//            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
//            if (t.isDaemon()) {
//                t.setDaemon(false);
//            }
//            if (t.getPriority() != Thread.NORM_PRIORITY) {
//                t.setPriority(Thread.NORM_PRIORITY);
//            }
//            return t;
//        }
//
//    }
//
//}
