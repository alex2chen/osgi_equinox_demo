以声明的方式提供服务
根目录添加folder:OSGI-INF
	再在文件夹中添加Component Definition
	再添加服务提供
	
require bundles:
org.eclipse.equinox.util
org.eclipse.equinox.ds
org.eclipse.osgi.service

run config:
org.eclipse.osgi.services_3.5.100.v20160504-1419
org.eclipse.equinox.ds_1.4.500.v20160906-1436
org.eclipse.equinox.util_1.0.500.v20130404-1337

查找是否注册：services *HelloService
