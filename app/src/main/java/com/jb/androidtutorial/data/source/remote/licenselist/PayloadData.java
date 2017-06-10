package com.jb.androidtutorial.data.source.remote.licenselist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by b on 6/10/17.
 */

public class PayloadData {

    int count;

    @SerializedName("list")
    List<LicenseList> licenseList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<LicenseList> getLicenseList() {
        return licenseList;
    }

    public void setLicenseList(List<LicenseList> licenseList) {
        this.licenseList = licenseList;
    }
}
