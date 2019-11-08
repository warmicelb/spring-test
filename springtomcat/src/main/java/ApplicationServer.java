import com.ice.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * 这里手动启动一个tomcat服务器，并添加一个servlet来处理请求
 * @ClassName ApplicationServer
 * @Description TODO
 * @Author liubin
 * @Date 2019/11/8 3:10 PM
 **/
public class ApplicationServer {

    public static void main(String[] args) throws LifecycleException {
        //新建服务器
        Tomcat tomcat = new Tomcat();
        //设置端口
        tomcat.setPort(8080);
        //设置是否自动部署
        tomcat.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext standardContext = new StandardContext();
        //设置上下文路径
        standardContext.setPath("/ice");
        //设置上下文监听器
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        //tocmat添加context上下文对象
        tomcat.getHost().addChild(standardContext);
        //添加servlet
        tomcat.addServlet("/ice","indexServlet",new IndexServlet());
        //上下文添加路由规则
        standardContext.addServletMappingDecoded("/index","indexServlet");
        //启动服务器
        tomcat.start();
        System.out.println("tomcat started.....");
        //等待请求
        tomcat.getServer().await();
    }
}
