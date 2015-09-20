package com.gmail.lifeofreilly.keywizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class KeyRepresentation {
    private final String address;
    private final BigInteger privKey;
    private final String hexKey;
    private final String wifKey;
    private final String info;

    public KeyRepresentation(String address, BigInteger privKey,
                             String hexKey, String wifKey, String info) {
        this.address = address;
        this.privKey = privKey;
        this.hexKey = hexKey;
        this.wifKey = wifKey;
        this.info = info;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("privateKey")
    public String getPrivKey() {
        return privKey.toString();
    }

    @JsonProperty("privateKeyAsHex")
    public String getHexKey() {
        return hexKey;
    }

    @JsonProperty("privateKeyAsWIF")
    public String getWifKey() {
        return wifKey;
    }

    @JsonProperty("info")
    public String getAddressInfo() {
        return info;
    }

}
