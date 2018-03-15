package com.example.anonymous.blooddonor.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anonymous.blooddonor.Interface.RestApi;
import com.example.anonymous.blooddonor.Models.Donor;
import com.example.anonymous.blooddonor.Network.Backend;
import com.example.anonymous.blooddonor.R;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    EditText mPhone,mEmail,mFname,mLname,mBloodgroup,mDob,mPassword,mCounty;
    Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mPhone=(EditText)findViewById(R.id.input_phone);
        mEmail=(EditText)findViewById(R.id.input_email);
        mFname=(EditText)findViewById(R.id.input_fname);
        mLname=(EditText)findViewById(R.id.input_lname);
        mBloodgroup=(EditText)findViewById(R.id.input_bgroup);
        mDob=(EditText)findViewById(R.id.input_dob);
        mPassword=(EditText)findViewById(R.id.input_password);
        mCounty=(EditText)findViewById(R.id.input_county);
        mRegister=(Button)findViewById(R.id.registerBtn);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDonor();
            }
        });
    }

    public void insertDonor() {
        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST,Backend.REGISTER_URL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(RegisterActivity.this,response,Toast.LENGTH_LONG).show();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<String, String>();
                params.put("phone",mPhone.getText().toString());
                params.put("first_name",mFname.getText().toString());
                params.put("language",mLname.getText().toString());
                params.put("email",mEmail.getText().toString());

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
