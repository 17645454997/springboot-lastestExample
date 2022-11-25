package com.xingjiahe.www.async;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/24 3:55 PM
 */
public class UserInfoService {
    public   UserInfo getUserInfo(Long userId) {
        return  new UserInfo(userId);
    }
}
