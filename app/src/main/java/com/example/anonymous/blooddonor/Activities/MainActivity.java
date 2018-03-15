package com.example.anonymous.blooddonor.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anonymous.blooddonor.R;

public class MainActivity extends AppCompatActivity {

    Button LoginBtn,RegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginBtn=(Button)findViewById(R.id.loginBtn);
        RegisterBtn=(Button)findViewById(R.id.registerBtn);

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(register);
            }
        });

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(login);
            }
        });
    }
}
