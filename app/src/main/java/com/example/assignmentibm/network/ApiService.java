package com.example.assignmentibm.network;

import com.example.assignmentibm.model.VehicleListModel;
import com.example.assignmentibm.model.VehicleModel;

import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {


    @GET("vehicle/random_vehicle")
    Single<List<VehicleModel>> getVehicles(@Query("size") String size);
    /*@FormUrlEncoded
    @POST("change_password.php")
    Single<ChangePassReponse> changePassword(@FieldMap HashMap<String, String> hashMap);*/
}
