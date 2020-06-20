package one.credify.wallet_app_credify.core.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coin implements Serializable {
    @SerializedName("coinName")
    private String coinName;
    @SerializedName("coinAmount")
    private String coinAmount;
    @SerializedName("coinPrice")
    private String coinPrice;
    @SerializedName("publicKey")
    private String publicKey;
    @SerializedName("keyAES")
    private String keyAES; // use AES Encryption to encrypt/decrypt the private key saved in local device

    public Coin(String coinName, String coinAmount, String coinPrice, String publicKey, String keyAES) {
        this.coinName = coinName;
        this.coinAmount = coinAmount;
        this.coinPrice = coinPrice;
        this.publicKey = publicKey;
        this.keyAES = keyAES;
    }

    public String getCoinName() {
        return coinName;
    }

    public String getCoinAmount() {
        return coinAmount;
    }

    public String getCoinPrice() {
        return coinPrice;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getKeyAES() {
        return keyAES;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setCoinAmount(String coinAmount) {
        this.coinAmount = coinAmount;
    }

    public void setCoinPrice(String coinPrice) {
        this.coinPrice = coinPrice;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setKeyAES(String keyAES) {
        this.keyAES = keyAES;
    }
}
