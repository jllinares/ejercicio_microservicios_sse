package org.jllinares.controllers;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.Valid;
import org.jllinares.config.RabbitConfig;
import org.jllinares.models.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * The Class QueueController.
 * @author Javier Llinares
 */
@RestController
public class QueueController {
	
	/** The rabbit template. */
	private final RabbitTemplate rabbitTemplate;
	
	/** The count. */
	private AtomicInteger count = new AtomicInteger();
	
	/**
	 * Instantiates a new producer controller.
	 *
	 * @param rabbitTemplate the rabbit template
	 */
	public QueueController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	/**
	 * Stream.
	 *
	 * @param persona the persona
	 * @return the sse emitter
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	@PostMapping("/queue")
	public SseEmitter queue(@RequestBody @Valid Person persona) throws IOException, InterruptedException {
		StopWatch watch = new StopWatch();
		watch.start();
		
		SseEmitter emitter = new SseEmitter();
		persona.setId(String.valueOf(count.getAndIncrement()));
		
		watch.stop();
		emitter.send("Ejecutado el procesamiento de la persona " + persona.getId() + " en " + watch.shortSummary());
		rabbitTemplate.convertAndSend(RabbitConfig.queueName, persona);
		emitter.complete();
		return emitter;
	}
}