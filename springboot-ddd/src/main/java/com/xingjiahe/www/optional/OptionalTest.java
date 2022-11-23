package com.xingjiahe.www.optional;


import java.util.Optional;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/11/18 4:54 PM
 */
public class OptionalTest {

    public static void main(String args[]) throws ServiceException {
          Person person  = new Person();
         person.setAge(2);
         person.setName("何佳兴");
         System.out.println(Optional.of(person).get());
         Optional.of(person).filter(p->p.getAge()>50);
         String optName  = Optional.of(person).map(p-> person.getName()).orElse("name 为空");
         System.out.println(optName);
         System.out.println(Optional.ofNullable(person.getName()).orElseThrow(new ServiceException(200,"person name is null")));

    	}
}
