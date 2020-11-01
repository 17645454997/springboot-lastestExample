//package com.xingjiahe.www.infrastructure.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.carkey.base.model.Proto;
//import com.google.common.base.Strings;
//import com.hellobike.constant.DeliverConsts;
//import com.hellobike.domain.image.ImageScanResponse;
//import com.hellobike.domain.image.ImageScanResult;
//import com.hellobike.hitchjourney.dto.detail.GoodsInfoDto;
//import com.hellobike.hitchjourney.dto.enums.EnumPaxJourneyType;
//import com.hellobike.rcp.databus.dto.DataBusResponse;
//import com.hellobike.soa.rpc.RpcClientHelper;
//import com.hellobike.upload.ifaces.UserUploadServiceIface;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//public class DeliverUtil {
//
//    /**
//     * 过滤手机敏感信息
//     *
//     * @param goodsInfoDto
//     * @return
//     */
//    public static GoodsInfoDto convertGoodsInfo(GoodsInfoDto goodsInfoDto) {
//        if (Objects.isNull(goodsInfoDto)) {
//            return null;
//        }
//        goodsInfoDto.setSenderMobilePhone(com.hellobike.infrastructure.util.Utils.getHandleMobilePhone(goodsInfoDto.getSenderMobilePhone()));
//        goodsInfoDto.setReceiverMobilePhone(com.hellobike.infrastructure.util.Utils.getHandleMobilePhone(goodsInfoDto.getReceiverMobilePhone()));
//        List<String> photos = goodsInfoDto.getGoodsPhotos();
//        if (Objects.nonNull(photos) && photos.size() > 0) {
//            goodsInfoDto.setGoodsPhotos(generateSTSUrl(photos));
//        }
//        return goodsInfoDto;
//    }
//
//
//    public static List<String> generateSTSUrl(List<String> urls) {
//        try {
//            JSONObject params = new JSONObject();
//            JSONArray originUrls = JSON.parseArray(JSON.toJSONString(urls));
//            params.put("originUrls", originUrls);
//            Proto proto = RpcClientHelper.getClient(UserUploadServiceIface.class).generateSTSUrl(params);
//            if (proto.code == 0) {
//                return (List) proto.getData();
//            }
//        } catch (Exception e) {
//            LogUtils.ERROR.error("generateSTSUrl error",e);
//        }
//        return null;
//    }
//
//    public static List<String> generateSTSUrl(JSONObject params) {
//        try {
//            Proto proto = RpcClientHelper.getClient(UserUploadServiceIface.class).generateSTSUrl(params);
//            if (proto.code == 0) {
//                return (List) proto.getData();
//            }
//        } catch (Exception e) {
//            LogUtils.ERROR.error("generateSTSUrl error",e);
//        }
//        return null;
//    }
//
//    public static Boolean isDeliverOrder(Integer journeyType) {
//        if (Objects.nonNull(journeyType) && journeyType == EnumPaxJourneyType.HITCH_GOODS.getCode()) {
//            return true;
//        }
//        return false;
//    }
//
//    public static Boolean isOpenVersion(Integer journeyType, String version) {
//        if (Objects.nonNull(version) && Objects.nonNull(journeyType) && journeyType == EnumPaxJourneyType.HITCH_GOODS.getCode() && com.hellobike.infrastructure.util.VersionUtils.getVersionNo(version) >= com.hellobike.infrastructure.util.ApolloConfigUtil.getIntProperty(DeliverConsts.DELIVER_VERSION, 53905)) {
//            return true;
//        }
//        return false;
//    }
//
//    public static Boolean isCloseVersion(Integer journeyType, String version) {
//        if (Objects.nonNull(version) && Objects.nonNull(journeyType) && journeyType == EnumPaxJourneyType.HITCH_GOODS.getCode() && com.hellobike.infrastructure.util.VersionUtils.getVersionNo(version) < com.hellobike.infrastructure.util.ApolloConfigUtil.getIntProperty(DeliverConsts.DELIVER_VERSION, 53905)) {
//            return true;
//        }
//        return false;
//    }
//
//    public static Boolean isRisk(DataBusResponse dataBusResponse) {
//        try {
//            if (dataBusResponse == null) {
//                return true;
//            }
//            Map<String, String> dataMap = dataBusResponse.getData();
//            if (dataMap == null) {
//                return true;
//            }
//            String respJson = dataMap.get("respJson");
//            if (Strings.isNullOrEmpty(respJson)) {
//                return true;
//            }
//            List<ImageScanResponse> imageScanResponses = JSON.parseArray(respJson, ImageScanResponse.class);
//            for (ImageScanResponse imageScanResponse : imageScanResponses) {
//                List<JSONObject> results = imageScanResponse.getResults();
//                if (results == null) {
//                    return true;
//                }
//                for (JSONObject result : results) {
//                    ImageScanResult imageScanResult = result.toJavaObject(ImageScanResult.class);
//                    if (!"pass".equals(imageScanResult.getSuggestion())) {
//                        return true;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            LogUtils.ERROR.error("analysisDataBusResponse error", e);
//            return true;
//        }
//        return false;
//    }
//}
