演示使用服务追踪器来实现一个简单的servlet
添加required plug-ins
javax.servlet

Import packages:
org.osgi.service.http
org.osgi.util.tracker

run config:
org.eclipse.osgi_3.10.101.v20150820-1432
org.eclipse.osgi.services_3.5.0.v20150519-2006
org.apache.felix.gogo.runtime_0.10.0.v201209301036
org.apache.felix.gogo.command_0.10.0.v201209301215
org.apache.felix.gogo.shell_0.10.0.v201212101605
org.eclipse.equinox.console_1.1.100.v20141023-1406
javax.el_2.2.0.v201303151357
javax.servlet_3.1.0.v201410161800
javax.servlet.jsp_2.2.0.v201112011158
org.eclipse.equinox.http.servlet_1.2.1.v20150828-1818
org.eclipse.equinox.http.jetty_3.1.1.v20150818-2108
org.eclipse.jetty.http_9.2.13.v20150730
org.eclipse.jetty.util_9.2.13.v20150730
org.eclipse.jetty.server_9.2.13.v20150730
org.eclipse.jetty.io_9.2.13.v20150730
org.eclipse.jetty.servlet_9.2.13.v20150730
org.eclipse.jetty.security_9.2.13.v20150730
dictQueryWeb_1.0.0.qualifier

点击Validate bundle再添加


或者启动参数添加：-Dorg.osgi.service.http.port=88
