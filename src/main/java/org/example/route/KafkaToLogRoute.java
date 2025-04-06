package org.example.route;

import org.apache.camel.builder.RouteBuilder;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaToLogRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("kafka:my-topic?brokers=amq-streams-kafka-kafka-bootstrap.amq-streams-kafka.svc:9092")
            .routeId("kafka-jslt-log")
            .log("Mensaje original desde Kafka: ${body}")
            .to("jslt:classpath:transformacion.jslt")
            .log("Mensaje transformado: ${body}");
    }
}
