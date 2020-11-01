//package com.xingjiahe.www.infrastructure.util;
//
//import org.apache.commons.lang3.StringUtils;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
///**
// * <pre>
// *
// * </pre>
// *
// * @author zhouqingchun E-mail:zhouqingchun@hellobike.com
// * @version 1.0.0
// * @since 2019年4月1日 下午2:44:30
// */
//public class MD5Utils {
//
//	/**
//	 * 用来将字节转换成 16 进制表示的字符
//	 */
//	static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
//			'9', 'a', 'b', 'c', 'd', 'e', 'f' };
//
//	public static String md5(String content) {
//		if (StringUtils.isBlank(content)) {
//			return null;
//		}
//		try {
//			byte[] b = content.getBytes("UTF-8");
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.reset();
//			md.update(b);
//			byte[] hash = md.digest();
//			StringBuffer outStrBuf = new StringBuffer(32);
//			for (int i = 0; i < hash.length; i++) {
//				int v = hash[i] & 0xFF;
//				if (v < 16) {
//					outStrBuf.append('0');
//				}
//				outStrBuf.append(Integer.toString(v, 16).toLowerCase());
//			}
//			return outStrBuf.toString();
//		} catch (Exception e) {
//			LogUtils.ERROR.error("MD5Utils#md5 error and content is {}", content);
//		}
//		return null;
//	}
//
//	/**
//	 * 对一段String生成MD5加密信息
//	 *
//	 * @param message 要加密的String
//	 * @return 生成的MD5信息
//	 */
//	public static String getMD5(String message) {
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			byte[] b = md.digest(message.getBytes());
//			return byteToHexString(b);
//		} catch (NoSuchAlgorithmException e) {
//			LogUtils.ERROR.error("getMD5 error",e);
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	/**
//	 * 把byte[]数组转换成十六进制字符串表示形式
//	 *
//	 * @param tmp 要转换的byte[]
//	 * @return 十六进制字符串表示形式
//	 */
//	private static String byteToHexString(byte[] tmp) {
//		String s;
//		// 每个字节用 16 进制表示的话，使用两个字符
//		char[] str = new char[16 * 2];
//		// 所以表示成 16 进制需要 32 个字符,表示转换结果中对应的字符位置
//		int k = 0;
//		// 从第一个字节开始，对 MD5 的每一个字节
//		for (int i = 0; i < 16; i++) {
//			// 转换成 16 进制字符的转换,取第 i 个字节
//			byte byte0 = tmp[i];
//			// 取字节中高 4 位的数字转换,
//			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
//			// >>> 为逻辑右移，将符号位一起右移,取字节中低 4 位的数字转换
//			str[k++] = hexDigits[byte0 & 0xf];
//		}
//		// 换后的结果转换为字符串
//		s = new String(str);
//		return s;
//	}
//}
