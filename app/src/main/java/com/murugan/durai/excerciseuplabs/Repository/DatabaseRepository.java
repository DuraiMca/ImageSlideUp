package com.murugan.durai.excerciseuplabs.Repository;

import com.murugan.durai.excerciseuplabs.Interface.DataAccess;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class DatabaseRepository {
  DataAccess dataAccess;
    final String url="https://api.github.com/";
    Retrofit retrofit=null;

    public Retrofit getRetrofit() {

        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
