package com.xingjiahe.www.utils;

import java.util.Random;

public class NumUtil {
    public static final synchronized Integer getUUID(){
        StringBuilder str =new StringBuilder();
        Random random=new Random();
        for(int i=0;i<8;i++){
     str.append(random.nextInt(10));
        }
        int num=Integer.parseInt(str.toString());
        return  num;
    }
}
