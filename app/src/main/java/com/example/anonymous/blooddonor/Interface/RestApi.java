package com.example.anonymous.blooddonor.Interface;

import com.example.anonymous.blooddonor.Models.Donor;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by anonymous on 9/19/2017.
 */

public interface RestApi {
    @FormUrlEncoded

    @POST("")
    Call<Donor>insertDonor(@Field("phone") String phone,
                         @Field("name") String first_name,
                         @Field("name") String last_name,
                         @Field("email") String email
                         );


}
