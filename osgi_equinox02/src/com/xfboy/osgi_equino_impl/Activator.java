package com.xfboy.osgi_equino_impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.xfboy.osgi_equinox.contract.HelloService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration sr;
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("osgi-equinox02 start");		
		sr=context.registerService(HelloService.class, new HelloServiceImpl(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("osgi-equinox02 start");
		sr.unregister();
	}

}
