package com.example.appmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2= findViewById(R.id.button2);
        Button button3= findViewById(R.id.button3);
        Button button4= findViewById(R.id.button4);
        Button button5= findViewById(R.id.button5);
        Button button6= findViewById(R.id.button6);
        Button button7= findViewById(R.id.button7);
        Button button8= findViewById(R.id.button8);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, boton1.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, boton2.class);
                startActivity(intent2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(MainActivity.this, boton3.class);
                startActivity(intent3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4= new Intent(MainActivity.this, boton4.class);
                startActivity(intent4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, boton5.class);
                startActivity(intent5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6= new Intent(MainActivity.this, boton6.class);
                startActivity(intent6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7= new Intent(MainActivity.this, boton7.class);
                startActivity(intent7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8= new Intent(MainActivity.this, boton8.class);
                startActivity(intent8);
            }
        });
    }
}