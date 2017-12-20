package com.example.kryptonite.maungmal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountSetting extends AppCompatActivity {



    private EditText etnewName;
    private LinearLayout mylayout;
    private DatabaseReference databaseReference;
    private FirebaseUser firebaseUser;
    private Button btnChangeName,btnChangeStatus,btnChangeProfile;
    private TextView tvName,tvStatus;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        etnewName =(EditText)findViewById(R.id.newname);

        mylayout =(LinearLayout)findViewById(R.id.mylayout);
        btnChangeName =(Button)findViewById(R.id.btnChangeName);
        btnChangeStatus =(Button)findViewById(R.id.btnChangeStatus);
        btnChangeProfile =(Button)findViewById(R.id.btnChangeProfile);

        tvName=(TextView)findViewById(R.id.tvName1);
        tvStatus =(TextView)findViewById(R.id.tvStatus);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String user_id = firebaseUser.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Toast.makeText(AccountSetting.this,dataSnapshot.toString(),Toast.LENGTH_LONG).show();
               String image =  dataSnapshot.child("image").getValue().toString();
               String name = dataSnapshot.child("name").getValue().toString();
               String status = dataSnapshot.child("status").getValue().toString();

               tvName.setText(name);
               tvStatus.setText(status);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


btnChangeName.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //mylayout.setVisibility(view.VISIBLE);

       // String newname = etnewName.getText().toString();
        //tvName.setText(newname);




    }
});




    }
}
