package com.xingjiahe.www.workflow;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 5:23 PM
 */
@Getter
@AllArgsConstructor
public enum JourneyStatusEnum {
    /**
     * 订单状态枚举
     */
    PENDING(10,"PENDING","待接单"),
    WAIT_TO_BUYER_CONFIRM(20,"WAIT_TO_BUYER_CONFIRM","待用户确认");

  private Integer status;

  private String value;

  private String desc;

}
