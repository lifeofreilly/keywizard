package com.gmail.lifeofreilly.keywizard;

import com.gmail.lifeofreilly.keywizard.health.KeyWizardHealthCheck;
import com.gmail.lifeofreilly.keywizard.resources.KeyWizardViewResource;
import com.gmail.lifeofreilly.keywizard.resources.KeyWizardResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 * The main entry point into the KeyWizard Dropwizard application.
 */
public class KeyWizardApplication extends Application<KeyWizardConfiguration> {

    /**
     * The main entry point
     *
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        new KeyWizardApplication().run(args);
    }

    /**
     * Gets the name of the application
     *
     * @return the name
     */
    @Override
    public String getName() {
        return "keywizard";
    }

    /**
     * The initialize method is called before running the service run method
     *
     * @param bootstrap the configuration information
     */
    @Override
    public void initialize(final Bootstrap<KeyWizardConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<KeyWizardConfiguration>());
    }

    /**
     * Called when the service runs and registers the desired resources
     *
     * @param configuration the configuration
     * @param environment the environment
     */
    @Override
    public void run(KeyWizardConfiguration configuration, Environment environment) {
        environment.jersey().register(new KeyWizardResource(configuration.getBaseURL()));
        environment.jersey().register(new KeyWizardViewResource(configuration.getBaseURL()));
        environment.healthChecks().register("resource", new KeyWizardHealthCheck());
    }

}
