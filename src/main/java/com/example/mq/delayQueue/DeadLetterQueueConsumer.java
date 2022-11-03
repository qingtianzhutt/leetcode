package com.example.mq.delayQueue;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

//@Slf4j
@Component
public class DeadLetterQueueConsumer {
    @RabbitListener(queues = "QD")
    public void receiveD(Message message, Channel channel) throws IOException
    {String msg = new String(message.getBody());
//        log.info("当前时间： {},收到死信队列信息{}", new Date().toString(), msg);
        System.out.println(new Date() + "msg: " + msg);
    }

    @RabbitListener(queues = "TestDirectQueue")
    public void rabbitTest(Message message, Channel channel) throws IOException {
        String jsonStr = new String(message.getBody(), "UTF-8");
        String msg = new String(message.getBody());
//        log.info("当前时间： {},收到死信队列信息{}", new Date().toString(), msg);
        System.out.println(new Date() + "msg: " + jsonStr);

    }
}
