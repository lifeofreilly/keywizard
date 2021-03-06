package com.gmail.lifeofreilly.keywizard.resources;

import com.codahale.metrics.annotation.Timed;

import com.gmail.lifeofreilly.keywizard.api.KeyRepresentation;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Provides a resource which responds to GET requests and provides a json representation of a KeyRepresentation.
 * Resource classes model the resources exposed in the RESTful API.
 */
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class KeyWizardResource {
    private static final NetworkParameters NET_PARAMS = MainNetParams.get();
    private final String baseURL;

    /**
     * The sole constructor for a KeyWizardViewResource object
     *
     * @param baseURL the base url for additional address information
     */
    public KeyWizardResource(String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * Generates a new KeyRepresentation when a GET request is made
     *
     * @return the KeyRepresentation
     */
    @GET
    @Timed
    public KeyRepresentation generateKey() {
        final ECKey key = new ECKey();
        final String address = key.toAddress(NET_PARAMS).toString();

        return new KeyRepresentation(address,
                key.getPrivKey(),
                key.getPrivateKeyAsHex(),
                key.getPrivateKeyAsWiF(NET_PARAMS),
                baseURL + address);
    }

}
