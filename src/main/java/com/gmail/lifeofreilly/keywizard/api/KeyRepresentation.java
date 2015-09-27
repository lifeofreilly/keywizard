package com.gmail.lifeofreilly.keywizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * A representation of a bitcoin address and associated information.
 * Representation classes describe the entities in the application’s API.
 */
public class KeyRepresentation {
    private final String address;
    private final BigInteger privKey;
    private final String hexKey;
    private final String wifKey;
    private final String info;

    /**
     * The sole constructor for a KeyRepresentation object
     *
     * @param address the bitcoin address
     * @param privKey the private key for the associated address
     * @param hexKey the private key in HEX format for the associated address
     * @param wifKey the private key in WIF (Wallet Import Format) for the associated address
     * @param info a url that provides more information for the associated address
     */
    public KeyRepresentation(String address, BigInteger privKey,
                             String hexKey, String wifKey, String info) {
        this.address = address;
        this.privKey = privKey;
        this.hexKey = hexKey;
        this.wifKey = wifKey;
        this.info = info;
    }

    /**
     * Gets the bitcoin address
     *
     * @return bitcoin address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * Gets the private key for the associated address
     *
     * @return private key
     */
    @JsonProperty("privateKey")
    public String getPrivKey() {
        return privKey.toString();
    }

    /**
     * Gets the private key in hex format for the associated address
     *
     * @return private key as hex
     */
    @JsonProperty("privateKeyAsHex")
    public String getHexKey() {
        return hexKey;
    }

    /**
     * Gets the private key in WIF (Wallet Import Format) for the associated address
     *
     * @return private key in WIF
     */
    @JsonProperty("privateKeyAsWIF")
    public String getWifKey() {
        return wifKey;
    }

    /**
     * Gets a url that provides more information for the associated address
     *
     * @return url
     */
    @JsonProperty("info")
    public String getAddressInfo() {
        return info;
    }

}
