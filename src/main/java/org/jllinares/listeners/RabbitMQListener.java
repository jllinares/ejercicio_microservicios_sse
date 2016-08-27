package org.jllinares.listeners;

import org.jllinares.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * The listener interface for receiving rabbitMQ events.
 * The class that is interested in processing a rabbitMQ
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addRabbitMQListener<code> method. When
 * the rabbitMQ event occurs, that object's appropriate
 * method is invoked.
 *
 * @see RabbitMQEvent
 * @author Javier Llinares
 */
@Component
public class RabbitMQListener {
	
	/**
	 * Listen.
	 *
	 * @param message the message
	 */
	@RabbitListener(queues = RabbitConfig.queueName)
	public void listen(Message message) {
		System.out.println("--------->> Recibiendo Mensaje");
		System.out.println("--------->> " + message.getMessageProperties());
	}
}
