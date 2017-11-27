package app.vaadin;

import com.vaadin.router.Route;
import com.vaadin.ui.html.Div;

@Route("")
public class HelloComponent extends Div {
	public HelloComponent() {
		setText("Hello world!");
	}
}
