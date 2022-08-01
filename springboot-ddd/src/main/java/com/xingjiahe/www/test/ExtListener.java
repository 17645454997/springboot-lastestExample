package com.xingjiahe.www.test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/26 5:08 PM
 */
@Component
public class ExtListener{

//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
//       if(event instanceof  EmailEvent ){
//           EmailEvent emailEvent = (EmailEvent)event;
//           emailEvent.print();
//           System.out.println("the source is:"+emailEvent.getSource());
//           System.out.println("the address is:"+emailEvent.address);
//           System.out.println("the email's context is:"+emailEvent.text);
//
//       }
//
//    }

    @EventListener
    public void doHandler(EmailEvent event) {
        if(event instanceof  EmailEvent ){
            EmailEvent emailEvent = event;
            emailEvent.print();
            System.out.println("the source is:"+emailEvent.getSource());
            System.out.println("the address is:"+emailEvent.address);
            System.out.println("the email's context is:"+emailEvent.text);

        }
    }

}
