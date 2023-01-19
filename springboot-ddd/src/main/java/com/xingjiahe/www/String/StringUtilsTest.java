package com.xingjiahe.www.String;

import org.apache.commons.lang3.StringUtils;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class StringUtilsTest {

    public static void main(String[] args) {
        System.out.println(StringAnyBlankTest("null",null));
    }

    public static boolean StringAnyBlankTest(String dateStartTime,String dateEndTime){
        if (StringUtils.isAnyBlank(dateStartTime, dateEndTime)) {
            return false;
        }
        return  true;
    }
}
