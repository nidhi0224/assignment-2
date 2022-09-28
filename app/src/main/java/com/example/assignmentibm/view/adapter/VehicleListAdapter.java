package com.example.assignmentibm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentibm.databinding.RowVehicleListBinding;
import com.example.assignmentibm.model.VehicleModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VehicleListAdapter extends RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder>  {
    private Context mContext;
    private List<VehicleModel> listVehicles = new ArrayList<>();
    private VehicleListener vehicleListener;

    public VehicleListAdapter(Context mContext,VehicleListener vehicleListener) {
        this.mContext = mContext;
        this.vehicleListener=vehicleListener;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VehicleViewHolder(RowVehicleListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        VehicleModel vehicle = listVehicles.get(position);
        holder.rowVehicleListBinding.vehicleId.setText(String.valueOf(vehicle.getVin()));
        holder.rowVehicleListBinding.makeModel.setText(String.valueOf(vehicle.getMakeAndModel()));
        holder.rowVehicleListBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vehicleListener.onClickVehicle(vehicle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listVehicles == null ? 0 : listVehicles.size();
    }

    public void getVehicles(List<VehicleModel> listVehicles){
        this.listVehicles=listVehicles;
        notifyDataSetChanged();
    }
    public static class VehicleViewHolder extends RecyclerView.ViewHolder {
        // Define movie_item layout view binding
        RowVehicleListBinding rowVehicleListBinding;

        public VehicleViewHolder(@NonNull RowVehicleListBinding rowVehicleListBinding) {
            super(rowVehicleListBinding.getRoot());
            // init binding
            this.rowVehicleListBinding = rowVehicleListBinding;
        }
    }

    public interface VehicleListener{
        void onClickVehicle(VehicleModel model);
    }

}
