package com.xfboy.osgi_equinox_client;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.xfboy.osgi_equinox.contract.HelloService;

public class HelloServiceRef implements CommandProvider {

	private HelloService helloService;

	/**
	 * 通过compent卸载
	 * 
	 * @param obj
	 */
	public synchronized void unsetHelloService(HelloService obj) {
		if (this.helloService == obj) {
			this.helloService = null;
		}
	}

	/**
	 * 通过compent注入
	 * 
	 * @param obj
	 */
	public synchronized void setHelloService(HelloService obj) {
		this.helloService = obj;
	}
	/*
	 * 方法必须以_开头，参数也是固定写法
	 * 
	 * 命令行：say alex
	 */
	public void _say(CommandInterpreter ci){
		String result=helloService.sayHello(ci.nextArgument());
		System.out.print(result);
		
	}
	/**
	 * 显示帮助
	 * 命令行：help say
	 */
	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return "say <name>";
	}

}
