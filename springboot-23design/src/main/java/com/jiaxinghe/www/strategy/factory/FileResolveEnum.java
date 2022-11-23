package com.jiaxinghe.www.strategy.factory;

import lombok.AllArgsConstructor;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/23 4:06 PM
 */
@AllArgsConstructor
public enum FileResolveEnum {
    /**
     * A文件类型
     */
    AFILE(101,"A文件类型"),
    /**
     * B文件类型
     */
    BFILE(102,"B文件类型");

    /**
     * 枚举code
     */
    int code;
    /**
     * 枚举信息
     */
    String message;
}
