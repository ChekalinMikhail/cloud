package com.example.consumer.listener;


import com.example.consumer.data.Payment;
import com.example.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Listener {

    private final Log logger = LogFactory.getLog(this.getClass());
    private final ConsumerService consumerService;

    @KafkaListener(groupId = "consumer", topics = "payments")
    public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
        logger.info(message);
        consumerService.processPayment(message);
        acknowledgment.acknowledge();
    }
}
