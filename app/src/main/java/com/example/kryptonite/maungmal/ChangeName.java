package com.example.kryptonite.maungmal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeName extends AppCompatActivity {

    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private Button btnChangeName;
    private EditText etChangeName;
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_name);

        toolbar =(Toolbar)findViewById(R.id.changeName_toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Change Name");

         btnChangeName =(Button)findViewById(R.id.btnChangeNamenew);
         etChangeName =(EditText)findViewById(R.id.etChangeNamenew);
         btnChangeName.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                    String newName = etChangeName.getText().toString();

             }
         });


    }
}
