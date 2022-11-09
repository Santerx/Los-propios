package com.example.empty_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    EditText LogCorreo, LogPass;
 Button btn_register, login;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        LogCorreo = findViewById(R.id.txtcorreo);
        LogPass = findViewById(R.id.txtpassword);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoUser = LogCorreo.getText().toString().trim();
                String passUser = LogPass.getText().toString().trim();

                if(correoUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(login.this, "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(correoUser, passUser);
                }
            }
        });

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    private void loginUser(String correoUser, String passUser) {
        mAuth.signInWithEmailAndPassword(correoUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(login.this, Principal.class));
                    Toast.makeText(login.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(login.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(login.this, "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        if(user!= null){
            startActivity(new Intent(login.this, Principal.class));
        }
    }
}