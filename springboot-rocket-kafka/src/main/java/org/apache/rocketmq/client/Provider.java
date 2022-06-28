package org.apache.rocketmq.client;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class Provider {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        /*消息发送*/
        //1. 创建消息生产者, 指定生产者所属的组名
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");
        //2. 指定Nameserver地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        //3. 启动生产者
        producer.start();
        //4. 创建消息对象，指定主题、标签和消息体
        String data = "hejiaxing666";
        Message msg = new Message("myTopic", "myTag", data.getBytes());
        //5. 发送消息
        SendResult sendResult = producer.send(msg, 10000);
        System.out.println(sendResult);
        //6. 关闭生产者
        producer.shutdown();
    }
}


