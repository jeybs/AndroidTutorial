package com.jb.androidtutorial.data.source.remote;


import android.app.ProgressDialog;
import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.jb.androidtutorial.CommonConstants;
import com.jb.androidtutorial.data.source.LicenseListService;
import com.jb.androidtutorial.data.source.remote.licenselist.LicenseResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LicenseDataHelper {

    private static final String TAG = LicenseDataHelper.class.getSimpleName();

    private Context mContext;
    private LicenseListService licenseListService;
    private ProgressDialog progressDialog;
    private Gson gson;


    public LicenseDataHelper(Context context) {
        this.mContext = context;

        gson = new Gson();

        initializeDialog(context);
    }

    public void getLicenseKey() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CommonConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        licenseListService = retrofit.create(LicenseListService.class);

        String header = getHeader();
        Call<LicenseResponse> call = licenseListService.getLicenseKey(header);

        progressDialog.show();
        call.enqueue(new Callback<LicenseResponse>() {
            @Override
            public void onResponse(Call<LicenseResponse> call, Response<LicenseResponse> response) {
                Log.d(TAG, gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<LicenseResponse> call, Throwable t) {

            }
        });
    }

    /**
     * Get authorization header
     * @return
     */
    private String getHeader() {
        String credentials = "user:password";
        try {
            credentials = "Basic " + Base64.encodeToString(credentials.getBytes("UTF-8"), Base64.DEFAULT).trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return credentials;
    }

    /**
     * Initialize progress dialog
     * @param context
     */
    private void initializeDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
    }
}
