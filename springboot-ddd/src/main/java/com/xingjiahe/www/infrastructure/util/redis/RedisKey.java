//package com.xingjiahe.www.infrastructure.util.redis;
//
//import com.hellobike.base.redis.core.model.key.Key;
//import com.hellobike.constant.Consts;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import com.hellobike.infrastructure.util.ApolloConfigUtil;
//import com.hellobike.infrastructure.util.DateUtil;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.Objects;
//
//public class RedisKey {
//
//    public static final String DRIVER_INFO_CACHE_KEY_PREFIX = "hitchDriverInfo:";
//
//    public static final String DRIVER_ID_TO_USER_GUID = "driverId2UserGuid:";
//
//    public static final String DRIVER_DISTRIBUTION_LOCK_PREFIX = "hitchDistributionLock:";
//
//    public static final String DRIVER_UNCOMPLETE_JOURNEY_LOCK_PREFIX = "uncompletedJourneyLock:";
//
//    public static final String DRIVER_CREATE_LOCK_PREFIX = "redisLockCreateDriver:";
//
//    public static final String ADD_JOURNEY_LINE_LOCK_PREFIX = "addJourneyLine:";
//
//    public static final String DRIVER_COMMENT_PAX_CACHE_KEY_TEMPLATE = "driverCommentPax:%s";
//
//    //用户地址缓存模板，占位符值是userNewId
//    public static final String USER_ADDRESS_CACHE_KEY_TEMPLATE = "userAddress:%s:%s";
//
//    // 常用路线列表(根据userNewId和roleType)
//    public static final String JOURNEY_LINE_BY_USER_NEW_ID_AND_ROLE_TYPE = "journeyLineList:%s:%s";
//
//    public static final String JOURNEY_LINE_BY_USER_NEW_ID_AND_ROLE_TYPE_INCLUDE_DELETED_ITEM_SIZE = "journeyLineWithdeleted:%s:%s";
//
//    public static final String JOURNEY_LINE_BY_ID_V2 = "journeyLineWithDeleted:%s";
//
//    // 常用路线(根据ID查询)
//    public static final String JOURNEY_LINE_BY_ID = "journeyLine:%s";
//
//    public static Key getUserAddressCacheKey(Long userNewId,Integer businessType) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, USER_ADDRESS_CACHE_KEY_TEMPLATE, userNewId,businessType);
//    }
//    public static Key getDriverCommentPaxCacheKey(String driverJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, DRIVER_COMMENT_PAX_CACHE_KEY_TEMPLATE, driverJourneyGuid);
//    }
//
//    public static Key journeyTotalCancelTimes(long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverJourneyTotalCancelTimes:%s:%s",
//                DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    public static Key journeyDeliverTotalCancelTimes(long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverDeliverJourneyTotalCancelTimes:%s:%s",
//                DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    public static Key journeyLatestPosition(String journeyGuid, int pointType) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "journeyLatestPosition:%s:%s", journeyGuid, pointType);
//    }
//
//    public static Key hitchDriverInfo(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, DRIVER_INFO_CACHE_KEY_PREFIX.concat("%s"), userNewId);
//    }
//
//    /**
//     * 分布式锁
//     *
//     * @param key
//     * @return
//     */
//    public static String hitchDistributionLock(String key) {
//        return "hitchDistributionLock:" + key;
//    }
//
//    /**
//     * 分布式锁key
//     *
//     * @param key
//     * @return
//     */
//    public static String hitchUncompletedJourneyLock(String key) {
//        return "uncompletedJourneyLock:" + key;
//    }
//
//    /**
//     * 发布行程计数器key(用于发布行程)
//     *
//     * @param cityCode
//     * @param userNewId
//     * @return
//     */
//    public static Key journeyPublishCountPerCityPerDay(String cityCode, Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "journeyPublishCountPerDay:%s:%s:%s", cityCode, DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 未完成订单计数器key(接单时check)
//     *
//     * @param cityCode
//     * @param userNewId
//     * @return
//     */
//    public static Key unCompletedCountPerCityPerDay(String cityCode, Date planStartTime, Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "journeyReceiveCountPerDay:%s:%s:%s", cityCode, DateUtil.formatDate(planStartTime, DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 顺风送未完成订单计数器key(接单时check)
//     *
//     * @param cityCode
//     * @param userNewId
//     * @return
//     */
//    public static Key unDeliverCompletedCountPerCityPerDay(String cityCode, Date planStartTime, Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "journeyDeliverReceiveCountPerDay:%s:%s:%s", cityCode, DateUtil.formatDate(planStartTime, DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 每日接单计数器key(接单时check)
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key totalOrderCountPerDay(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "totalOrderCountPerDay:%s:%s", DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 顺风送每日接单计数器key(接单时check)
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key totalDeliverOrderCountPerDay(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "totalDeliverOrderCountPerDay:%s:%s", DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 每日接单计数器key(接单时check)
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key totalReceiveOrderCountPerDay(Long userNewId, Date planStartTime) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "totalReceiveOrderCountPerDay:%s:%s", DateUtil.formatDate(planStartTime, DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 顺风送每日接单计数器key(接单时check)
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key totalDeliverReceiveOrderCountPerDay(Long userNewId, Date planStartTime) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "totalDeliverReceiveOrderCountPerDay:%s:%s", DateUtil.formatDate(planStartTime, DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 每日邀请乘客计数器key(点击邀请乘客时check)
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key invitePaxCountPerDay(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "invitePaxCountPerDay:%s:%s", DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    /**
//     * 每日乘客收到车主邀请次数计数器key(点击邀请乘客时check)
//     *
//     * @return
//     */
//    public static Key paxReceiveInviteNotifyCountPerDay(Long paxUserNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "paxReceiveInviteNotifyCountPerDay:%s:%s", DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), paxUserNewId);
//    }
//
//    /**
//     * 订单对应已接单数量
//     *
//     * @param driverJourneyGuid
//     * @return
//     */
//    public static Key journeyReceivedCount(String driverJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "journeyReceivedCount:%s", driverJourneyGuid);
//    }
//
//
//    /**
//     * 用户未完成行程的key
//     *
//     * @param driverUserNewId
//     * @return
//     */
//    public static Key unCompletedJourneySet(Long driverUserNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "unCompletedJourney:%s", driverUserNewId);
//    }
//
//    /**
//     * 司机创建锁
//     *
//     * @param userNewId
//     * @return
//     */
//    public static String redisCreateDriverLock(String userNewId) {
//        return String.format("redisLockCreateDriver:%s", userNewId);
//    }
//
//    /**
//     * 司机发布行程超时key
//     *
//     * @param driverJourneyGuid
//     * @return
//     */
//    public static Key journeyPublishExpired(String driverJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "journeyPublishExpired:%s", driverJourneyGuid);
//    }
//
//    /**
//     * 司机发布行程超时key
//     *
//     * @param passengerJourneyGuid
//     * @return
//     */
//    public static Key passengerUnpaidExpired(String passengerJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "passengerUnpaidExpired:%s", passengerJourneyGuid);
//    }
//
//    /**
//     * 司机日取消次数上限
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key driverCancelLimitDaily(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverNewCancelLimitDaily:%s:%s",
//                DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//
//    /**
//     * 司机日取消次数上限
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key driverDeliverCancelLimitDaily(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverDeliverNewCancelLimitDaily:%s:%s",
//                DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//    /**
//     * 实人认证token
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key bioAuthToken(String userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "bioAuthToken:%s", userNewId);
//    }
//
//    public static Key driverFirstOrder(String userGuid,Integer journeyType) {
//        if (Objects.isNull(journeyType) || EnumPaxJourneyType.parse(journeyType) == EnumPaxJourneyType.HITCH_PASSENGER) {
//            return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverFirstOrder:%s", userGuid);
//        }
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverFirstOrder:%s:%s", journeyType,
//                userGuid);
//    }
//
//    public static Key driverCrossCityOrder(String userGuid,Integer journeyType) {
//        if (Objects.isNull(journeyType) || EnumPaxJourneyType.parse(journeyType) == EnumPaxJourneyType.HITCH_PASSENGER) {
//            return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverCrossCityOrder:%s", userGuid);
//        }
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverCrossCityOrder:%s:%s", journeyType,
//                userGuid);
//    }
//
//    public static Key driverInnerCityOrder(String userGuid,Integer journeyType) {
//
//        if (Objects.isNull(journeyType) || EnumPaxJourneyType.parse(journeyType) == EnumPaxJourneyType.HITCH_PASSENGER) {
//            return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverInnerCityOrder:%s", userGuid);
//        }
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverInnerCityOrder:%s:%s", journeyType, userGuid);
//    }
//
//    public static Key driverOnBoardFirstOrder(String userGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverOnBoardFirstOrder:%s", userGuid);
//    }
//
//    public static Key driverOnBoardFirstOrderWithJourneyType(String userGuid, Integer journeyType) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverOnBoardFirstOrder:%s:%s", journeyType, userGuid);
//    }
//
//    public static Key driverOnBoardCrossCityOrder(String userGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverOnBoardCrossCityOrder:%s", userGuid);
//    }
//
//    public static Key driverOnBoardInnerCityOrder(String userGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverOnBoardInnerCityOrder:%s", userGuid);
//    }
//
//
//    public static Key driverJourneyMatchPushCount(String driverJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverJourneyMatchPushCount:%s", driverJourneyGuid);
//    }
//
//    public static Key driverJourneyLineMatchPushCount(String journeyLineId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverJourneyLineMatchPushCount:%s", journeyLineId);
//    }
//
//    public static Key driverSmsByUserTagMaxSendLimit(String userTagGuid,Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverSmsByUserTagMaxSendLimit:%s:%s", userTagGuid,userNewId);
//    }
//
//    public static Key driverSmsByUserTagPeriodSendSmsLimit(String userTagGuid,Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverSmsByUserTagPeriodSendSmsLimit:%s:%s", userTagGuid,userNewId);
//    }
//
//    public static Key driverSmsByUserTagTimeDifference(String userTagGuid,Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverSmsByUserTagTimeDifference:%s:%s", userTagGuid,userNewId);
//    }
//
//
//    /**
//     * 每个时间段每个车主最多允许收到推送限制
//     *
//     * @param userGuid
//     * @return
//     */
//    public static Key driverPushPreSlotCount(String userGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverPushPreSlotCount:%s", userGuid);
//    }
//
//    /**
//     * 每条乘客常用路线每天仅允许收到推送限制
//     *
//     * @param journeyLineId
//     * @param userGuid
//     * @return
//     */
//    public static Key driverJourneyLineMatchPushPreDayCount(String journeyLineId, String userGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverJourneyLineMatchPushPreDayCount:%s:%s", journeyLineId, userGuid);
//    }
//
//    /**
//     * 实人认证失败次数限制
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key bioAuthLimit(String userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "bioAuthLimit:%s:%s", DateTimeFormatter.BASIC_ISO_DATE.format(LocalDate.now()), userNewId);
//    }
//
//    /**
//     * 富数认证失败次数限制
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key fsAuthLimit(String userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "fsAuthLimit:%s:%s", DateTimeFormatter.BASIC_ISO_DATE.format(LocalDate.now()), userNewId);
//    }
//
//    /**
//     * 阿里认证失败次数限制
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key aliAuthLimit(String userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "aliAuthLimit:%s:%s", DateTimeFormatter.BASIC_ISO_DATE.format(LocalDate.now()), userNewId);
//    }
//
//    /**
//     * 实人认证司机当天是否认证通过
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key bioAuthPassedByDay(String userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "bioAuthPassedByDay:%s:%s", DateTimeFormatter.BASIC_ISO_DATE.format(LocalDate.now()), userNewId);
//    }
//
//    /**
//     * 刷数据多服务器抢占
//     *
//     * @return
//     */
//    public static Key refresh() {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverRefreshData");
//    }
//
//    /**
//     * 刷数据多服务器抢占sex
//     *
//     * @return
//     */
//    public static Key refreshSex() {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverRefreshSexData");
//    }
//
//    /**
//     * 富数Token
//     *
//     * @return
//     */
//    public static Key fsToken() {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "fsToken");
//    }
//
//    /**
//     * 富数用户是否通过身份识别
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key fsDoneBioIdentity(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "fsDoneBioIdentity:%s", userNewId);
//    }
//
//
//    /**
//     * 高数路度常用路线推送红点标示
//     *
//     * @return
//     */
//    public static Key driverJourneyMatchHighRateFlag(String journeyLineId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverJourneyMatchHighRateFlag:%s", journeyLineId);
//    }
//
//    /**
//     * 高数路度订单推送红点标示
//     *
//     * @return
//     */
//    public static Key driverOrderMatchHighRateFlag(String orderId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverOrderMatchHighRateFlag:%s", orderId);
//    }
//
//    /**
//     * 乘客邀请车主 给司机发送短信key
//     *
//     * @param driverGuid
//     * @return
//     */
//    public static Key paxInviteDriver(String driverGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "paxInviteDriver:%s", driverGuid);
//    }
//
//    public static Key dmpPush(String driverGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "dmpPush:%s", driverGuid);
//    }
//
//    public static Key dmpSms(String driverGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "dmpSms:%s", driverGuid);
//    }
//
//    /**
//     * 匹配端给司机推送一天最大限制次数
//     *
//     * @param driverGuid
//     * @return
//     */
//    public static Key dmpSmsDayLimit(String driverGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "dmpSmsDayLimit:%s", driverGuid);
//    }
//
//
//    /**
//     * 常用路线匹配数量
//     *
//     * @return
//     */
//    public static Key driverJourneyMatchCount(String journeyLineId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverJourneyNewMatchCount:%s", journeyLineId);
//    }
//
//    /**
//     * 订单匹配数量
//     *
//     * @return
//     */
//    public static Key driverOrderMatchCount(String orderId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverOrderNewMatchCount:%s", orderId);
//    }
//
//    /**
//     * 订单匹配疲劳度分时控制
//     * @param orderId
//     * @return
//     */
//    public static Key driverOrderMatchTimeShareCount(String orderId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverOrderMatchTimeShareCount:%s", orderId);
//    }
//
//    /**
//     * 车主认证后置刷单限制
//     *
//     * @param userNewId
//     * @return
//     */
//    public static Key driverPostApprovalLimit(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverPostApprovalLimit:%s", userNewId);
//    }
//
//    /**
//     * 实名认证后置 - 存储照片信息
//     *
//     * @param driverNewId
//     * @return
//     */
//    public static Key driverLicenseDate(Long driverNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverLicenseDate:%s", driverNewId);
//    }
//
//    /**
//     * 实名认证后置 - 存储照片信息
//     *
//     * @param userNewId
//     * @return
//     */
////    public static Key preBioCallback(Long userNewId) {
////        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "preBioCallback:%s", userNewId);
////    }
//
//    public static Key sendPushPaxStartNotify(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "sendPushPaxStartNotify:%s", paxJourneyGuid);
//    }
//
//    public static Key sendPushOrSms(String key) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "sendPushOrSms:%s", key);
//    }
//
//    public static Key matchListFreLineIndex(String driverJourneyId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "matchListFreLineIndex:%s", driverJourneyId);
//    }
//
//    /**
//     * 记录车主查看认证状态后点击"我知道了"操作
//     */
//    public static Key hasKnownAuditPassed(String userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "hasKnownAuditPassed:%s", userNewId);
//    }
//
//    public static Key driverNotifyPaxGetOnCar(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverNotifyPaxGetOnCar:%s", paxJourneyGuid);
//    }
//
//    public static Key tcpGetOnCarFlag(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "tcpGetOnCarFlag:%s", paxJourneyGuid);
//    }
//
//    public static Key driverNotifyPaxGetOffCar(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverNotifyPaxGetOffCar:%s", paxJourneyGuid);
//    }
//
//    public static Key tcpGetOffCarFlag(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "tcpGetOffCarFlag:%s", paxJourneyGuid);
//    }
//
//    public static Key streetInfoCache(String startLon, String startLat, String endLon, String endLat) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "%s:%s:%s:%s", startLon, startLat, endLon, endLat);
//    }
//
//    public static Key autoCancelKey(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "autoCancelKey:%s", paxJourneyGuid);
//    }
//
//    public static Key pointTogetherKey(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "pointTogetherKey:%s", paxJourneyGuid);
//    }
//
//    public static Key orderCancelable(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "orderCancelable:%s", paxJourneyGuid);
//    }
//
//
//    public static Key driverIsNewUser(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverIsNewUser:%s", userNewId);
//    }
//
//    public static Key driverFirstCrossCityOrder(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverCrossCityOrder:%s", userNewId);
//    }
//
//    public static Key driverFirstInnerCityOrder(Long userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driverInnerCityOrder:%s", userNewId);
//    }
//
//    public static Key bioAuthErrorCountByProvider(String provider) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "bioAuthErrorCount:%s", provider);
//    }
//
//    public static Key bioAuthAvailableByProvider(String provider) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "bioAuthAvailable:%s", provider);
//    }
//
//    public static Key flushDataToRedisStartId() {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "flushDataToRedisStartId");
//    }
//
//    public static Key storeCacheHighRate(String driverJourneyGuid, String passengerJourneyGuid) {
//        if(ApolloConfigUtil.getCommonBooleanProperty(Consts.Apollo.HIGH_RATE_POINT_TO_HIGHRATE_CLUSTER_SWITCH, false)) {
//            return Key.convertByFormatWithClientName(Consts.HIGH_RATE_REDIS_NAME, "highRate:%s:%s", driverJourneyGuid, passengerJourneyGuid);
//        }
//
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "highRate:%s:%s", driverJourneyGuid, passengerJourneyGuid);
//    }
//
//    public static Key driverAutoReciveKey(String driverJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "driAutoRec:%s", driverJourneyGuid);
//    }
//
//    public static Key userPhoneNoticeCountPerDay(String userNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "userPhoneNoticeCountPerDay:%s:%s",
//                DateUtil.formatDate(new Date(), DateUtil.DATE_PATTERN), userNewId);
//    }
//
//    public static Key uploadPointList(String paxGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "uploadPointList:%s", paxGuid);
//    }
//
//    public static Key effectiveStartCount(String paxGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "effectiveStartCount:%s", paxGuid);
//    }
//
//    public static Key effectiveEndCount(String paxGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "effectiveEndCount:%s", paxGuid);
//    }
//
//    public static Key effectiveStartSign(String paxGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "effectiveStartSign:%s", paxGuid);
//    }
//
//    public static Key effectiveEndSign(String paxGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "effectiveEndSign:%s", paxGuid);
//    }
//
//    public static Key effectiveSign(String paxGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "effectiveSign:%s", paxGuid);
//    }
//
//    public static Key planArriveTime(String paxGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "planArriveTime:%s", paxGuid);
//    }
//
//
//
//    /**
//     * 轨迹偏移
//     * @param paxJourneyGuid
//     * @return
//     */
//    public static Key judegeTime(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "judegeTime:%s", paxJourneyGuid);
//    }
//    public static Key preDistance(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "preDistance:%s", paxJourneyGuid);
//    }
//    public static Key pointShiftKey(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "pointShiftKey:%s", paxJourneyGuid);
//    }
//    /**
//     * 轨迹停留
//     * @param paxJourneyGuid
//     * @return
//     */
//    public static Key stayTime(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "stayTime:%s", paxJourneyGuid);
//    }
//    public static Key stayTimeY(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "stayTimeY:%s", paxJourneyGuid);
//    }
//    public static Key stayPoint(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "stayPoint:%s", paxJourneyGuid);
//    }
//    public static Key stayPointY(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "stayPointY:%s", paxJourneyGuid);
//    }
//    public static Key stayZero(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "stayZero:%s", paxJourneyGuid);
//    }
//    public static Key stayY(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "stayY:%s", paxJourneyGuid);
//    }
//
//
//    public static Key arrivalDestination(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "arrivalDestination:%s", paxJourneyGuid);
//    }
//
//
//    /**
//     * 后付风控缓存
//     *
//     * @param paxJourneyGuid
//     * @return
//     */
//    public static Key riskPostPay(String paxJourneyGuid, String driverUserNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "riskPostPay:%s:%s", paxJourneyGuid, driverUserNewId);
//    }
//
//    /**
//     * 后付风控缓存
//     *
//     * @param paxJourneyGuid
//     * @return
//     */
//    public static Key riskDecision(String paxJourneyGuid, String driverUserNewId) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "riskDecision:%s:%s", paxJourneyGuid, driverUserNewId);
//    }
//
//    public static Key sendSMSForDeliveryCode(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "sendSmsForDeliveryCode:%s", paxJourneyGuid);
//    }
//
//    public static Key deliverDriverSmsInputTimes(String paxJourneyGuid) {
//        return Key.convertByFormatWithClientName(Consts.DRIVER_REDIS_NAME, "deliverSmsInputTimes:%s", paxJourneyGuid);
//    }
//}
