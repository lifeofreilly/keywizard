package com.gmail.lifeofreilly.keywizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.gmail.lifeofreilly.keywizard.api.KeyRepresentation;
import com.gmail.lifeofreilly.keywizard.views.KeyWizardView;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class KeyWizardViewResource {
    private static final NetworkParameters NET_PARAMS = MainNetParams.get();
    private final String baseURL;

    public KeyWizardViewResource(String baseURL) {
        this.baseURL = baseURL;
    }

    @GET
    @Timed
    public KeyWizardView getKeyWizard() {
        final ECKey key = new ECKey();
        final String address = key.toAddress(NET_PARAMS).toString();

        return new KeyWizardView(new KeyRepresentation(address,
                key.getPrivKey(),
                key.getPrivateKeyAsHex(),
                key.getPrivateKeyAsWiF(NET_PARAMS),
                baseURL + address));
    }

}

