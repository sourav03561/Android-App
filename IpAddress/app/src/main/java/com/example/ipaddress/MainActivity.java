package com.example.ipaddress;

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

    public void Your_ip(View view) {

        Intent activity2Intent = new Intent(getApplicationContext(), Your_Location.class);
        startActivity(activity2Intent);
    }

    public void search(View view) {
        Intent activity2Intent = new Intent(getApplicationContext(), search_ip.class);
        startActivity(activity2Intent);
    }
}
