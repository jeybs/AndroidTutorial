package com.jb.androidtutorial.data.source.remote.login;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.jb.androidtutorial.data.source.LoginService;

import java.io.UnsupportedEncodingException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by b on 6/10/17.
 */

public class LoginHelper {

    private static final String TAG = LoginHelper.class.getSimpleName();

    private Context mContext;
    private LoginService loginService;
    private Gson gson;

    public LoginHelper(Context context) {
        this.mContext = context;
        gson = new Gson();
    }

    public void login() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://139.162.37.238:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String authentication = getHeader();
        String header = "Basic " + authentication;
        String time = Long.toString(System.currentTimeMillis());

        loginService = retrofit.create(LoginService.class);

        Call<LoginResponse> call = loginService.login(header, authentication, "10", time);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d(TAG, gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    /**
     * Get authorization header
     * @return
     */
    private String getHeader() {
        String credentials = "demo:1234jb";
        try {
            credentials = Base64.encodeToString(credentials.getBytes("UTF-8"), Base64.DEFAULT).trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return credentials;
    }
}
