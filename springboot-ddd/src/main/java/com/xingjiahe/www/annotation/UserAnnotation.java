package com.xingjiahe.www.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/1 11:59 AM
 */
public class UserAnnotation {

     @SimpleAnnotation("testValue")
      @Test
     public  void testMethod(){
          //do something  here
     }


     private  static   void  annotationLogic(){
          Class   userAnnotationClass  = UserAnnotation.class;
          for(Method method :userAnnotationClass.getMethods()){
               SimpleAnnotation simpleAnnotation  = method.getAnnotation(SimpleAnnotation.class);
               if(simpleAnnotation !=null){
                    System.out.println(" Method Name : " + method.getName());
                    System.out.println(" value : " + simpleAnnotation.value());
                    System.out.println(" --------------------------- ");
               }
          }
     }
}
