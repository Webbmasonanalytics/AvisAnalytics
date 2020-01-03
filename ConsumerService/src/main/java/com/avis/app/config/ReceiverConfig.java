package com.avis.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class ReceiverConfig {

    @Value("${kafka.group.id}")
    private String groupId;
    @Value("${kafka.bootstrap.servers}")
    private String kafkaServers;
    @Value("${kafka.auto.offset.reset}")
    private String offsetRest;
    @Value("${kafka.auto.commit}")
    private String autoCommit;
    
    @Value("${kafka.security.protocol}")
    private String securityProtocol;
    
    @Value("${kafka.ssl.enabled.protocols}")
    private String sslEnabledProtocols;
    
    @Value("${kafka.ssl.truststore.type}")
    private String sslTrustStoreType;
    
    @Value("${kafka.ssl.cipher.suites}")
    private String sslCipherSuites;
    
    @Value("${kafka.ssl.endpoint.identification.algorithm}")
    private String sslEndPointIdentificationAlgorithm;
    

    @Bean
    public Map<String,Object> consumerConfigs() {
        Map<String,Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetRest);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
        
        //SSL

        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, securityProtocol);
        props.put(SslConfigs.SSL_ENABLED_PROTOCOLS_CONFIG,sslEnabledProtocols);
        props.put(SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG,sslTrustStoreType);
        props.put(SslConfigs.SSL_CIPHER_SUITES_CONFIG,sslCipherSuites);
        props.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG,sslEndPointIdentificationAlgorithm);

        

        return props;
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String,Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}