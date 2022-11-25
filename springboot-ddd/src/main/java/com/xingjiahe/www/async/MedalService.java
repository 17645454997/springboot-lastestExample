package com.xingjiahe.www.async;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/24 3:55 PM
 */
public class MedalService {

    public MedalInfo getMedalInfo(Long userId){
        return  new MedalInfo(userId);
    }
}
