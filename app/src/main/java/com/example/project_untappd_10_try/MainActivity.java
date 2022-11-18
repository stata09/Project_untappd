package com.example.project_untappd_10_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void goReset(View v){
            Intent intent = new Intent(this, Reset_password.class);
            startActivity(intent);
        }
        public void goCreate(View v){
        Intent intent = new Intent(this, Create_account.class);
        startActivity(intent);
        }
}