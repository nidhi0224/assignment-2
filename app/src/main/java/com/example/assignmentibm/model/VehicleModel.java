package com.example.assignmentibm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Comparator;

public class VehicleModel implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("vin")
    @Expose
    private String vin;
    @SerializedName("make_and_model")
    @Expose
    private String makeAndModel;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("drive_type")
    @Expose
    private String driveType;
    @SerializedName("fuel_type")
    @Expose
    private String fuelType;
    @SerializedName("car_type")
    @Expose
    private String carType;
    @SerializedName("doors")
    @Expose
    private Integer doors;
    @SerializedName("mileage")
    @Expose
    private Integer mileage;
    @SerializedName("kilometrage")
    @Expose
    private Integer kilometrage;
    @SerializedName("license_plate")
    @Expose
    private String licensePlate;
    private final static long serialVersionUID = -8082313663085258503L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMakeAndModel() {
        return makeAndModel;
    }

    public void setMakeAndModel(String makeAndModel) {
        this.makeAndModel = makeAndModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public static Comparator<VehicleModel> vinComparator = new Comparator<VehicleModel>() {

        public int compare(VehicleModel v1, VehicleModel v2) {
            String vehicle1
                    = v1.getVin();
            String vehicle2
                    = v2.getVin();

            // Returning in ascending order
            return vehicle1.compareTo(
                    vehicle2);
        }
    };
}
