package org.jllinares.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class RabbitConfig.
 * @author Javier Llinares
 */
@Configuration
public class RabbitConfig {
	
	/** The Constant queueName. */
	public final static String queueName = "queueEjercicio";
	
	/**
	 * Queue.
	 *
	 * @return the queue
	 */
	@Bean
	Queue queue() { return new Queue(queueName); }
	
	/**
	 * Exchange.
	 *
	 * @return the topic exchange
	 */
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("exchange-ejercicio");
	}
	
	/**
	 * Direct.
	 *
	 * @return the direct exchange
	 */
	@Bean
	DirectExchange direct() {
		return new DirectExchange("direct-ejercicio");
	}
	
	/**
	 * Binding.
	 *
	 * @param queue the queue
	 * @param exchange the exchange
	 * @return the binding
	 */
	@Bean
	Binding bindingExchange(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	/**
	 * Binding direct.
	 *
	 * @param queue the queue
	 * @param direct the direct
	 * @return the binding
	 */
	@Bean
	Binding bindingDirect(Queue queue, DirectExchange direct) {
		return BindingBuilder.bind(queue).to(direct).with(queueName);
	}
}