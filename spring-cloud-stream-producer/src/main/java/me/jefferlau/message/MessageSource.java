package me.jefferlau.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Create on 2017-05-27.
 *
 * @author Jeffer Lau <jefferlzu@gmail.com>
 */
public interface MessageSource {
    String PRODUCER_CHANNEL = "producer_channel";

    @Output(PRODUCER_CHANNEL)
    MessageChannel output();
}
