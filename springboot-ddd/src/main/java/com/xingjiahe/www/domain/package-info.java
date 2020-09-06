package com.xingjiahe.www.domain;
/**
 * DDD :domain 领域层
 * 领域层主要负责表达业务概念，业务状态信息和业务规则
 * Domain 层是整个系统的核心层，几乎全部的业务逻辑都会在该层实现
 * 领域模型主要包含以下细节
 * 实体（entity）:具有唯一标示的对象
 * 值对象（VO）Value Objects：无需唯一标示的对象
 * 领域服务（Domain Services）本质是一些逻辑的操作
 * 聚合跟（aggregates）聚合是指一组具有内聚关系的相关对象的集合
 * 多个对象聚合为聚合成一个对象，那么这个对象就是root
 * 工厂模式：创建复杂对象，隐藏创建的细节
 * 仓储（Respository）
 */
