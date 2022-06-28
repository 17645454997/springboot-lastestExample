package com.xingjiahe.www.dao;

import com.xingjiahe.www.po.OrderCart;

public interface OrderCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(OrderCart record);

    int insertSelective(OrderCart record);

    OrderCart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(OrderCart record);

    int updateByPrimaryKey(OrderCart record);
}