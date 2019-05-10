
package com.example.nyesteventure3.travelguide.Login1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example123 {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("data")
    @Expose
    private Boolean data;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
