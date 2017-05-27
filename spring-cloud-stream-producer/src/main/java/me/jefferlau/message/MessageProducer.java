package me.jefferlau.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 消息发送方
 * Create on 2017-05-27.
 *
 * @author Jeffer Lau <jefferlzu@gmail.com>
 */
@Component
public class MessageProducer {
    private static Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    private MessageSource messageSource;

    @Autowired
    public MessageProducer(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * 发送信息
     * @param object
     */
    public boolean sendMessage(Object object) {
        System.out.println("++++++++++++++++");
        logger.info("Send Message: " + object);
        System.out.println("++++++++++++++++");
        return messageSource.output().send(MessageBuilder.withPayload(object).build());
    }
}
