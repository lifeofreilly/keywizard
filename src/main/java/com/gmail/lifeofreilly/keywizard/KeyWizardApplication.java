package com.gmail.lifeofreilly.keywizard;

import com.gmail.lifeofreilly.keywizard.health.KeyWizardHealthCheck;
import com.gmail.lifeofreilly.keywizard.resources.KeyWizardResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KeyWizardApplication extends Application<KeyWizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new KeyWizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "keywizard";
    }

    @Override
    public void initialize(final Bootstrap<KeyWizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(KeyWizardConfiguration configuration, Environment environment) {
        final KeyWizardResource resource = new KeyWizardResource(configuration.getBaseURL());
        environment.healthChecks().register("resource", new KeyWizardHealthCheck());
        environment.jersey().register(resource);
    }

}
