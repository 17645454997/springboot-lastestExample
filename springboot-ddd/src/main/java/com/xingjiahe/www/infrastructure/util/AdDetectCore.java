package com.xingjiahe.www.infrastructure.util;

public class AdDetectCore {

    private static final char[] NUM_KEYS = (
            "1234567890①②③④⑤⑥⑦⑧⑨❶❷❸❹❺❻❼❽❾○一二三四五六七八九⒈⒉⒊⒋⒌⒍⒎⒏⒐" +
            "㈠㈡㈢㈣㈤㈥㈦㈧㈨⑴⑵⑶⑷⑸⑹⑺⑻⑼零壹贰叁肆伍陆柒捌玖１２３４５６７８９０" +
            "abcdefghijklmnopqrstuvwxyz")
            .toCharArray();

    private static final int MIDDLE_BLANK_MAX = 8;            // 如果空格大于等于 8 则认为是广告

    private static final int NUM_PERCENT_LENGTH_MIN = 8;      // 如果数字占比超过 60% 且长度大于等于 8 则认为是广告
    private static final int NUM_PERCENT_VALUE_MIN = 60;      // 如果数字占比超过 60% 且长度大于等于 8 则认为是广告

    /**
     * 判断一个地址是否为广告地址
     * @param addr 地址
     * @return 是否是广告地址
     */
    public static boolean isAdAddr(String addr) {
        return isAdByMiddleBlank(addr.trim()) || isAdByNumPercent(addr.trim());
    }

    /**
     * 判断起始地和目的地短地址是否为广告
     * @param startAddr 起始地短地址
     * @param endAddr 目的地短地址
     * @return 是否是广告地址
     */
    public static boolean isAdAddr(String startAddr, String endAddr) {
        return isAdAddr(startAddr) || isAdAddr(endAddr);
    }

    /** ---------------------------------------------
     * ** 规则实现如下 *****
     * 1. 如果空格大于 4 则认为是广告
     * 2. 如果数字占比超过 60% 且长度大于等于 8 则认为是广告，如果包含地址字符则减少字符计算
     * 3. ...
     * 4. 白名单
     * 5. 黑名单，清洗地址后判断是否包含黑名单关键字（以微信号为主）
     * -----------------------------------------------
     */

    /**
     * 检查地址中空格数量
     * @param addr 地址
     * @return 是否是广告地址
     */
    private static boolean isAdByMiddleBlank(String addr) {
        int count = 0;
        for (int i = 0; i < addr.length(); i++) {
            char blank = addr.charAt(i);
            if (blank == ' ') {
                count++;
            }
        }
        return count >= MIDDLE_BLANK_MAX;
    }

    /**
     * 检测数字占比
     * @param addr 地址
     * @return 是否是广告地址
     */
    private static boolean isAdByNumPercent(String addr) {
        int count = 0;
        for (int i = 0; i < addr.length(); i++) {
            char num = addr.charAt(i);
            for (char c : NUM_KEYS) {
                if (num == c) {
                    count++;
                    break;
                }
            }
        }
        if (count < 0) {
            count = 0;
        }
        int clearAddLength = addr.replace(" ", "").length(); // 剔除空格之后的长度
        return clearAddLength >= NUM_PERCENT_LENGTH_MIN && count * 100 / clearAddLength > NUM_PERCENT_VALUE_MIN;
    }

}