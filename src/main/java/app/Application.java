package app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = { "org.kie.spring.annotations", "app", "app.vaadin" })
@SpringBootApplication
public class Application extends SpringBootServletInitializer  {

	final static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		
		//try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
		//	new Application(context.getBean(KieContainer.class)).run();
		//}
		
		new SpringApplication(Application.class).run(args);
		
	}

}