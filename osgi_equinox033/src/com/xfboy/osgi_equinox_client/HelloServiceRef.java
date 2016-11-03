package com.xfboy.osgi_equinox_client;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.xfboy.osgi_equinox.contract.HelloService;

public class HelloServiceRef implements CommandProvider {

	private HelloService helloService;

	/**
	 * ͨ��compentж��
	 * 
	 * @param obj
	 */
	public synchronized void unsetHelloService(HelloService obj) {
		if (this.helloService == obj) {
			this.helloService = null;
		}
	}

	/**
	 * ͨ��compentע��
	 * 
	 * @param obj
	 */
	public synchronized void setHelloService(HelloService obj) {
		this.helloService = obj;
	}
	/*
	 * ����������_��ͷ������Ҳ�ǹ̶�д��
	 * 
	 * �����У�say alex
	 */
	public void _say(CommandInterpreter ci){
		String result=helloService.sayHello(ci.nextArgument());
		System.out.print(result);
		
	}
	/**
	 * ��ʾ����
	 * �����У�help say
	 */
	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		return "say <name>";
	}

}
