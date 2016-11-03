package com.xfboy.osgi_equinox_web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter output = null;
		try {
			output = resp.getWriter();
			String name = req.getParameter("name");
			
			output.println("hello,");
			output.println(name);
			
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}

	}

}
