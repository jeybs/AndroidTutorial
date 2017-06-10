package com.jb.androidtutorial.data.source;

import com.jb.androidtutorial.CommonConstants;
import com.jb.androidtutorial.data.source.remote.login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by b on 6/10/17.
 */

public interface LoginService {

    @FormUrlEncoded
    @POST(CommonConstants.API_LOGIN)
    Call<LoginResponse> login(@Header("Authorization") String auth,
                              @Field("basicToken") String token,
                              @Path("entityId") String entityId,
                              @Query("_dc") String dc);


}
