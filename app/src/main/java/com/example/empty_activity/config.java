package com.example.empty_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.appbar.MaterialToolbar;

public class config extends AppCompatActivity {

    private ConstraintLayout back;
    private MaterialToolbar toolbar;
    private Switch change_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        back = (ConstraintLayout) findViewById(R.id.back);
        toolbar = (MaterialToolbar) findViewById(R.id.topAppBar);
        change_theme = (Switch) findViewById(R.id.change_theme);

        change_theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(change_theme.isChecked()) {
                    updateTheme("DARK", "#212121", "#37474f");
                } else {
                    updateTheme("DEFAULT", "#FFFFFF", "#FF3700B3");
                }
            }
        });

        loadTheme();
    }

    public void updateTheme(String key, String c1, String c2) {
        SharedPreferences savePreferences = getSharedPreferences("config_theme", MODE_PRIVATE);
        SharedPreferences.Editor ObjEditor = savePreferences.edit();
        ObjEditor.putString("theme", key);
        ObjEditor.commit();

        back.setBackgroundColor(Color.parseColor(c1));
        toolbar.setBackgroundColor(Color.parseColor(c2));
    }

    public void loadTheme() {
        SharedPreferences loadPreferences = getSharedPreferences("config_theme", MODE_PRIVATE);
        String actualTheme = loadPreferences.getString("theme", "DEFAULT");

        if(actualTheme.equals("DEFAULT")) {
            updateTheme("DEFAULT", "#FFFFFF", "#FF3700B3");
        } else if(actualTheme.equals("DARK")) {
            updateTheme("DARK", "#212121", "#37474f");
            change_theme.setChecked(true);
        }
    }
}
