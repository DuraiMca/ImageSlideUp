package com.murugan.durai.excerciseuplabs.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.murugan.durai.excerciseuplabs.Adapter.MyAdapter;
import com.murugan.durai.excerciseuplabs.Interface.DataAccess;
import com.murugan.durai.excerciseuplabs.Model.ModelClass;
import com.murugan.durai.excerciseuplabs.R;
import com.murugan.durai.excerciseuplabs.Repository.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;


public class FirstFragment extends Fragment {
List<ModelClass> list=new ArrayList<>();
MyAdapter myAdapter;
RecyclerView recyclerView;
    DataAccess dataAccess;
DatabaseRepository repository=new DatabaseRepository();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar1);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);


        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dataAccess=repository.getRetrofit().create(DataAccess.class);
        Call<List<ModelClass>> call=dataAccess.getdata();
        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {

                for (int i = 0; i < response.body().size(); i++) {
                 //   Log.i(TAG, "onResponse: " + response.body().get(i).getId());
                    Log.i(TAG, "onResponse: " + response.body().get(i).getAvatarUrl());
                    ModelClass modelClass=new ModelClass();
                    modelClass.setAvatarUrl(response.body().get(i).getAvatarUrl());
                    modelClass.setLogin(response.body().get(i).getLogin());
                    list.add(modelClass);


                }
                myAdapter=new MyAdapter(list,getContext());
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

            }
        });

        return view;
    }

}
