package com.example.anonymous.blooddonor.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anonymous.blooddonor.Adapters.DonorListAdapter;
import com.example.anonymous.blooddonor.Models.Donor;
import com.example.anonymous.blooddonor.Network.Backend;
import com.example.anonymous.blooddonor.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.logging.LogManager;

public class ViewDonorsActivity extends AppCompatActivity {
    public static final String TAG = ViewDonorsActivity.class.getSimpleName();
    DonorListAdapter donorListAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Donor> donors ;


    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donors);
        donors = new ArrayList<>();

        recyclerView=(RecyclerView)findViewById(R.id.mRecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);


          jsonDataWebCall();


    }
    public void jsonDataWebCall(){

        jsonArrayRequest = new JsonArrayRequest(Backend.VIEWDONOR_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        jsonParser(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }

    private void jsonParser(JSONArray array) {

        for(int i=0;i<array.length();i++){
        Donor donor=new Donor();
        JSONObject json=null;
            try {
                json=array.getJSONObject(i);
                donor.setFname(json.getString("first_name"));
                donor.setLname(json.getString("last_name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            donors.add(donor);
        }
        donorListAdapter=new DonorListAdapter(donors,this);
        donorListAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(donorListAdapter);


    }

  /*  public void displayDonors(){

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Backend.VIEWDONOR_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject = (JSONObject)response.get(i);
                        Donor donor=new Donor();
                         donor.setFname(jsonObject.getString("first_name"));
                         donor.setLname(jsonObject.getString("last_name"));

                        Log.i(TAG, "onConnectionSuccess, " + response.toString());
                         donors.add(donor);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                donorListAdapter.addData(donors);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQ = Volley.newRequestQueue(this);
        requestQ.add(jsonArrayRequest);
    }*/
}
