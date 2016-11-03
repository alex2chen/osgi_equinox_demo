package com.xfboy.osgi_equinox_di.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfboy.osgi_equinox_di.annotation.Service;
import com.xfboy.osgi_equinox_di.annotation.Servlet;
import com.xfboy.osgi_equinox_di.service.HelloService;

@Servlet("/hello")
public class HelloServlet extends HttpServlet {
	
	@Service
	private HelloService helloService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter output = resp.getWriter();
		output.write(helloService.sayHello("alex"));		
		output.flush();
		output.close();
		
	}
}
