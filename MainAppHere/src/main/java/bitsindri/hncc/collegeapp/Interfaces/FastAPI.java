package bitsindri.hncc.collegeapp.Interfaces;

import java.util.List;

import bitsindri.hncc.collegeapp.GetterAndSetter.internshipsAndJobs;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FastAPI {
    @GET("internship")
    Call<List<internshipsAndJobs>> getResponse();
}
