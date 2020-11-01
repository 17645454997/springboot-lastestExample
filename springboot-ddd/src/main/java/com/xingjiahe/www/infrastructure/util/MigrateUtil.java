//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.domain.request.FetchJourneyPositionRequest;
//import com.hellobike.domain.request.PointInfoRequest;
//import com.hitch.safe.dto.FetchJourneyPositionDTO;
//import com.hitch.safe.dto.PointInfoRequestDTO;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 临时灰度迁移判断
// * @author  qyl
// * @date 2020-02-03
// */
//public class MigrateUtil {
//    //保存轨迹， 获取临时轨迹
//    public static final String MIGRATION_SAVEPOSITIONPOINT_SWTICH = "migration.savePositionPoint.swtich";
//    public static final String MIGRATION_SAVEPOSITIONPOINT_GRAY = "migration.savePositionPoint.gray";
//    public static final String MIGRATION_SAVEPOSITIONPOIT_WHITELIST = "migration.savePositionPoit.whiteList";
//    //向乘车发送消息
//    public static final String MIGRATION_SENDMSG_SWTICH = "migration.sendMsg.swtich";
//    public static final String MIGRATION_SENDMSG_GRAY = "migration.sendMsg.gray";
//    public static final String MIGRATION_SENDMSG_WHITELIST = "migration.sendMsg.whiteList";
//    //向乘客语音播报
//    public static final String MIGRATION_SHOWNOTIFY_SWTICH = "migration.showNotify.swtich";
//    public static final String MIGRATION_SHOWNOTIFY_GRAY = "migration.showNotify.gray";
//    public static final String MIGRATION_SHOWNOTIFY_WHITELIST = "migration.showNotify.whiteList";
//
//    //轨迹偏移预警开关
//    public static final String MIGRATION_DEPART_SWTICH = "migration.depart.swtich";
//
//
//    //司乘同行，有效履约，有效结束，有效开始
//    public static final String MIGRATION_EFFECTIVE_SWTICH = "migration.effective.swtich";
//    public static final String MIGRATION_EFFECTIVE_GRAY = "migration.effective.gray";
//    public static final String MIGRATION_EFFECTIVE_WHITELIST = "migration.effective.whiteList";
//
//
//    /**
//     * 保存轨迹点灰度---临时迁移
//     * @param userNewId
//     * @return
//     */
//    public static boolean isNeedMigrateHBaseSave(Long userNewId) {
//        String migrateSwitch = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SAVEPOSITIONPOINT_SWTICH, "off");
//        String gray = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SAVEPOSITIONPOINT_GRAY, "");
//        String whiteUserIdsString = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SAVEPOSITIONPOIT_WHITELIST, "null");
//        String[] whiteUserIds = whiteUserIdsString.split(",");
//        //白名单
//        if(Arrays.asList(whiteUserIds).contains(String.valueOf(userNewId))) {
//            return true;
//        }
//        String userId = String.valueOf(userNewId);
//        //开关打开并且 尾号存在灰度选项
//        if(migrateSwitch.equals("on")&& gray.indexOf(userId.substring(userId.length() - 1))!= -1){
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 保存轨迹点灰度---临时迁移
//     * @param userNewId
//     * @return
//     */
//    public static boolean isNeedMigrateSendMsg(Long userNewId) {
//        String migrateSwitch = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SENDMSG_SWTICH, "off");
//        String gray = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SENDMSG_GRAY, "");
//        String whiteUserIdsString = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SENDMSG_WHITELIST, "null");
//        String[] whiteUserIds = whiteUserIdsString.split(",");
//        //白名单
//        if(Arrays.asList(whiteUserIds).contains(String.valueOf(userNewId))) {
//            return true;
//        }
//        String userId = String.valueOf(userNewId);
//        //开关打开并且 尾号存在灰度选项
//        if(migrateSwitch.equals("on")&& gray.indexOf(userId.substring(userId.length() - 1))!= -1){
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 保存轨迹点灰度---临时迁移
//     * @param userNewId
//     * @return
//     */
//    public static boolean isNeedMigrateShowNotify(Long userNewId) {
//        String migrateSwitch = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SHOWNOTIFY_SWTICH, "off");
//        String gray = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SHOWNOTIFY_GRAY, "");
//        String whiteUserIdsString = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_SHOWNOTIFY_WHITELIST, "null");
//        String[] whiteUserIds = whiteUserIdsString.split(",");
//        //白名单
//        if(Arrays.asList(whiteUserIds).contains(String.valueOf(userNewId))) {
//            return true;
//        }
//        String userId = String.valueOf(userNewId);
//        //开关打开并且 尾号存在灰度选项
//        if(migrateSwitch.equals("on")&& gray.indexOf(userId.substring(userId.length() - 1))!= -1){
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 保存轨迹点灰度---临时迁移
//     * @param userNewId
//     * @return
//     */
//    public static boolean isNeedMigrateEffective(Long userNewId) {
//        String migrateSwitch = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_EFFECTIVE_SWTICH, "off");
//        String gray = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_EFFECTIVE_GRAY, "");
//        String whiteUserIdsString = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_EFFECTIVE_WHITELIST, "null");
//        String[] whiteUserIds = whiteUserIdsString.split(",");
//        //白名单
//        if(Arrays.asList(whiteUserIds).contains(String.valueOf(userNewId))) {
//            return true;
//        }
//        String userId = String.valueOf(userNewId);
//        //开关打开并且 尾号存在灰度选项
//        if(migrateSwitch.equals("on")&& gray.indexOf(userId.substring(userId.length() - 1))!= -1){
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 调用服务接口转化，临时使用
//     * @param FetchJourneyPositionRequest
//     * @return
//     */
//    public static FetchJourneyPositionDTO convert(FetchJourneyPositionRequest FetchJourneyPositionRequest){
//        FetchJourneyPositionDTO fetchJourneyPositionDTO = new FetchJourneyPositionDTO();
//        fetchJourneyPositionDTO.setPaxJourneyGuid(FetchJourneyPositionRequest.getJourneyGuid());
//        fetchJourneyPositionDTO.setRoleType(FetchJourneyPositionRequest.getRoleType());
//        return fetchJourneyPositionDTO;
//    }
//
//    /**
//     * 调用服务接口转化，临时使用
//     * @param pointInfoRequest
//     * @return
//     */
//    public static PointInfoRequestDTO convert(PointInfoRequest pointInfoRequest){
//        PointInfoRequestDTO pointInfoRequestDTO = new PointInfoRequestDTO();
//        pointInfoRequestDTO.setLat(pointInfoRequest.getLat());
//        pointInfoRequestDTO.setLon(pointInfoRequest.getLon());
//        pointInfoRequestDTO.setPaxJourneyGuid(pointInfoRequest.getPaxJourneyGuid());
//        pointInfoRequestDTO.setPointType(pointInfoRequest.getPointType());
//        pointInfoRequestDTO.setGpsTimeStamp(pointInfoRequest.getGpsTimeStamp());
//        pointInfoRequestDTO.setMsg(pointInfoRequest.getMsg());
//        return pointInfoRequestDTO;
//    }
//
//    /**
//     * 调用服务接口转化，临时使用
//     * @param pointInfoRquestList
//     * @return
//     */
//    public static List<PointInfoRequestDTO> convert(List<PointInfoRequest> pointInfoRquestList){
//        List<PointInfoRequestDTO> pointInfoRequestList = pointInfoRquestList.stream().map(e->convert(e)).collect(Collectors.toList());
//        return pointInfoRequestList;
//    }
//
//    public static boolean isNeedMigrateDepart() {
//        String migrateSwitch = com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(MIGRATION_DEPART_SWTICH, "off");
//        if(migrateSwitch.equals("on")){
//            return true;
//        }
//        return false;
//    }
//
//}
