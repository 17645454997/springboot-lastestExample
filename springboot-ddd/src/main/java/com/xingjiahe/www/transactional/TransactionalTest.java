package com.xingjiahe.www.transactional;

import lombok.SneakyThrows;
import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1.Transactional 不能用在接口上
 * 2.Transactional 不能用在final 或static 修饰的方法或者类上
 *
 *
 *
 * @author haisongzhe
 * @date 2022/12/17
 */
public class TransactionalTest {


    /**
     * 事物会失效 内部方法调用没有使用到代理
     * SneakyThrows 会生成try catch 代码块并将异常向上抛出来
     */
 @Transactional(rollbackFor = Exception.class)
 @SneakyThrows
  public  void createUserTransactionalFail(){
      this.createUser1();
      throw  new RuntimeException();
  }


    /**
     *
     * SneakyThrows 会生成try catch 代码块并将异常向上抛出来
     */
    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    public  void createUserTransactionalSuccess(){
        ((TransactionalTest)AopContext.currentProxy()).createUser1();
        this.createUser1();
        throw  new RuntimeException();
    }

    @Transactional(rollbackFor = Exception.class ,propagation = Propagation.REQUIRES_NEW)
    public  void createUser1(){

    }


    /**
     * 不支持非public修饰的方法进行事物管理
     * 事物的信息是和线程绑定的多线程环境下，事物单的信息都是独立的，将会导致Spring在接管事物上
     * 出现差异
     */


    /**
     * PROPAGATION_SUPPORTS
     * PROPAGATION_NOT_SUPPORTED
     * PROPAGATION_NEVER
     * 这三种事物传播级别发生异常不会回滚
     */


    /**
     * 进行异常捕获回滚不要手动捕获异常后不向上抛出
     */

    /**
     * 嵌套事物 如果想要只回滚事物A 种的报错操作，
     * 但不影响主逻辑中的报错操作
     * 可以使用try - catch 把不想回滚的用try-catch 包主
     * 使用PROPAGATION.REQUIRES_NEW
     */


}
