package com.jb.androidtutorial.data.source.remote.licenselist;

import com.google.gson.annotations.SerializedName;

/**
 * Created by b on 6/10/17.
 */

public class LicenseResponse {

    String message;

    @SerializedName("payload")
    PayloadData payloadData;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PayloadData getPayloadData() {
        return payloadData;
    }

    public void setPayloadData(PayloadData payloadData) {
        this.payloadData = payloadData;
    }
}
