package com.example.assignmentibm.network;

import com.example.assignmentibm.model.VehicleModel;

import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @GET("vehicle/random_vehicle")
    Single<List<VehicleModel>> getVehicles(@Query("size") String size);
}
