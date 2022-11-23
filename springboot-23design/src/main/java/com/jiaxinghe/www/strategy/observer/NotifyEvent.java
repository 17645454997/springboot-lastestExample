package com.jiaxinghe.www.strategy.observer;

import lombok.Data;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 3:05 PM
 */
@Data
public class NotifyEvent {

    private String mobileNo;

    private String emailNo;

    private String imNo;

    public NotifyEvent(String mobileNo, String emailNo, String imNo) {
        this.mobileNo = mobileNo;
        this.emailNo = emailNo;
        this.imNo = imNo;
    }
}
