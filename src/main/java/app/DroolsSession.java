package app;

import java.io.Closeable;
import java.io.IOException;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsSession implements Closeable {

	public DroolsSession(KieContainer kieContainer) {
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