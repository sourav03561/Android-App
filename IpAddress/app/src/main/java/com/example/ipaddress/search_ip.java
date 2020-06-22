package com.example.ipaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONObject;

public class search_ip extends AppCompatActivity {
    private RequestQueue requestQueue;
    SimpleArcLoader simpleArcLoader;
    TextView country,region,zip,latitude,longitude,country1,region1,zip1,latitude1,longitude1,city,city1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ip);
        country= findViewById(R.id.country);
        region = findViewById(R.id.region);
        zip = findViewById(R.id.zip);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        city =findViewById(R.id.city);
        city1=findViewById(R.id.textView10);

        country1= findViewById(R.id.textView);
        region1= findViewById(R.id.textView3);
        zip1=findViewById(R.id.textView5);
        latitude1=findViewById(R.id.textView7);
        longitude1=findViewById(R.id.textView9);

        country.setVisibility(View.INVISIBLE);
        country1.setVisibility(View.INVISIBLE);
        region.setVisibility(View.INVISIBLE);
        region1.setVisibility(View.INVISIBLE);
        zip.setVisibility(View.INVISIBLE);
        zip1.setVisibility(View.INVISIBLE);
        latitude.setVisibility(View.INVISIBLE);
        latitude1.setVisibility(View.INVISIBLE);
        longitude.setVisibility(View.INVISIBLE);
        longitude1.setVisibility(View.INVISIBLE);
        city.setVisibility(View.INVISIBLE);
        city1.setVisibility(View.INVISIBLE);

        simpleArcLoader = findViewById(R.id.loader);
    }

    public void search(View view) {
        EditText ip=(EditText) findViewById(R.id.editText);

        simpleArcLoader.start();
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "http://api.ipstack.com/"+ip.getText().toString()+"?access_key=31c7ccb107839d75181cceb0452e43ac", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("JSON:", "onResponse:" + response.getString("country_name"));
                            country.setText(response.getString("country_name"));
                            region.setText(response.getString("region_name"));
                            zip.setText(response.getString("zip"));
                            latitude.setText(response.getString("latitude"));
                            longitude.setText(response.getString("longitude"));
                            city.setText(response.getString("city"));
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

        country.setVisibility(View.VISIBLE);
        country1.setVisibility(View.VISIBLE);
        region.setVisibility(View.VISIBLE);
        region1.setVisibility(View.VISIBLE);
        zip.setVisibility(View.VISIBLE);
        zip1.setVisibility(View.VISIBLE);
        latitude.setVisibility(View.VISIBLE);
        latitude1.setVisibility(View.VISIBLE);
        longitude.setVisibility(View.VISIBLE);
        longitude1.setVisibility(View.VISIBLE);
        city.setVisibility(View.VISIBLE);
        city1.setVisibility(View.VISIBLE);
        simpleArcLoader.stop();
        simpleArcLoader.setVisibility(View.GONE);
    }
}

