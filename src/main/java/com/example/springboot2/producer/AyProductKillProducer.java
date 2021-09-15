package com.example.springboot2.producer;

import com.example.springboot2.model.AyUserKillProduct;
import com.example.springboot2.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.jms.Destination;

// 生产者

@Service
public class AyProductKillProducer {

    //日志
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     *  描述：发送消息
     * @param destination 目标地址
     * @param killProduct 描述商品
     */
    public void sendMessage(Destination destination, final AyUserKillProduct killProduct) {
        logger.info("AyProductKillProducer sendMessage , killProduct is" + killProduct);
        jmsMessagingTemplate.convertAndSend(destination, killProduct);
    }
}
