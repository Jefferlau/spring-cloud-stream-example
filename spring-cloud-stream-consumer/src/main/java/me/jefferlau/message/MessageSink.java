package me.jefferlau.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Create on 2017-05-27.
 *
 * @author Jeffer Lau <jefferlzu@gmail.com>
 */
public interface MessageSink {
    String CONSUMER_CHANNEL = "consumer_channel";

    @Input(CONSUMER_CHANNEL)
    SubscribableChannel input();
}
