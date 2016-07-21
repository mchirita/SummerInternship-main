package org.iqu.webapp.factory;

import orq.iqu.slaveservices.events.EventsServiceSlave;
import orq.iqu.slaveservices.events.EventsServiceSlaveImpl;
import orq.iqu.slaveservices.news.NewsServiceSlave;
import orq.iqu.slaveservices.news.NewsServiceSlaveImpl;
import orq.iqu.slaveservices.others.HealthCheckServiceSlave;
import orq.iqu.slaveservices.others.HealthCheckServiceSlaveImpl;
import orq.iqu.slaveservices.others.ImageServiceSlave;
import orq.iqu.slaveservices.others.ImageServiceSlaveImpl;
import orq.iqu.slaveservices.others.LocationServiceSlave;
import orq.iqu.slaveservices.others.LocationServiceSlaveImpl;

/**
 * ServiceFactory - Class that provides the same instance of a class for all
 * threads.
 * 
 * @author Alex Dragomir
 *
 */
public class ServiceFactory {

	private static ServiceFactory instance = null;
	private static EventsServiceSlave eventsServiceInstance = null;
	private static NewsServiceSlave newsServiceInstance = null;
	private static HealthCheckServiceSlave healthCheckServiceInstance = null;
	private static LocationServiceSlave locationServiceInstance = null;
	private static ImageServiceSlave imageServiceInstance = null;

	private ServiceFactory() {

	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * ServiceFactory for all threads.
	 */
	public static synchronized ServiceFactory getInstance() {
		if (instance == null) {
			synchronized (ServiceFactory.class) {
				if (instance == null) {
					instance = new ServiceFactory();
				}
			}
		}
		return instance;

	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * EventsServiceSlave for all threads.
	 */
	public static synchronized EventsServiceSlave getEventsServiceInstance() {
		if (eventsServiceInstance == null) {
			synchronized (ServiceFactory.class) {
				if (eventsServiceInstance == null) {
					eventsServiceInstance = new EventsServiceSlaveImpl();
				}
			}
		}
		return eventsServiceInstance;
	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * NewsServiceSlave for all threads.
	 */
	public static synchronized NewsServiceSlave getNewsServiceInstance() {
		if (newsServiceInstance == null) {
			synchronized (ServiceFactory.class) {
				if (newsServiceInstance == null) {
					newsServiceInstance = new NewsServiceSlaveImpl();
				}
			}
		}
		return newsServiceInstance;
	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * HealthCheckServiceSlave for all threads.
	 */
	public static synchronized HealthCheckServiceSlave getOtherServiceInstance() {
		if (healthCheckServiceInstance == null) {
			synchronized (ServiceFactory.class) {
				if (healthCheckServiceInstance == null) {
					healthCheckServiceInstance = new HealthCheckServiceSlaveImpl();
				}
			}
		}
		return healthCheckServiceInstance;
	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * LocationServiceSlave for all threads.
	 */
	public static synchronized LocationServiceSlave getLocationServiceInstance() {
		if (locationServiceInstance == null) {
			synchronized (ServiceFactory.class) {
				if (locationServiceInstance == null) {
					locationServiceInstance = new LocationServiceSlaveImpl();
				}
			}
		}
		return locationServiceInstance;
	}

	/**
	 * This method is used to ensure the return of the same instance of
	 * ImageServiceSlave for all threads.
	 */
	public static synchronized ImageServiceSlave getimageServiceInstance() {
		if (imageServiceInstance == null) {
			synchronized (ServiceFactory.class) {
				if (imageServiceInstance == null) {
					imageServiceInstance = new ImageServiceSlaveImpl();
				}
			}
		}
		return imageServiceInstance;
	}
}
