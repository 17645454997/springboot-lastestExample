package com.xingjiahe.www.utils;

import com.xingjiahe.www.exception.ErrorCode;
import com.xingjiahe.www.exception.SimpleException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.logging.log4j.util.Strings;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class ValidateUtils {


    public static void validateXXDTO(){
        mustTrue(false,"");
    }

    public static void requireNonBlank(String param, String errorMsg){
        if(Strings.isBlank(param)){
            throw SimpleException.builder(ErrorCode.FAIL.getDesc(), ErrorCode.FAIL)
                    .errorMsg(errorMsg)
                    .build();
        }
    }


     public static void mustTrue(Boolean flag,String errorMsg){
        if(BooleanUtils.isNotTrue(flag)){
            throw SimpleException.builder(ErrorCode.FAIL.getDesc(), ErrorCode.FAIL)
                    .errorMsg(errorMsg)
                    .build();
        }
     }


}
