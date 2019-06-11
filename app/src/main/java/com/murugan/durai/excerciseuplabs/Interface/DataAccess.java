package com.murugan.durai.excerciseuplabs.Interface;

import com.murugan.durai.excerciseuplabs.Model.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataAccess {

    @GET("users")
    Call<List<ModelClass>> getdata();
}
