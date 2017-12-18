package com.example.kryptonite.maungmal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class AccountSetting extends AppCompatActivity {

    private Button btnChangeName,btnChangeStatus,btnChangeProfile;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        btnChangeName =(Button)findViewById(R.id.btnChangeName);
        btnChangeStatus =(Button)findViewById(R.id.btnChangeStatus);
        btnChangeProfile =(Button)findViewById(R.id.btnChangeProfile);




    }
}
