package com.xfboy.osgi_equinox_client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.xfboy.osgi_equinox.contract.HelloService;

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
//		System.out.println("osgi-equinox03 start");
		ServiceReference<HelloService> serviceRef = context
				.getServiceReference(HelloService.class);
		if (null != serviceRef) {
			HelloService helloService = context.getService(serviceRef);
			System.out.println(helloService.sayHello("osgi-equinox03."));
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("osgi-equinox03 start");
	}

}
