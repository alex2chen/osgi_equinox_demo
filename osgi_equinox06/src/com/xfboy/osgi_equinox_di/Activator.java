package com.xfboy.osgi_equinox_di;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.xfboy.osgi_equinox_di.annotation.handler.ServiceBundleListener;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("osgi_equinox06 start");
		context.addBundleListener(new ServiceBundleListener());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("osgi_equinox06 start");
	}

}
