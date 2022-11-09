package com.example.empty_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.empty_activity.adapter.userAdap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    Button registro;
    EditText nombre, correo, contraseña;

    FirebaseFirestore mfirestore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mfirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correo);
        contraseña = findViewById(R.id.contraseña);
        registro = findViewById(R.id.btn_registrar);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUser = nombre.getText().toString().trim();
                String emailUser = correo.getText().toString().trim();
                String passUser = contraseña.getText().toString().trim();

                if(nombreUser.isEmpty() && emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }else{
                    registrerUser(nombreUser,emailUser,passUser);
                }
            }
        });
    }

    private void registrerUser(String nombreUser, String emailUser, String passUser) {
        mAuth.createUserWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", nombreUser);
                map.put("correo", emailUser);
                map.put("contraseña", passUser);

                mfirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(MainActivity2.this, login.class));
                        Toast.makeText(MainActivity2.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity2.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity2.this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }


}