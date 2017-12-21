package com.example.kryptonite.maungmal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Account_Status extends AppCompatActivity {

    private Toolbar mToolBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account__status);

        mToolBar =(Toolbar)findViewById(R.id.account_setting_toolbar);
        //mToolBar.setTitle("Account Setting");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Account Setting");



    }
}
