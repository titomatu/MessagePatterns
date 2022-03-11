package io.tamatu.messagepatterns.configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfiguration {

    private final CamelContext camelContext;

    public RouterConfiguration(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Bean
    ProducerTemplate producerTemplate(){
        return camelContext.createProducerTemplate();
    }
}
