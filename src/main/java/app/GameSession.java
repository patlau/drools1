package app;

import java.io.IOException;

import org.kie.api.runtime.KieContainer;

import app.model.Game;

public class GameSession {
	
	KieContainer kieContainer;

	public GameSession(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public void run() {
		try (DroolsSession session = new DroolsSession(kieContainer)) {
			session.kie().insert(new Game());
			session.fireAllRules();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
