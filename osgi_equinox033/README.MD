以声明式引用方式注入服务
根目录添加folder:OSGI-INF
	再在文件夹中添加Component Definition
	再添加服务引用，并绑定方法
	
查找引用情况：services *HelloService


为了演示效果添加控制台
import pacages:org.eclipse.osgi.framework.console

实现CommandProvider

声明服务CommandProvider出去

