package com.xingjiahe.www.infrastructure.util;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @author zhouqingchun E-mail:zhouqingchun@hellobike.com
 * @version 1.0.0
 * @since 2018年4月19日 下午2:16:18
 */
public class MoneyUtils {

	public static String getPercentFormat(String rate) {
		Integer percent = new BigDecimal(rate).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return percent + "%";
	}

	public static String getPercentFormat2(String rate) {
		Integer percent = new BigDecimal(rate).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		return percent.toString();
	}

    public static String getPercentFormat(Double rate) {
        if(rate == null) {
            return "0.00%";
        }
        Integer percent = new BigDecimal(rate).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        return percent + "%";
    }

	public static String getPercentFormat(String rate, int scale) {
		Integer percent = new BigDecimal(rate).multiply(new BigDecimal(100)).setScale(0, scale).intValue();
		return percent + "%";
	}

	public static Long transYuanToFen(String str) {
		BigDecimal bd = new BigDecimal(str).multiply(new BigDecimal(100));
		return bd.longValue();
	}

	public static Long transYuanToFenABS(String str) {
		BigDecimal bd = new BigDecimal(str).multiply(new BigDecimal(100)).abs();
		return bd.longValue();
	}

	public static Long transToLongABS(String str) {
		BigDecimal bd = new BigDecimal(str).abs();
		return bd.longValue();
	}

	public static Long transToLong(String str) {
		BigDecimal bd = new BigDecimal(str);
		return bd.longValue();
	}

	public static String transFenToYuan(Long amount) {
		BigDecimal bd = new BigDecimal(amount).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
		return bd.toPlainString();
	}

	public static String transFenToYuan(Integer amount) {
		if(Objects.isNull(amount)){
			return "0";
		}
		BigDecimal bd = new BigDecimal(amount).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
		return bd.toPlainString();
	}

	public static BigDecimal transFenToYuan(BigDecimal amount) {
		return amount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
	}

    public static BigDecimal transFenToYuanOneScale(BigDecimal amount) {
        return amount.divide(new BigDecimal(100), 1, BigDecimal.ROUND_HALF_UP);
    }
	
	public static BigDecimal transYuanToFenABS(BigDecimal str) {
		return str.multiply(new BigDecimal(100)).abs();
	}

	public static String transYuanToFenString(String str) {
		BigDecimal bd = new BigDecimal(str).multiply(new BigDecimal(100)).setScale(0);
		return bd.toPlainString();
	}

	public static BigDecimal format(BigDecimal amount) {
		return amount.divide(new BigDecimal(100)).setScale(1, BigDecimal.ROUND_UP).multiply(new BigDecimal(100))
				.setScale(0, BigDecimal.ROUND_DOWN);
	}

	public static String transFenToYuanRemoveZeros(BigDecimal amount) {
		return amount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
	}
	
}
