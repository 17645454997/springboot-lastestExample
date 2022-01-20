package com.xingjiahe.www.application.service.impl;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/18 上午11:06
 */
@Data
@Builder
public class RouteMeta {
    public static final RouteMeta DEFAULT = RouteMeta.builder()
            .build();

    private  final boolean  center = false;

    private final  String routeCode;

    private boolean fallbackToDefaultStrategy = false;

    public  boolean isEmpty(){return StringUtils.isEmpty(routeCode) && !center;}


}
