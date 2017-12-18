package com.example.kryptonite.maungmal;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager viewPager;
    public Toolbar Toolb;
    private FirebaseAuth mAuth;
    private SectionPagerAdapter sectionPagerAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        //Tabs
        viewPager =(ViewPager)findViewById(R.id.tabsPager) ;
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionPagerAdapter);

        //for tabLayout
        mTablayout =(TabLayout)findViewById(R.id.main_tabs);
        mTablayout.setupWithViewPager(viewPager

        );




   Toolb =(Toolbar)findViewById(R.id.main_page_toolbars2);
 setSupportActionBar(Toolb);
   getSupportActionBar().setTitle("Maung & Mal");





 }



    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       if(currentUser==null)
       {
         letstart();

       }
    }

    private void letstart() {
        Intent i = new Intent(MainActivity.this,StartActivity.class);
        startActivity(i);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.main_menu,menu);

         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);


        switch (item.getItemId()){
            case R.id.btnLogOut:
                Toast.makeText(getApplicationContext(),"You're Log Out",Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                letstart();
                break;
            case R.id.acc_settings:
                accsetting();
            break;





        }

        return true;

    }

    private void accsetting() {
        startActivity(new Intent(MainActivity.this,AccountSetting.class));
        finish();



    }
}
