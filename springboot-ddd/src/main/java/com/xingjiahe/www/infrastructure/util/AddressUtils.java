//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.base.proto.Protos;
//import com.hellobike.base.proto.error.BizError;
//import com.hellobike.constant.Consts;
//import com.hellobike.domain.base.SimpleAddress;
//import com.hellobike.hitch.common.model.Proto;
//import org.apache.commons.lang.StringUtils;
//
//import java.math.BigDecimal;
//
//public class AddressUtils {
//
//    public static final BigDecimal LAT_MAX = new BigDecimal("90");
//
//    /**
//     * 修复app端经纬度传错的问题
//     * @param address
//     */
//    public static void reviseAddress(SimpleAddress address) {
//        if (address != null) {
//            if (StringUtils.isNotEmpty(address.getLat()) && StringUtils.isNotEmpty(address.getLon()) ) {
//                if (new BigDecimal(address.getLat()).compareTo(LAT_MAX) > 0) {
//                    String lat = address.getLat();
//                    address.setLat(address.getLon());
//                    address.setLon(lat);
//                }
//            }
//        }
//    }
//
//    public static Proto checkAddress(String lon, String lat, String cityCode) {
//        if (StringUtils.isBlank(lon)
//                || StringUtils.isBlank(lat)
//                || lon.matches(Consts.EMPTY_ADDRESS_REGEX)
//                || lat.matches(Consts.EMPTY_ADDRESS_REGEX)
//                || !MainlandUtils.isMainland(lon, lat)) {
//            return Protos.fail(BizError.ERROR_LON_LAT);
//        }
//
//        if (StringUtils.isBlank(cityCode)) {
//            return Protos.fail(BizError.ERROR_CITY_CODE);
//        }
//
//        return null;
//    }
//
//    public static BizError checkAddrSign(String addrSign, String version, String startShortAddr, String endShortAddr, Boolean checkVersion) {
//		//起终点名称风控过滤
//        int versionInt = VersionUtils.getVersionNo(version);
//		if (versionInt < Consts.ADDR_SIGN_CHECK_VERSION) {
//			String newPaySwitch = ApolloConfigUtil.getProperty("check.addr.switch", "open");
//			if (StringUtils.equals("open", newPaySwitch) && checkVersion) {
//				return BizError.OLD_PUBLIC_VERSION;
//			} else {
//				return null;
//			}
//		} else {
//			String addrSignToCheck = (MD5Utils.md5((startShortAddr.concat(Consts.SEPARATOR).concat(endShortAddr).concat(Consts.ADDR_SIGN_SALT)))).substring(6, 26);
//			if(StringUtils.equals(addrSignToCheck, addrSign)){
//            	return null;
//            }
//            return BizError.SYSTEM_ERROR;
//        }
//	}
//
//}
