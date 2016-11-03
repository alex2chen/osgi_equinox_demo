04太传统了
另一种简单的方法：plugin.xml

require plugin:
添加org.eclipse.equinox.http.register

xml中维护拓展点(其实就是那个包的plugin.xml支持的拓展点)
其实是ResourceManager.class、ServletManager。class

http://localhost:8081/hello
http://localhost:8081/web/index.html

jsp呢？

requre plugin:
javax.servlet.jsp
org.eclipse.equinox.jsp.jasper
org.eclipse.equinox.jsp.jasper.registry

添加拓展点，其实就是servlet

http://localhost:8081/jsp/index.jsp

run config:
org.eclipse.osgi_3.10.1.v20140909-1633
org.eclipse.osgi.services_3.4.0.v20140312-2051
org.apache.felix.gogo.command_0.10.0.v201209301215
org.apache.felix.gogo.runtime_0.10.0.v201209301036
org.apache.felix.gogo.shell_0.10.0.v201212101605
org.eclipse.equinox.console_1.1.0.v20140131-1639
org.eclipse.equinox.common_3.6.200.v20130402-1505
org.eclipse.equinox.registry_3.5.400.v20140428-1507
javax.servlet_3.0.0.v201112011016
javax.servlet.jsp_2.2.0.v201112011158
javax.el_2.2.0.v201303151357
org.eclipse.equinox.jsp.jasper.registry_1.0.300.v20130327-1442
org.eclipse.equinox.jsp.jasper_1.0.400.v20130327-1442
org.apache.jasper.glassfish_2.2.2.v201205150955
org.eclipse.equinox.http.servlet_1.1.500.v20140318-1755
org.eclipse.equinox.http.registry_1.1.300.v20130402-1529
org.eclipse.equinox.http.jetty_3.0.200.v20131021-1843
org.eclipse.jetty.server_8.1.14.v20131031
org.eclipse.jetty.continuation_8.1.14.v20131031
org.eclipse.jetty.security_8.1.14.v20131031
org.eclipse.jetty.io_8.1.14.v20131031
org.eclipse.jetty.servlet_8.1.14.v20131031
org.eclipse.jetty.http_8.1.14.v20131031
org.eclipse.jetty.util_8.1.14.v20131031
