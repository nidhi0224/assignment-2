package com.example.assignmentibm.view.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assignmentibm.model.VehicleModel;
import com.example.assignmentibm.network.ApiClient;
import com.example.assignmentibm.network.ApiService;

import java.util.Collections;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class VehicleViewModel extends ViewModel {

    private final String TAG = getClass().getSimpleName();
    private MutableLiveData<List<VehicleModel>> vehicleLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable;
    private ApiService mApiService= ApiClient.getClient().create(ApiService.class);
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    public VehicleViewModel() {
        disposable = new CompositeDisposable();

    }
    public void callVehiclesList(String size){
        loading.setValue(true);
        disposable.add(mApiService.getVehicles(size).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<VehicleModel>>(){

                    @Override
                    public void onSuccess(@NonNull List<VehicleModel> vehicleListModel) {

                        loading.setValue(false);
                        Collections.sort(vehicleListModel,VehicleModel.vinComparator);
                        vehicleLiveData.postValue(vehicleListModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                        loading.setValue(false);
                    }
                }));
    }

    public LiveData<List<VehicleModel>> getVehicles() {
        if (vehicleLiveData == null) {
            vehicleLiveData = new MutableLiveData<>();
        }
        return vehicleLiveData;
    }
    public MutableLiveData<Boolean> loading() {
        return loading;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
