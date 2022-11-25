package com.xingjiahe.www.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 5:21 PM
 */
@Data
public class JourneyStatusMachine {

    /**
     * 状态机配置
     *
     * @see  JourneyStatusEnum
     *
     */
    private Map<String, List<String>>  statusSettingMap;
}
