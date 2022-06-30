package com.xingjiahe.www.test;

import java.util.PriorityQueue;

public class SwitchTest {

    public static void main(String[] args) {
        System.out.println(test(1));
    }
    public  static  final  int  EE_XXX_OO = 1;
    public static int test(Integer code){
        switch (code){
            case EE_XXX_OO:
                return 1;
            case 2:
                return 2;
            default:
                return 3;
        }
    }
}
