package bitsindri.hncc.collegeapp.Interfaces;

import java.util.List;

import bitsindri.hncc.collegeapp.Custom_Classes.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/2X8BvW4")
    Call<List<Data>> getInfo();
}

