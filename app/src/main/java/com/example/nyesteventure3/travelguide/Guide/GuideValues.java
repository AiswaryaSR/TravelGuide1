
package com.example.nyesteventure3.travelguide.Guide;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuideValues {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("guide_name")
    @Expose
    private String guideName;
    @SerializedName("guide_age")
    @Expose
    private String guideAge;
    @SerializedName("guide_gender")
    @Expose
    private String guideGender;
    @SerializedName("guide_lic")
    @Expose
    private String guideLic;
    @SerializedName("guide_address")
    @Expose
    private String guideAddress;
    @SerializedName("guide_ph")
    @Expose
    private String guidePh;
    @SerializedName("guide_email")
    @Expose
    private String guideEmail;
    @SerializedName("guide_loc")
    @Expose
    private String guideLoc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGuideAge() {
        return guideAge;
    }

    public void setGuideAge(String guideAge) {
        this.guideAge = guideAge;
    }

    public String getGuideGender() {
        return guideGender;
    }

    public void setGuideGender(String guideGender) {
        this.guideGender = guideGender;
    }

    public String getGuideLic() {
        return guideLic;
    }

    public void setGuideLic(String guideLic) {
        this.guideLic = guideLic;
    }

    public String getGuideAddress() {
        return guideAddress;
    }

    public void setGuideAddress(String guideAddress) {
        this.guideAddress = guideAddress;
    }

    public String getGuidePh() {
        return guidePh;
    }

    public void setGuidePh(String guidePh) {
        this.guidePh = guidePh;
    }

    public String getGuideEmail() {
        return guideEmail;
    }

    public void setGuideEmail(String guideEmail) {
        this.guideEmail = guideEmail;
    }

    public String getGuideLoc() {
        return guideLoc;
    }

    public void setGuideLoc(String guideLoc) {
        this.guideLoc = guideLoc;
    }

}
