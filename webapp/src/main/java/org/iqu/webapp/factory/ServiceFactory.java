package org.iqu.webapp.factory;

import orq.iqu.slaveservices.events.EventsService;
import orq.iqu.slaveservices.events.EventsServiceImpl;
import orq.iqu.slaveservices.news.NewsService;
import orq.iqu.slaveservices.news.NewsServiceImpl;
import orq.iqu.slaveservices.others.OtherService;
import orq.iqu.slaveservices.others.OtherServiceImpl;
import orq.iqu.slaveservices.others.RetrieveImageServiceSlave;
import orq.iqu.slaveservices.others.RetrieveImageServiceImpl;
import orq.iqu.slaveservices.others.RetrieveLocationService;
import orq.iqu.slaveservices.others.RetrieveLocationServiceImpl;

public class ServiceFactory {

	private static ServiceFactory instance = null;
	private static EventsService eventsServiceInstance = null;
	private static NewsService newsServiceInstance = null;
	private static OtherService healthCheckServiceInstance = null;
	private static RetrieveLocationService locationServiceInstance = null;
	private static RetrieveImageServiceSlave imageServiceInstance = null;

	private ServiceFactory() {

	}

	public static ServiceFactory getInstance() {
		if (instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}

	public static EventsService getEventsServiceInstance() {
		if (eventsServiceInstance == null) {
			eventsServiceInstance = new EventsServiceImpl();
		}
		return eventsServiceInstance;
	}

	public static NewsService getNewsServiceInstance() {
		if (newsServiceInstance == null) {
			newsServiceInstance = new NewsServiceImpl();
		}
		return newsServiceInstance;
	}

	public static OtherService getOtherServiceInstance() {
		if (healthCheckServiceInstance == null) {
			healthCheckServiceInstance = new OtherServiceImpl();
		}
		return healthCheckServiceInstance;
	}

	public static RetrieveLocationService getLocationServiceInstance() {
		if (locationServiceInstance == null) {
			locationServiceInstance = new RetrieveLocationServiceImpl();
		}
		return locationServiceInstance;
	}

	public static RetrieveImageServiceSlave getimageServiceInstance() {
		if (imageServiceInstance == null) {
			imageServiceInstance = new RetrieveImageServiceImpl();
		}
		return imageServiceInstance;
	}
}
