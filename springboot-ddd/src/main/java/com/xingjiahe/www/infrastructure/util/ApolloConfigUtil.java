//package com.xingjiahe.www.infrastructure.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.ConfigService;
//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.google.common.base.Strings;
//import com.hellobike.constant.Consts;
//import com.hellobike.constant.DeliverConsts;
//import com.hellobike.enums.EnumBioAuthProvider;
//import com.hellobike.infrastructure.strategy.BioAuthSwitchStrategy;
//import com.hellobike.service.*;
//import com.hellobike.service.deliver.DeliverDriverConfigService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
///**
// * Created by reach on 2018/9/12.
// */
//@Component
//public class ApolloConfigUtil {
//
//    private static Config config;
//
//    private static Config commonConfig;
//
//    private static Config paymentConfig;
//
//    @Autowired
//    private DriverConfigService driverConfigService;
//
//    @Autowired
//    private CityInfoService cityInfoService;
//
//    @Autowired
//    private PostPayAutoConfirmService postPayAutoConfirmService;
//
//    @Autowired
//    @Qualifier("defaultBioAuthSwitchStrategy")
//    private BioAuthSwitchStrategy bioAuthSwitchStrategy;
//
//    @Autowired
//    private FraudJourneyConfigService fraudJourneyConfigService;
//
//    @Autowired
//    private PaymentConfigService paymentConfigService;
//
//    @Autowired
//    private DeliverDriverConfigService deliverDriverConfigService;
//
//    private static final String object_default_value = "{}";
//    private static final String list_default_value = "[]";
//
//    private ApolloConfigUtil() {
//    }
//
//    @PostConstruct
//    private void init() {
//        ConfigService.setMetaDomain(PropUtils.getProperty("apollo.server"));
//        ConfigService.setAppId(PropUtils.getProperty("server.name"));
//        config = ConfigService.getAppConfig();
//        commonConfig = ConfigService.getConfig(Consts.COMMON_APOLL_NAMESPACE);
//        paymentConfig = ConfigService.getConfig(Consts.PAYMENT_APOLL_NAMESPACE);
//        addPropsChangeListener();
//
//    }
//
//    public void addPropsChangeListener() {
//        if (config != null) {
//            config.addChangeListener((ConfigChangeEvent changeEvent) -> {
//                for (String key : changeEvent.changedKeys()) {
//                    switch (key) {
//                        case Consts.DRIVER_CITY_CONFIG:
//                            driverConfigService.refreshCityConfig();
//                            break;
//                        case Consts.SPECIAL_CITY_CODES:
//                            driverConfigService.refreshCityCodes();
//                            break;
//                        case Consts.DRIVER_BLACK_LIST:
//                            driverConfigService.refreshDriverBlackList();
//                            break;
//                        case Consts.DRIVER_JOURNEY_CONFIG:
//                            driverConfigService.refreshDriverJourneyConfig();
//                            break;
//                        case Consts.LATE_PAYMENT_LIST:
//                            driverConfigService.refreshLatePaymentList();
//                            break;
//                        case Consts.LATE_PAYMENT_LIST_GRAY:
//                            driverConfigService.refreshLatePaymentListGray();
//                            break;
//                        case Consts.DRIVER_PUSH_AND_MSG_SECRET_KEY_CONFIG:
//                            driverConfigService.refreshPushANdMsgSecretKeyConfig();
//                            break;
//                        case Consts.DRIVER_AVATAR_INDEX:
//                            driverConfigService.refreshAvatarIndexModel();
//                            break;
//                        case Consts.CREDIT_QUALIFICATION_KEY:
//                            driverConfigService.refreshCreditQualifications();
//                            break;
//                        case Consts.CREDIT_QUALIFICATION_KEY_GRAY:
//                            driverConfigService.refreshCreditQualificationsGray();
//                            break;
//                        case Consts.BIO_AUTH_FORCE_SWITCH:
//                            bioAuthSwitchStrategy.forceSwitchBioAuthProvider(EnumBioAuthProvider.parse(com.hellobike.infrastructure.util.ApolloConfigUtil.getIntProperty(Consts.BIO_AUTH_FORCE_SWITCH, 1)));
//                            break;
//                        case Consts.DRIVER_HIGH_AMOUNT_ORDER_RULES:
//                            driverConfigService.refreshHighAmountOrderRules();
//                            break;
//                        case Consts.FORBID_PREORDER_CONFIG:
//                            driverConfigService.refreshForbidPreOrder();
//                            break;
//                        case Consts.PAX_EARLIEST_START_TIME:
//                            driverConfigService.refreshPaxEarliestStartTime();
//                            break;
//                        case Consts.DRIVER_EARLIEST_START_TIME:
//                            driverConfigService.refreshDriEarliestStartTime();
//                            break;
//                        case Consts.CITY_NUM_CONFIG:
//                            driverConfigService.refreshCityNumConfig();
//                            break;
//                        case Consts.DRIVER_PAX_CITY_RECOMMEND_TIME:
//                            driverConfigService.refreshCityRecommendStartTimes();
//                            break;
//                        case Consts.XTAB_CONFIG:
//                            driverConfigService.refreshHitchXTabConfig();
//                            break;
//                        case Consts.Apollo.DRIVER_EFFECTIVE_STRATEGY:
//                            driverConfigService.refreshStrategyList();
//                            break;
//                        case Consts.DRIVER_BAN_DESTINATION_CITY_CONFIG:
//                            driverConfigService.refreshBanDestinationCityConfig();
//                            break;
//                        case Consts.DRIVER_CITY_DISTANCE_LIMIT:
//                            driverConfigService.refreshDistanceLimitConfigList();
//                            break;
//                        case Consts.Apollo.MATCH_LIST_OPERATION_CONFIG:
//                            driverConfigService.refreshMatchListOperationConfig();
//                            break;
//                        case Consts.PAX_PUBLISH_JOURNEY_TIME_CONFIG:
//                            driverConfigService.refreshPaxPublishJourneyConfig();
//                            break;
//                        case Consts.DRIVER_FINISH_RULES:
//                            driverConfigService.refreshDriveFinish();
//                            break;
//                        case Consts.Apollo.NEW_VERSION_VIEW_CONFIG:
//                            driverConfigService.refreshNewVersionViewConfig();
//                            break;
//                        case DeliverConsts.Apollo.DELIVER_ROUTE_HELPER:
//                            deliverDriverConfigService.refreshRouteHelperConfig();
//                        case DeliverConsts.Apollo.PAX_PUBLISH_DELIVER_TIME_CONFIG:
//                            deliverDriverConfigService.refreshDeliverPublishTimeConfig();
//                            break;
//                        case Consts.Apollo.Driver_Receive_Strategy:
//                            driverConfigService.refreshDriverReceiveStrategy();
//                            break;
//                        case DeliverConsts.Apollo.DELIVER_INSURANCE_INFO:
//                            deliverDriverConfigService.refreshDeliverInsuranceInfoDto();
//                    }
//                }
//            });
//        }
//
//        if (commonConfig != null) {
//            commonConfig.addChangeListener((ConfigChangeEvent changeEvent) -> {
//                for (String key : changeEvent.changedKeys()) {
//                    switch (key) {
//                        case Consts.CITY_INFO_LIST:
//                            cityInfoService.refreshCityInfo();
//                            break;
//                        case Consts.PostPayAutoConfirm.APOLLO_KEY:
//                            postPayAutoConfirmService.refreshConfig();
//                            break;
//                        case Consts.Apollo.FRAUD_JOURNEY_CONFIG_KEY:
//                            fraudJourneyConfigService.refreshConfig();
//                            break;
//                        case Consts.Apollo.POOL_FIXED_PRICE_CITY_CONFIG:
//                            driverConfigService.refreshPoolFixedPriceCityList();
//                        default:
//                            break;
//                    }
//                }
//            });
//        }
//
//        if (paymentConfig != null) {
//            paymentConfig.addChangeListener((ConfigChangeEvent changeEvent) -> {
//                for (String key : changeEvent.changedKeys()) {
//                    switch (key) {
//                        case Consts.Payment.NOTIFY_SECRET_KEY:
//                            paymentConfigService.refreshNotifySecretConfig();
//                            break;
//                        case Consts.Payment.EXTRA_RECEIVE_URL_KEY:
//                            paymentConfigService.refreshExtraReceiveUrlConfig();
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            });
//        }
//    }
//
//    public static String getProperty(String key, String defaultValue) {
//        return config.getProperty(key, defaultValue);
//    }
//
//    public static Integer getIntProperty(String key, Integer defaultValue) {
//        return config.getIntProperty(key, defaultValue);
//    }
//
//    public static Double getDoubleProperty(String key, Double defaultValue) {
//        return config.getDoubleProperty(key, defaultValue);
//    }
//
//    public static Boolean getBooleanProperty(String key, Boolean defaultValue) {
//        return config.getBooleanProperty(key, defaultValue);
//    }
//
//    public static Long getLongProperty(String key, Long defaultValue) {
//        return config.getLongProperty(key, defaultValue);
//    }
//
//    public static String getCommonProperty(String key, String defaultValue) {
//        return commonConfig.getProperty(key, defaultValue);
//    }
//
//    public static Integer getCommonIntProperty(String key, Integer defaultValue) {
//        return commonConfig.getIntProperty(key, defaultValue);
//    }
//
//    public static Boolean getCommonBooleanProperty(String key, boolean defaultValue) {
//        return commonConfig.getBooleanProperty(key, defaultValue);
//    }
//
//    public static String getPaymentProperty(String key, String defaultValue) {
//        return paymentConfig.getProperty(key, defaultValue);
//    }
//    public static <T> T getObjectProperty(String key, Class<T> clazz) {
//        String value = config.getProperty(key, object_default_value);
//        if (Strings.isNullOrEmpty(value)) {
//            return null;
//        }
//        return JSON.parseObject(value, clazz);
//    }
//
//    public static <T> List<T> getListProperty(String key, Class<T> clazz) {
//        String value = config.getProperty(key, list_default_value);
//        if (Strings.isNullOrEmpty(value)) {
//            return Lists.newArrayList();
//        }
//        return JSONObject.parseArray(value, clazz);
//    }
//}
