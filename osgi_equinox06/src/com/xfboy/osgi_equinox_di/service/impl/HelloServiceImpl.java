package com.xfboy.osgi_equinox_di.service.impl;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogService;

import com.xfboy.osgi_equinox_di.annotation.Service;
import com.xfboy.osgi_equinox_di.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
	@Service
	private LogService logService;
	@Service
	private LogReaderService logReaderService;
	
	@Override
	public String sayHello(String name) {
		logReaderService.addLogListener(new LogListener() {
			
			@Override
			public void logged(LogEntry logEry) {
				System.out.println(logEry.getMessage());
				
			}
		});
		//注册logReder才可以使用
		logService.log(LogService.LOG_DEBUG, "test logService");
		
		return "hello," + name;
	}

	@Override
	public String sayBye(String name) {
		return "bye" + name;
	}

}
