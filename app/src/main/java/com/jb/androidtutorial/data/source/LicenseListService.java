package com.jb.androidtutorial.data.source;


import com.jb.androidtutorial.CommonConstants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface LicenseListService {

    @GET(CommonConstants.API_LICENSE_LIST)
    Call<ResponseBody> getLicenseKey(@Header("Authorization") String auth);

}
