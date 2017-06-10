package com.jb.androidtutorial.data.source;


import com.jb.androidtutorial.CommonConstants;
import com.jb.androidtutorial.data.source.remote.licenselist.LicenseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface LicenseListService {

    @GET(CommonConstants.API_LICENSE_LIST)
    Call<LicenseResponse> getLicenseKey(@Header("Authorization") String auth);

}
