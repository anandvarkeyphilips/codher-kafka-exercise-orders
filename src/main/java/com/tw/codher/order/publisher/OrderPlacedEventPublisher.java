package com.tw.codher.order.publisher;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderPlacedEventPublisher {

    @Value("${order.created.topic}")
    String topicName;

    @Value("${broker.url}")
    String brokerUrl;

    public void publish() {

        Map<String, Object> producerProperties = getProducerProperties();

        Producer<Integer, String> producer = null;//Create a valid Producer

        //publish a message with key using one of the Producer API method

        producer.flush();
        producer.close();
    }

    private Map<String, Object> getProducerProperties() {
        Map<String, Object> producerProperties = new HashMap();
        //Uncomment the below code after passing the correct kafka properties in the application.properties file
//        producerProperties.put("bootstrap.servers", brokerUrl);
//        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
//        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return producerProperties;
    }
}
