//package com.example.mq.workqueue;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//public class RabbitMqUtils {
//    //得到一个连接的 channel
//    public static Channel getChannel() throws Exception{
////创建一个连接工厂
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("18.139.18.90");
//        factory.setPort(5672);
//        factory.setUsername("retailcloud");
//        factory.setPassword("retailcloud");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        return channel;
//    }
//}
//
