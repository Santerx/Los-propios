package com.example.empty_activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class boton2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton2);


        Button botonvolver= findViewById(R.id.btn_volver);
        Button descargar=  findViewById(R.id.descargar);

        botonvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(boton2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        descargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarAlertDialog();
            }
        });
    }
    public void mostrarAlertDialog() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        dialogo.setTitle("ONE PIECE");
        View dialogoView = inflater.inflate(R.layout.alertdialog, null);
        dialogo.setView(dialogoView);

        dialogoView.findViewById(R.id.BotonSi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Boton Si funcionando", Toast.LENGTH_LONG).show();
            }
        });

        dialogoView.findViewById(R.id.BotonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Boton No funcionando", Toast.LENGTH_LONG).show();
            }
        });

        dialogo.show();
    }
}