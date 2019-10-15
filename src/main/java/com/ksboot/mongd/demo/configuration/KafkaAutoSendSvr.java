package com.ksboot.mongd.demo.configuration;

import com.ksboot.mongd.demo.provider.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaAutoSendSvr implements ApplicationListener<ApplicationStartedEvent> {
    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        /*for (int i = 0; i < 5; i++) {
            //调用消息发送类中的消息发送方法
            kafkaSender.send();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
