package com.xingjiahe.www.demo;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class MockTest {




    public static void main(String[] args) {
        //使用if return 语法 执行mock测试 如果命中了，执行过就return否则继续向下执行
        if(consoOrderCreate()){
            return;
        }


    }


    private static boolean consoOrderCreate(){
        return  true;
    }
}
