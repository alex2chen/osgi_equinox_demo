package com.xfboy.osgi_equinox_di.annotation.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import com.xfboy.osgi_equinox_di.annotation.Service;
import com.xfboy.osgi_equinox_di.annotation.Servlet;

public class ServiceBundleListener implements BundleListener {

	@Override
	public void bundleChanged(BundleEvent event) {
		byte num1=0x01;
		int num2=3;
		byte sum=(byte) (num1+0x01);
		int type = event.getType();
		
		if (type == BundleEvent.STARTED) {
			try {
				registService(event.getBundle());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamespaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 注册服务
	 * 
	 * @param bundle
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NamespaceException 
	 * @throws ServletException 
	 */
	private void registService(Bundle bundle) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException, NamespaceException {
		System.out.println("regist service:" + bundle.toString());
		Set<String> result = new HashSet<>();
		findClasses(bundle, "bin/", result);
		Set<Class<?>> services = findServices(bundle, result,Service.class);
		Set<Class<?>> servlets= findServices(bundle, result,Servlet.class);
		buildService(bundle,services);
		buildServlet(bundle,servlets);
	}
	/**
	 * 构建Servlet服务
	 * @param bundle
	 * @param servlets
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NamespaceException 
	 * @throws ServletException 
	 */
	private void buildServlet(Bundle bundle, Set<Class<?>> servlets) throws InstantiationException, IllegalAccessException, ServletException, NamespaceException {
		HttpService httpService=getRef(bundle.getBundleContext(),HttpService.class);
		for(Class<?> clazz:servlets){
			Object newInstance=resolveReference(bundle,clazz);
			Class<?>[] interfaces=clazz.getInterfaces();
			Servlet annotation=clazz.getAnnotation(Servlet.class);
			httpService.registerServlet(annotation.value(), (javax.servlet.Servlet) newInstance, null,null);			
		}
		
	}

	/**
	 * 构建Service服务
	 * @param bundle
	 * @param services
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void buildService(Bundle bundle, Set<Class<?>> services) throws InstantiationException, IllegalAccessException {
		for(Class<?> clazz:services){
			Object newInstance=resolveReference(bundle,clazz);
			Class<?>[] interfaces=clazz.getInterfaces();
			for(Class<?> itfc:interfaces){
				bundle.getBundleContext().registerService(itfc.getName(), newInstance, null);
			}
			
		}
		
	}

	/**
	 * 获取所以注解的类
	 * 
	 * @param bundle
	 * @param result
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private Set<Class<?>> findServices(Bundle bundle, Set<String> classes,Class<? extends Annotation> an)
			throws ClassNotFoundException{
		Set<Class<?>> result = new HashSet<>();
		for (String clsName : classes) {
			Class<?> clazz = bundle.loadClass(clsName);			
			if (clazz.getAnnotation(an) != null) {
				result.add(clazz);
			}
		}

		return result;
	}
	/**
	 * 解决service的引用
	 * @param bundle
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private Object resolveReference(Bundle bundle, Class<?> clazz) throws InstantiationException, IllegalAccessException {
		Object newInstance=clazz.newInstance();
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields){
			if(field.getAnnotation(Service.class)!=null){
				field.setAccessible(true);
				field.set(newInstance, getRef(bundle.getBundleContext(),field.getType()));
			}
		}
		return newInstance;
	}
	/**
	 * 获取引用的服务
	 * @param context
	 * @param clazz
	 * @return
	 */
	private <T> T getRef(BundleContext context,Class<T> clazz){
		return context.getService(context.getServiceReference(clazz));
	}

	/**
	 * 获取所有的类名
	 * 
	 * @param bundle
	 * @param root
	 * @param result
	 */
	private void findClasses(Bundle bundle, String root, Set<String> result) {
		// 获取项目根目录
		Enumeration<String> entryPaths = bundle.getEntryPaths(root);
		if(entryPaths==null){
			return;
		}
		while (entryPaths.hasMoreElements()) {
			String path = (String) entryPaths.nextElement();
			if (path.endsWith(".class")) {
				String tmp = path.replace("bin/", "").replaceAll("/", ".");
				tmp = tmp.substring(0, tmp.length() - 6);
				result.add(tmp);
			} else if (path.endsWith("/")) {
				findClasses(bundle, path, result);
			}
		}
	}

}
