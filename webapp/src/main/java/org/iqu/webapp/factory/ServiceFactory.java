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

public class ServiceFactory {

	private static ServiceFactory instance = null;
	private static EventsServiceSlave eventsServiceInstance = null;
	private static NewsServiceSlave newsServiceInstance = null;
	private static HealthCheckServiceSlave healthCheckServiceInstance = null;
	private static LocationServiceSlave locationServiceInstance = null;
	private static ImageServiceSlave imageServiceInstance = null;

	private ServiceFactory() {

	}

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
