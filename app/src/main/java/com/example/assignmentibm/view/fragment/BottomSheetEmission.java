package com.example.assignmentibm.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assignmentibm.databinding.BottomSheetEmissionBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetEmission extends BottomSheetDialogFragment {

    public static final String TAG = "BottomSheetEmission";
    private BottomSheetEmissionBinding bottomSheetEmissionBinding;
    private int kilometers;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        bottomSheetEmissionBinding= BottomSheetEmissionBinding.inflate(inflater,container,false);
        if(getArguments()!=null)
            kilometers = getArguments().getInt("kilometers");
        return bottomSheetEmissionBinding.getRoot();
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bottomSheetEmissionBinding.kilometer.setText(String.valueOf(kilometers));
        bottomSheetEmissionBinding.carbonEmission.setText(calculateEmission());

        bottomSheetEmissionBinding.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private String calculateEmission() {
        double emission;
        if(kilometers>5000){
            emission =(kilometers-5000) *1.5 + 5000;
        }else{
            emission = kilometers;
        }
        return String.valueOf(emission);
    }
}
