package com.example.assignmentibm.view.fragment;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmentibm.R;
import com.example.assignmentibm.databinding.FragmentVehicleDetailBinding;
import com.example.assignmentibm.model.VehicleModel;
import com.example.assignmentibm.view.activity.MainActivity;

import java.io.Serializable;


public class VehicleDetailFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private VehicleModel vehicleModel;
    private FragmentVehicleDetailBinding fragmentVehicleDetailBinding;

    public VehicleDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            vehicleModel = (VehicleModel) requireArguments().getSerializable("vehicle");
        }

       setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentVehicleDetailBinding= FragmentVehicleDetailBinding.inflate(inflater, container, false);
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return fragmentVehicleDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(vehicleModel!=null){
            fragmentVehicleDetailBinding.vin.setText(vehicleModel.getVin());
            fragmentVehicleDetailBinding.makeModel.setText(vehicleModel.getMakeAndModel());
            fragmentVehicleDetailBinding.color.setText(vehicleModel.getColor());
            fragmentVehicleDetailBinding.carType.setText(vehicleModel.getCarType());
        }
        fragmentVehicleDetailBinding.btnEmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("kilometers", vehicleModel.getKilometrage());
                BottomSheetEmission bottomSheetEmission = new BottomSheetEmission();
                bottomSheetEmission.setArguments(bundle);
                bottomSheetEmission.show(getChildFragmentManager(), BottomSheetEmission.TAG);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}