package com.example.assignmentibm.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehicleListModel {

    private List<VehicleModel> vehicleModels;

    public List<VehicleModel> getVehicleModels() {
        return vehicleModels;
    }

    public void setVehicleModels(List<VehicleModel> vehicleModels) {
        this.vehicleModels = vehicleModels;
    }
}
