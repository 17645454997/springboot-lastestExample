package com.xingjiahe.www.dao;

import com.xingjiahe.www.po.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(Short regionId);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Short regionId);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}