package bitsindri.hncc.collegeapp.Interfaces;

import java.util.List;

import bitsindri.hncc.collegeapp.Custom_Classes.Data;
import bitsindri.hncc.collegeapp.Custom_Classes.DataList;
import bitsindri.hncc.collegeapp.Custom_Classes.DataList_feed;
import bitsindri.hncc.collegeapp.Custom_Classes.DataList_marketplace;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

//    @GET("/pdf")
//    Call<List<Data>> getInfo();
@GET("/study_resource")
Call<DataList> getInfo();

    @GET("/users-feed")
    Call<DataList_feed> getPost();

    @GET("/market-store")
    Call<DataList_marketplace> getItems();
}

