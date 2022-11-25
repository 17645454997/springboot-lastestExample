package com.xingjiahe.www.workflow;

import lombok.Data;

import java.util.Map;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 5:19 PM
 */
@Data
public class StatusMachineManager {

    private Map<String,JourneyStatusMachine> statusMachineMap;
}
