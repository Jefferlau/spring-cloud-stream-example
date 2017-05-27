Spring Cloud Stream 示例
---

Spring Cloud Stream 是一个构建消息驱动的微服务框架。 Spring Cloud Stream 构建在 Spring Boot 之上用以创建工业级的应用程序，并且 Spring Integration 提供了和消息代理的连接。 Spring Cloud Stream 提供几个厂商消息中间件个性化配置，引入发布订阅、消费组和分区的语义概念。

为了更直观示意应用间消息驱动，本项目分别用生产者和消费者两个应用来示意不同角色。

``@EnableBinding``注解使用一个或者多个接口作为参数，接口中可以定义输入或输出的 channels，Spring Cloud Stream 定义了三个接口 Source，Sink，Processor，本例采用自定义接口``MessageSource``和``MessageSink``。

被``@StreamListener``修饰的方法可以立即连接到消息代理接收流处理事件。

# 生产者

本例的生产者即是消息发送方，其使用比较简单一是添加``@EnableBinding({MessageSource.class})``注解，二是配置文件配置消息中间件，三是消息发送类组件。

``@EnableBinding``注解比较简单，直接看``Starter``即可，不再细说。

先看配置文件的代码片段：

```yaml
producer_channel:
  destination: dest.exchange
  contentType: application/json
  binder: rabbit1
```

destination 这会在队列中间中创建 Exchange: dest.exchange，但是不会创建队列（Queue），即如果没有消费者先启动的话，生产者发送的消息会被丢弃。
contentType 这是定义使用 JSON 格式传递数据，默认是序列化对象（生产者和消费者需要同时拥有此类才能正常反序列化）。

至于消息发送组件，其实就是普通的``@Component``，注入在``@EnableBinding``里绑定的接口即可使用此接口示例发送消息。详见``MessageProducer``。

# 消费者

本例的消费者即是消息接收方，其使用也比较简单一是添加``@EnableBinding({MessageSource.class})``注解，二是配置文件配置消息中间件，三是``@StreamListener``注解的方法接收消息。

``@EnableBinding``注解比较简单，直接看``Starter``即可，不再细说。

先看配置文件的代码片段：

```yaml
consumer_channel:
  group: consumer
  destination: dest.exchange
  contentType: application/json
  binder: rabbit1
```

配置比生产者多了个 group，这会让应用启动后在消息中间件里创建队列``dest.exchange.consumer``并绑定到``dest.exchange``。
其他参数与生产者相同。

只有消息接收，只要``@Component``的方法注解``@StreamListener``参数是和``@EnableBinding``相同的接口，此方法即可接收到订阅的消息。详见``MessageConsumer``。
