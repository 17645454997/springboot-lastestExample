//package com.xingjiahe.www.infrastructure.util;
//
//import com.hellobike.constant.Consts;
//import com.hellobike.hitchjourney.dto.detail.PriceInfoDto;
//import org.apache.commons.lang.StringUtils;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
///**
// * <pre>
// *
// * </pre>
// *
// * @author renlele
// * @since 2018年5月14日 14:16:18
// */
//public class TextBuildUtils {
//
//    public static String buildDynamicText(String hitchPercent, PriceInfoDto priceInfo) {
//        StringBuilder builder = new StringBuilder();
//        String hitchRate = com.hellobike.infrastructure.util.MoneyUtils.getPercentFormat(hitchPercent);
//        builder.append(String.format(Consts.MSG_HITCH_RATE_TEXT, hitchRate));
//        if (priceInfo != null && priceInfo.getDriverProFarePrice() != null && priceInfo.getDriverProFarePrice() > 0) {
//            BigDecimal totalPrice = BigDecimal.valueOf(priceInfo.getDriverProFarePrice());
//
//            if(priceInfo.getBounty() != null) {
//                totalPrice = totalPrice.add(new BigDecimal(priceInfo.getBounty()));
//            }
//
//            builder.append(String.format(Consts.MSG_FARE_PRICE, digitConverter(totalPrice)));
//
////            if (priceInfo.getThanksFee() != null && priceInfo.getThanksFee() > 0) {
////                builder.append(String.format(Consts.MSG_THANKS_FEE, Consts.MSG_CONJUNCTION_WITH, digitConverter(BigDecimal.valueOf(priceInfo.getThanksFee()))));
////                if (priceInfo.getBounty() != null && priceInfo.getBounty() > 0) {
////                    builder.append(String.format(Consts.MSG_BOUNTY_V2, digitConverter(BigDecimal.valueOf(priceInfo.getBounty()))));
////                }
////            } else {
////                // 感谢费为空或为0,奖励金不为0，需要展示奖励金文案
////                if (priceInfo.getBounty() != null && priceInfo.getBounty() > 0) {
////                    builder.append(String.format(Consts.MSG_BOUNTY, Consts.MSG_CONJUNCTION_WITH, digitConverter(BigDecimal.valueOf(priceInfo.getBounty()))));
////                }
////            }
//        }
//        return builder.toString();
//    }
//
//    public static String digitConverter(BigDecimal input) {
//        if (input == null) {
//            return null;
//        }
//        return input.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
//    }
//
//    public static String subStringForIntenalMsg(String str, String separator) {
//        return StringUtils.substringBefore(str, separator);
//    }
//}
