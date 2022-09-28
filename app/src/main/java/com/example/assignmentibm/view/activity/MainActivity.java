package com.example.assignmentibm.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.assignmentibm.R;
import com.example.assignmentibm.databinding.ActivityMainBinding;
import com.example.assignmentibm.model.VehicleModel;
import com.example.assignmentibm.view.adapter.VehicleListAdapter;
import com.example.assignmentibm.view.fragment.VehicleDetailFragment;
import com.example.assignmentibm.view.viewmodel.VehicleViewModel;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VehicleListAdapter.VehicleListener {

    private static final String TAG = "MainActivity";
    private Context mContext;
    private ActivityMainBinding activityMainBinding;
    private String size;
    private VehicleViewModel vehicleViewModel;
    private VehicleListAdapter vehicleListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        mContext=this;
        vehicleViewModel=  new ViewModelProvider(this).get(VehicleViewModel.class);
        setRecyclerView();
        setObserver();
        activityMainBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size = activityMainBinding.edtInput.getText().toString();
                vehicleViewModel.callVehiclesList(size);
            }
        });

    }
    private void setObserver(){
        vehicleViewModel.getVehicles().observe(this, new Observer<List<VehicleModel>>() {
            @Override
            public void onChanged(List<VehicleModel> vehicleListModel) {
                vehicleListAdapter.getVehicles(vehicleListModel);
            }
        });
        vehicleViewModel.loading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    activityMainBinding.progressBar.setVisibility(View.VISIBLE);
                }else{
                    activityMainBinding.progressBar.setVisibility(View.GONE);
                }
            }
        });

    }
    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        activityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
        vehicleListAdapter = new VehicleListAdapter(mContext, this);
        activityMainBinding.recyclerView.setAdapter(vehicleListAdapter);

    }

    @Override
    public void onClickVehicle(VehicleModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("vehicle", model);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer,VehicleDetailFragment.class, bundle)
                .addToBackStack("VehicleDetailFragment")
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }
}