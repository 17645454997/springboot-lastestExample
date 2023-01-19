package com.xingjiahe.www.generic;

import com.xingjiahe.www.exception.Result;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.List;


/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class TestT<T> {

    public static void main(String[] args) {
        TestT<Integer> tInt = new TestT<>();
        List<String> array = new ArrayList<String>();
        array.add("aaa");
        array.add("bbb");
        String str = tInt.getListFirst(array).getResult();
        System.out.println(str);
        TestT<Integer> tInt1 = new TestT<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        Integer num = tInt1.getListFirst(nums).getResult();
        System.out.println(num);
    }

    private <T> Result<T> getListFirst(List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return null;
        }
        return Result.newSuccResponse(data.get(0));
    }



}
