package com.xingjiahe.www.infrastructure.util;


//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendCallback;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RocketMQSendMessageTest {


//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "fat-kafka1.ttbike.com.cn:9092,fat-kafka2.ttbike.com.cn:9092,fat-kafka3.ttbike.com.cn:9092");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        Producer<String, String> producer = new KafkaProducer<>(props);
//        for (int i = 0; i < 1; i++) {
//            Future<RecordMetadata> future = producer.send(new ProducerRecord<String, String>("hjx-8c6b94bc_hitch_rocket_journey_line_crud_notify_topic", Integer.toString(i), Integer.toString(i)));
//            RecordMetadata metadata = future.get();
//            System.out.println(metadata.offset());
//            producer.close();
//        }
//    }
//public static void main(
//        String[] args) throws MQClientException
//        , InterruptedException,
//        UnsupportedEncodingException {
//
//    DefaultMQProducer producer = new DefaultMQProducer("Jodie_Daily_test");
//    producer.setNamesrvAddr("fat-mq1.ttbike.com.cn:9876");
//    producer.start();
//    producer.setRetryTimesWhenSendAsyncFailed(0);
//
//    int messageCount = 1;
//    final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
//    for (int i = 0; i < messageCount; i++) {
//        try {
//            final int index = i;
//            Message msg = new Message("hjx-8c6b94bc_hitch_rocket_journey_line_crud_notify_topic",                    "OrderID188",
//                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
//            producer.send(msg, new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
//                    countDownLatch.countDown();
//                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
//                }
//
//                @Override
//                public void onException(Throwable e) {
//                    countDownLatch.countDown();
//                    System.out.printf("%-10d Exception %s %n", index, e);
//                    e.printStackTrace();
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    countDownLatch.await(5, TimeUnit.SECONDS);
//    producer.shutdown();
//}
//

}

