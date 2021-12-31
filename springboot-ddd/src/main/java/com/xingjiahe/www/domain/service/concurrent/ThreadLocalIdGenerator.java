package com.xingjiahe.www.domain.service.concurrent;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/25 下午9:31
 */
public class ThreadLocalIdGenerator {
    private  static final ThreadLocal<IdGenerator>  idGenerator = new ThreadLocal<IdGenerator>(){
        @Override
        protected IdGenerator initialValue() {
            return new IdGenerator();
        }
    };
    public static int getNext(){
      return  idGenerator.get().getNext();
    }
}
