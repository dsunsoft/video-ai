package com.dsunsoft.core.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rabbitmq ProducerService
 * 
 * @author ygm
 *
 */
//@Service
public class ProducerServiceImpl implements ProducerService {
	private static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);

	/*
	 * @Autowired private AmqpTemplate amqpTemplate;
	 */
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 转换并发送消息
	 */
	@Override
	public void send(String queueKey, Object object) throws AmqpException {
		try {
			rabbitTemplate.convertAndSend(queueKey, object);
		} catch (Exception e) {
			logger.error("send error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 转换并发送消息,且等待消息者返回响应消息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T sendAndReceive(String queueKey, Object object) throws AmqpException {
		try {
			T t = (T) rabbitTemplate.convertSendAndReceive(queueKey, object);
			return t;
		} catch (Exception e) {
			logger.error("sendAndReceive error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 转换并发送消息,且等待消息者返回响应消息
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T sendAndReceive(String exchange, String routingKey, Object message) throws AmqpException {
		try {
			T t = (T) rabbitTemplate.convertSendAndReceive(exchange, routingKey, message);
			return t;
		} catch (Exception e) {
			logger.error("sendAndReceive error:" + e.getMessage());
			throw e;
		}
	}
}
