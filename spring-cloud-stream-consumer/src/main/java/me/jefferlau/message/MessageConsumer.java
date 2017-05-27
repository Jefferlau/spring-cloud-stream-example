package me.jefferlau.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收方
 * Create on 2017-05-27.
 *
 * @author Jeffer Lau <jefferlzu@gmail.com>
 */
@Component
public class MessageConsumer {

    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @StreamListener(MessageSink.CONSUMER_CHANNEL)
    public void consumer(Object object) {
        System.out.println("--------");
        logger.info(object.toString());
        System.out.println("--------");
    }
}
