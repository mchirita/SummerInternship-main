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

  private static volatile ServiceFactory instance = null;
  private static volatile EventsServiceSlave eventsServiceInstance = null;
  private static volatile NewsServiceSlave newsServiceInstance = null;
  private static volatile HealthCheckServiceSlave healthCheckServiceInstance = null;
  private static volatile LocationServiceSlave locationServiceInstance = null;
  private static volatile ImageServiceSlave imageServiceInstance = null;

  private ServiceFactory() {

  }

  /**
   * This method is used to ensure the return of the same instance of
   * ServiceFactory for all threads.
   */
  public static ServiceFactory getInstance() {
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
  public static EventsServiceSlave getEventsServiceInstance() {
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
  public static NewsServiceSlave getNewsServiceInstance() {
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
  public static HealthCheckServiceSlave getOtherServiceInstance() {
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
  public static LocationServiceSlave getLocationServiceInstance() {
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
  public static ImageServiceSlave getimageServiceInstance() {
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
