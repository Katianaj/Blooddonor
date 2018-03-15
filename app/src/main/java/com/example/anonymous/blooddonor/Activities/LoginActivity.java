package com.example.anonymous.blooddonor.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anonymous.blooddonor.Network.Backend;
import com.example.anonymous.blooddonor.R;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

public class LoginActivity extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mLoginBtn;
    public String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.input_email);
        mPassword = (EditText) findViewById(R.id.input_password);

        mLoginBtn = (Button) findViewById(R.id.loginBtn);


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userLogin();
            }
        });
    }

    private void userLogin() {
        //first getting the values
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();

        //validating inputs
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Please enter your username");
            mPassword.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Please enter your password");
            mPassword.requestFocus();
            return;
        }


        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, Backend.LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")){

                    Intent viewDonor = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(viewDonor);

                }
                else {
                    Toast.makeText(LoginActivity.this, email +" "+password, Toast.LENGTH_LONG).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put(email, mEmail.getText().toString());
                params.put(password, mPassword.getText().toString());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
