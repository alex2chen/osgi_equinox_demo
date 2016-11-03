package com.xfboy.osgi_equino_impl;

import com.xfboy.osgi_equinox.contract.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "hello,"+name;
	}

}
