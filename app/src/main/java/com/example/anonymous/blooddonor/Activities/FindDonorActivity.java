package com.example.anonymous.blooddonor.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anonymous.blooddonor.R;

public class FindDonorActivity extends AppCompatActivity {
    Button findDonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_donor);
      findDonor=(Button)findViewById(R.id.mFindDonorBtn);
        findDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewDonor=new Intent(FindDonorActivity.this,ViewDonorsActivity.class);
                startActivity(viewDonor);
            }
        });
    }
}
