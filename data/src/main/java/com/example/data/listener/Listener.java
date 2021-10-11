package com.example.data.listener;

import com.example.data.data.Payment;
import com.example.data.service.DataService;
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
    private final DataService dataService;

    @KafkaListener(groupId = "data", topics = "processedPayments")
    public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
        logger.info(message);
        dataService.createPayment(message);
        acknowledgment.acknowledge();
    }
}
