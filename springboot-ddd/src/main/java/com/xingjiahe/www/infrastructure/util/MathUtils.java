package com.xingjiahe.www.infrastructure.util;

import java.util.Random;

/**
 * Description
 * Copyright HelloBike
 *
 * @author limingjun
 * @version 1.0
 * @date 2019/2/28
 */
public class MathUtils {

    private static final Random RAND = new Random();

    /**
     * 求[Min,Max]区间之间的随机整数。
     * @param Min 最小值
     * @param Max 最大值
     * @return 一个Min和Max之间的随机整数
     */
    public static int randomIntMinToMax(int Min, int Max) {
        //如果相等，直接返回，还生成个屁
        if (Min == Max) {
            return Max;
        }
        //如果Min比Max大，交换两个的值，如果不交换下面nextInt()会出错
        if (Min > Max) {
            Min ^= Max;
            Max ^= Min;
            Min ^= Max;
        }
        return RAND.nextInt(Max - Min + 1) + Min;
    }


}
