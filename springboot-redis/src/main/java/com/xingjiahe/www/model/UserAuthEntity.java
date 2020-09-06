package com.xingjiahe.www.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthEntity {
    public UserAuthEntity(){

    }
    private  String guid;
    private  String userGuid;
    private  Integer userNewId;
    private  String type;
    private  boolean flag;
}
