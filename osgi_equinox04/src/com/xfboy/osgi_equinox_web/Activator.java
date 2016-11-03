package com.xfboy.osgi_equinox_web;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

import com.xfboy.osgi_equinox_web.servlet.HelloServlet;
import com.xfboy.osgi_equinox_web.tracker.MyServicetracker;

public class Activator implements BundleActivator {

	
	private static BundleContext context;
//	private HttpService httpService;
	private ServiceTracker httpServiceTracker;
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
//		httpService=context.getService(context.getServiceReference(HttpService.class));		
//		httpService.registerServlet("/hello", new HelloServlet(), null, null);
		System.out.println("osgi_equinox04 start");
		MyServicetracker myServicetracker=new MyServicetracker(bundleContext);
		httpServiceTracker=myServicetracker.getServiceTracker();
		httpServiceTracker.open();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
//		httpService.unregister("/hello");
		Activator.context = null;
		System.out.println("osgi_equinox04 stop");
		httpServiceTracker.close();		
	}

}
