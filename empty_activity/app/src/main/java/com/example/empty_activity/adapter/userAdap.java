package com.example.empty_activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.empty_activity.R;
import com.example.empty_activity.model.usuario;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class userAdap extends FirestoreRecyclerAdapter<usuario, userAdap.ViewHolder> {

    public userAdap(@NonNull FirestoreRecyclerOptions<usuario> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull usuario usuario) {
        viewHolder.nombre.setText(usuario.getName());
        viewHolder.correo.setText(usuario.getCorreo());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_usuario, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, correo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.Nombre);
            correo = itemView.findViewById(R.id.Correo);
        }
    }
}
