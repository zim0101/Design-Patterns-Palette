package org.asif;

import org.asif.app.Application;
import org.asif.factories.GUIFactory;
import org.asif.factories.LinuxFactory;
import org.asif.factories.MacOSFactory;
import org.asif.factories.WindowsFactory;

public final class Main {
    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */

    private Main() {
        throw new UnsupportedOperationException("Main class cannot be instantiated");
    }

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else if (osName.contains("linux")) {
            factory = new LinuxFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
