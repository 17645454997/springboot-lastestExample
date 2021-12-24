package com.xingjiahe.www.rpc.service;

import com.xingjiahe.www.rpc.protocol.ProtoDemo;

public interface IUserService {
    ProtoDemo.Student findById(Long id);
}
