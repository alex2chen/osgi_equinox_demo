package com.xfboy.osgi_equinox_web.tracker;

import javax.servlet.ServletException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import com.xfboy.osgi_equinox_web.servlet.HelloServlet;

public class MyServicetracker implements ServiceTrackerCustomizer{
	private BundleContext context;
	private HttpService httpService;
	private String url="/web/hello";
	public MyServicetracker(BundleContext context){
		this.context=context;
	}
	public MyServicetracker(BundleContext context,String url){
		this.context=context;
		this.url=url;
	}
	/**
	 * 
	 * @return
	 */
	public ServiceTracker getServiceTracker(){
		return new ServiceTracker(this.context,HttpService.class.getName(),this);
	}
	
	@Override
	public Object addingService(ServiceReference arg0) {
		Object service = context.getService(arg0);  
		this.httpService = (HttpService) service; 
		try {  
        	//设置服务的属性
//        	Dictionary<String, String> props = new Hashtable<String, String>();
//        	props.put("org.osgi.service.http.port", "8081");
            this.httpService.registerServlet(this.url,new HelloServlet(),null,null);  
        } catch (ServletException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
		} catch (NamespaceException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return service;
	}
	@Override
	public void modifiedService(ServiceReference arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removedService(ServiceReference arg0, Object arg1) {
		 if(arg1 != this.httpService){  
             return;  
         }  
         this.httpService.unregister(this.url);  
         this.httpService = null;  
		
	}
}
