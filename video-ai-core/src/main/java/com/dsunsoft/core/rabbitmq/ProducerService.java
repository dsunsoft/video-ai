package com.dsunsoft.core.rabbitmq;

import org.springframework.amqp.AmqpException;

/**
 * rabbitmq ProducerService
 * 
 * @author ygm
 *
 */
public interface ProducerService {
	/**
	 * 发送消息到指定队列
	 *
	 * @param queueKey
	 * @param object
	 */
	void send(String queueKey, Object object) throws AmqpException;

	/**
	 * 发送消息到指定队列并返回响应消息
	 *
	 * @param queueKey
	 * @param object
	 */
	<T> T sendAndReceive(String queueKey, Object object) throws AmqpException;

	/**
	 * 发送消息到指定队列并返回响应消息
	 *
	 * @param exchange
	 * @param routingKey
	 * @param message
	 * @return
	 */
	<T> T sendAndReceive(String exchange, String routingKey, Object message) throws AmqpException;
}
