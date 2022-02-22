package com.xingjiahe.www.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/2/21 上午11:32
 */
public class TwoSum {
    public static void main(String[] args) {
        int[]nums = new int[]{1,3,4,5,7,6,9};
        System.out.println(twoSum(9,nums));
    }

    public  static ArrayList twoSum(int target, int[]nums){
        Map<Integer,Integer> map = new HashMap<>(16);
        ArrayList list  = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey((target-nums[i]))){
              list.add(nums[i]);
              list.add(target-nums[i]);
              return list;
            }else {
                map.put(nums[i],i);
            }
        }
        return  new ArrayList();
    }
}
