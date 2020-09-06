package com.xingjiahe.www.mapper;

import com.xingjiahe.www.model.UserAuthEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAuthEntityMapper {

    void insert(UserAuthEntity userAuthEntity);
}
