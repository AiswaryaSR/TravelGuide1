
package com.example.nyesteventure3.travelguide.Fare;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareDetails1 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("auto_fare")
    @Expose
    private String autoFare;
    @SerializedName("car_fare")
    @Expose
    private String carFare;
    @SerializedName("bus_fare")
    @Expose
    private String busFare;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("time_duration")
    @Expose
    private String timeDuration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAutoFare() {
        return autoFare;
    }

    public void setAutoFare(String autoFare) {
        this.autoFare = autoFare;
    }

    public String getCarFare() {
        return carFare;
    }

    public void setCarFare(String carFare) {
        this.carFare = carFare;
    }

    public String getBusFare() {
        return busFare;
    }

    public void setBusFare(String busFare) {
        this.busFare = busFare;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

}
