package com.example.ipaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONObject;

public class Your_Location extends AppCompatActivity {
    private RequestQueue requestQueue;
    SimpleArcLoader simpleArcLoader;
    TextView ip,country_code,country_name,region_code,region_name,city,zip_code,time_zone,latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your__location);
        ip=findViewById(R.id.ip);
        country_code=findViewById(R.id.country_code);
        country_name=findViewById(R.id.country_name);
        region_code=findViewById(R.id.region_code);
        region_name=findViewById(R.id.region_name);
        city=findViewById(R.id.city);
        zip_code=findViewById(R.id.zip_code);
        time_zone=findViewById(R.id.time_zone);
        latitude=findViewById(R.id.latitude);
        longitude=findViewById(R.id.longitude);
        simpleArcLoader = findViewById(R.id.loader);
        simpleArcLoader.start();
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "https://freegeoip.app/json/", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ip.setText(response.getString("ip"));
                            country_code.setText(response.getString("country_code"));
                            country_name.setText(response.getString("country_name"));
                            region_code.setText(response.getString("region_code"));
                            region_name.setText(response.getString("region_name"));
                            city.setText(response.getString("city"));
                            zip_code.setText(response.getString("zip_code"));
                            time_zone.setText(response.getString("time_zone"));
                            latitude.setText(response.getString("latitude"));
                            longitude.setText(response.getString("longitude"));
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
