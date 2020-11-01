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
 * @since 2018年12月25日 下午11:04:36
 */
public class KilometerUtils {

	private static int FINAL_5 = 5;
	private static int FINAL_30 = 30;
	private static int FINAL_360 = 360;
	private static int FINAL_9999 = 9999;

	public static BigDecimal meterToKilometer(Long meter) {
		return new BigDecimal(String.valueOf(meter)).divide(new BigDecimal("1000"));
	}
	
	public static BigDecimal meterToKilometer(BigDecimal meter) {
		return meter.divide(new BigDecimal("1000"));
	}

	public static String meterToKilometer(Integer meter) {
		return new BigDecimal(String.valueOf(meter)).divide(new BigDecimal("1000")).setScale(1, BigDecimal.ROUND_HALF_UP).toPlainString();
	}

	public static Float meterToKilometerV2(Integer meter) {
		if (Objects.isNull(meter)) {
			return Float.valueOf(0);
		}
		return Float.valueOf(new BigDecimal(String.valueOf(meter)).divide(new BigDecimal("1000")).setScale(1, BigDecimal.ROUND_HALF_UP).toPlainString());
	}
	
	public static BigDecimal formatAndUpToOneHundred (BigDecimal amount) {
		if(amount.compareTo(new BigDecimal("100")) < 0 ){
			amount = new BigDecimal("100");
			return amount;
		}
		return amount.divide(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_UP).multiply(new BigDecimal(100))
				.setScale(0, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 将里程费按5元分段,5-[0,5),10-[5,10),15-[10,15),20-[15,20),25-[20,25),...
	 * @param mileageFee
	 * @param interval
	 * @return
	 */
	public static int formatMileageFeeByInterval(BigDecimal mileageFee,int interval) {
		BigDecimal newMileageFee = mileageFee.divide(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_DOWN);
		BigDecimal[] result = newMileageFee.divideAndRemainder(new BigDecimal(interval));
		BigDecimal quotient = result[0];
		if ((quotient.intValue() + 1) * interval > FINAL_360) {
			return FINAL_9999;
		}
		return (quotient.intValue() + 1) * interval;
	}

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("35970");
		//System.out.println(formatAndUpToOneThirtyThousand(bigDecimal));
		System.out.println("--------------------");
		System.out.println(formatMileageFeeByInterval(bigDecimal,5));
		System.out.println("--------------------");
		//System.out.println(formatDistanceByInterval(bigDecimal,30));
	}
}
