package com.xingjiahe.www.dao;

import com.xingjiahe.www.po.OrderCustomerAddress;

public interface OrderCustomerAddressMapper {
    int deleteByPrimaryKey(Integer customerAddrId);

    int insert(OrderCustomerAddress record);

    int insertSelective(OrderCustomerAddress record);

    OrderCustomerAddress selectByPrimaryKey(Integer customerAddrId);

    int updateByPrimaryKeySelective(OrderCustomerAddress record);

    int updateByPrimaryKey(OrderCustomerAddress record);
}