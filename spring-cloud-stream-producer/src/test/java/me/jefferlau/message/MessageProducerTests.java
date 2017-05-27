package me.jefferlau.message;

import me.jefferlau.domain.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Create on 2017-05-27.
 *
 * @author Jeffer Lau <jefferlzu@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerTests {

    @Autowired
    private MessageProducer producer;

    @Test
    public void sendMessage() {
        News news = new News();
        news.setId(UUID.randomUUID().toString());
        news.setTitle("中共中央政治局召开会议 习近平主持会议");
        news.setDescription("会议指出，党的十八大以来，以习近平同志为核心的党中央把巡视作为推进全面从严治党的重大举措，对加强和改进巡视工作作出一系列重大决策部署，坚持党内监督和群众监督相结合，赋予巡视制度新的活力。实践证明，巡视工作是治标之举，也是治本之策，必须在坚持中深化、在深化中坚持，发挥标本兼治作用。");
        news.setLink("http://news.sina.com.cn/gov/zt/xjpbdj/");
        news.setPubDate(1495867928598L);

        boolean retValue = producer.sendMessage(news);
        assertThat(retValue).isTrue();
    }
}
