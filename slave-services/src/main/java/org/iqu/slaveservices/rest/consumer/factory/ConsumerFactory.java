package org.iqu.slaveservices.rest.consumer.factory;

import org.iqu.slaveservices.rest.consumer.EventsConsumer;
import org.iqu.slaveservices.rest.consumer.HealthCheckConsumer;
import org.iqu.slaveservices.rest.consumer.NewsConsumer;
import org.iqu.slaveservices.rest.consumer.impl.EventsConsumerImpl;
import org.iqu.slaveservices.rest.consumer.impl.HealthCheckConsumerImpl;
import org.iqu.slaveservices.rest.consumer.impl.NewsConsumerImpl;

/**
 * ConsumerFactory - Class that provides the same instance of a class for all
 * threads.
 * 
 * @author Alex Dragomir
 *
 */
public class ConsumerFactory {

	private static NewsConsumer newsConsumerInstance = null;
	private static EventsConsumer eventsConsumerInstance = null;
	private static HealthCheckConsumer healthCheckConsumerInstance = null;

	/**
	 * This method is used to ensure the return of the same instance of
	 * NewsConsumer for all threads.
	 */
	public static synchronized NewsConsumer getNewsConsumerInstance() {
		if (newsConsumerInstance == null) {
			synchronized (ConsumerFactory.class) {
				if (newsConsumerInstance == null) {
					newsConsumerInstance = new NewsConsumerImpl();
				}
			}
		}
		return newsConsumerInstance;
	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * EventsConsumer for all threads.
	 */
	public static synchronized EventsConsumer getEventsConsumerInstance() {
		if (newsConsumerInstance == null) {
			synchronized (ConsumerFactory.class) {
				if (eventsConsumerInstance == null) {
					eventsConsumerInstance = new EventsConsumerImpl();
				}
			}
		}
		return eventsConsumerInstance;
	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * EventsConsumer for all threads.
	 */
	public static synchronized HealthCheckConsumer getHealthCheckConsumerInstance() {
		if (healthCheckConsumerInstance == null) {
			synchronized (ConsumerFactory.class) {
				if (healthCheckConsumerInstance == null) {
					healthCheckConsumerInstance = new HealthCheckConsumerImpl();
				}
			}
		}
		return healthCheckConsumerInstance;
	}
}
