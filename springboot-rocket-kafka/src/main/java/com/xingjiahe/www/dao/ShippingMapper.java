package com.xingjiahe.www.dao;

import com.xingjiahe.www.po.Shipping;

public interface ShippingMapper {
    int deleteByPrimaryKey(Byte shipId);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Byte shipId);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);
}