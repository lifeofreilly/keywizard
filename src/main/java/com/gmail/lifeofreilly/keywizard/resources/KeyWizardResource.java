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

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class KeyWizardResource {
    private static final NetworkParameters NET_PARAMS = MainNetParams.get();
    private final String baseURL;

    public KeyWizardResource(String baseURL) {
        this.baseURL = baseURL;
    }

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
