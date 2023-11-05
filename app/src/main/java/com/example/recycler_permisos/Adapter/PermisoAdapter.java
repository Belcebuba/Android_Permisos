package com.example.recycler_permisos.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_permisos.Models.Permiso;
import com.example.recycler_permisos.R;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.ViewHolder> {

    public interface OnPermissionChangeListener {
        void onPermissionChanged(String descripcion, boolean isChecked);
    }

    private List<Permiso> LP;
    private OnPermissionChangeListener listener;

    public PermisoAdapter(List<Permiso> LP, OnPermissionChangeListener listener) {
        this.LP = LP;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.permisolayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoAdapter.ViewHolder holder, int position) {
        Permiso permiso = LP.get(position);
        holder.setData(permiso);
    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPermiso;
        Switch swPermiso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso = itemView.findViewById(R.id.tvPermiso);
            swPermiso = itemView.findViewById(R.id.swpermiso);

            swPermiso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String descripcionPermiso = txtPermiso.getText().toString();
                    listener.onPermissionChanged(descripcionPermiso, isChecked);
                }
            });
        }

        public void setData(Permiso permiso) {
            txtPermiso.setText(permiso.getDescripcion());
        }
    }
}
