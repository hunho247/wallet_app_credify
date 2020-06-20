package one.credify.wallet_app_credify.core.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coin implements Serializable {
    @SerializedName("coinId")
    private String coinId;
    @SerializedName("coinUnit")
    private String coinUnit;
    @SerializedName("coinAmount")
    private Double coinAmount;
    @SerializedName("publicKey")
    private String publicKey;
    @SerializedName("keyAES")
    private String keyAES; // use AES Encryption to encrypt/decrypt the private key saved in local device

    public Coin(String coinId, String coinUnit, Double coinAmount, String publicKey, String keyAES) {
        this.coinId = coinId;
        this.coinUnit = coinUnit;
        this.coinAmount = coinAmount;
        this.publicKey = publicKey;
        this.keyAES = keyAES;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public void setCoinUnit(String coinUnit) {
        this.coinUnit = coinUnit;
    }

    public void setCoinAmount(Double coinAmount) {
        this.coinAmount = coinAmount;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setKeyAES(String keyAES) {
        this.keyAES = keyAES;
    }

    public String getCoinId() {
        return coinId;
    }

    public String getCoinUnit() {
        return coinUnit;
    }

    public Double getCoinAmount() {
        return coinAmount;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getKeyAES() {
        return keyAES;
    }
}
