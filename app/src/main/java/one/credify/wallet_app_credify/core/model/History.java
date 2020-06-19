package one.credify.wallet_app_credify.core.model;

import com.google.gson.annotations.SerializedName;

public class History {
    @SerializedName("address")
    private String address;
    @SerializedName("dateTime")
    private String dateTime;
    @SerializedName("coinAmount")
    private String coinAmount;
    @SerializedName("status")
    private Status status;

    public History(String address, String dateTime, String coinAmount, Status status) {
        this.address = address;
        this.dateTime = dateTime;
        this.coinAmount = coinAmount;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getCoinAmount() {
        return coinAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setCoinAmount(String coinAmount) {
        this.coinAmount = coinAmount;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static enum Status {
        @SerializedName("0")
        TRANSFER,
        @SerializedName("1")
        RECEIVE,
    }
}
