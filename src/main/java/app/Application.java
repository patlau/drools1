package app;

import java.io.Closeable;
import java.io.IOException;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

import app.model.Game;

@Configuration
@ComponentScan(basePackages = { "org.kie.spring.annotations", "app" })
public class Application {

	final static Logger log = LoggerFactory.getLogger(Application.class);

	public static class Session implements Closeable {

		public Session(KieContainer kieContainer) {
			this.kieSession = kieContainer.newKieSession();
		}

		private KieSession kieSession;

		@Override
		public void close() throws IOException {
			if (kieSession != null)
				kieSession.dispose();
		}

		public void fireAllRules() {
			kieSession.fireAllRules();
		}

		public KieSession kie() {
			return kieSession;
		}

	}

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
			new Application(context.getBean(KieContainer.class)).run();
		}
	}

	KieContainer kieContainer;

	public Application(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public void run() {
		try (Session session = new Session(kieContainer)) {
			// kieSession.setGlobal("rideFare", rideFare);
			// kieSession.insert(taxiRide);
			session.kie().insert(new Game());
			session.fireAllRules();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}