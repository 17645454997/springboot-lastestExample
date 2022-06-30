package com.xingjiahe.www.utils;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/6/29 5:31 PM
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "何佳兴";
        String str2 = "何佳";
        int[] next = kmpNext(str2);
        System.out.println(str2+"的部分匹配表："+ Arrays.toString(next));
        int index = kmpSearch(str1, str2, next);
        System.out.println(index);
    }
    //编写一个获取字串部分匹配表的方法
    public static int[] kmpNext(String str){
        //创建一个和字符串等长度的数组，用来存放部分匹配表
        int[] next = new int[str.length()];
        next[0] = 0;//因为只有一个元素时，前缀为空，后缀也为空，所以长度为0
        //循环寻找前缀和后缀匹配的字符下标
        for (int i = 1,j = 0; i < str.length(); i++) {
            //当str.charAt(i) != str.charAt(j),并且j > 0时，j = next[j-1];,直到str.charAt(i) == str.charAt(j)
            while (j > 0 && str.charAt(i) != str.charAt(j)){
                j = next[j-1];
            }
            //假如只有两个元素，i=1，j=0，第一个元素和第二个元素匹配，则匹配表为[0,1],比如AA
            /*假如有三个元素ABA，
            从A开始考虑，A的前后缀都为空，所以next[0] = 0;
            考虑AB，前缀A，后缀B，没有共同字串，所以next[1] = 0;
            考虑ABA，前缀A，AB，后缀BA，A，有一个共同字串，并且长度为1，所以next[2] = 1;
            所以ABA的部分匹配表next={0,0,1}
             */
            if (str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    //写出kmp的搜索算法

    /**
     *
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表
     * @return 如果没有匹配返回-1，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        //遍历str1
        for (int i = 0,j= 0; i < str1.length(); i++) {
            //如果不匹配，则采用部分匹配表，重置i的位置，避免暴力匹配
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;//如果str1和 str2匹配，则str2的下拨啊加1
            }
            if(j == str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

}
