package com.gmail.lifeofreilly.keywizard.health;

import com.codahale.metrics.health.HealthCheck;
import com.gmail.lifeofreilly.keywizard.api.KeyRepresentation;
import com.gmail.lifeofreilly.keywizard.resources.KeyWizardResource;

/**
 * Verifies that a valid bitcoin addresses is generated.
 * Health checks give you a way of adding small tests to your application.
 * Health checks can be accessed at http://[host]:[adminport]/healthcheck
 */
public class KeyWizardHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        KeyWizardResource resource = new KeyWizardResource("https://blockchain.info/address/");
        KeyRepresentation representation = resource.generateKey();

        if (representation.getAddress().matches("^[a-km-zA-HJ-NP-Z1-9]{26,35}")) {
            return Result.healthy("A valid bitcoin address was generated: "
                    + representation.getAddress());
        } else {
            return Result.unhealthy("An invalid bitcoin address generated: "
                    + representation.getAddress());
        }

    }
}
