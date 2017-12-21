package com.example.kryptonite.maungmal;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Toolbar registerToolbar;
    private Button btnCreateAcc;
    private EditText etName,etPassword,etRe,etEmail;
    private ProgressDialog mProgressDialog;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        mProgressDialog = new ProgressDialog(this);
        registerToolbar =(Toolbar)findViewById(R.id.register_toolbar);
        setSupportActionBar(registerToolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        btnCreateAcc =(Button)findViewById(R.id.btnCreateAcc);
        etName =(EditText)findViewById(R.id.etName);
        etPassword =(EditText)findViewById(R.id.etPassword);
        etRe =(EditText)findViewById(R.id.etRePassword);
        etEmail =(EditText)findViewById(R.id.etEmail);
    btnCreateAcc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isNetworkConnected()) {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String repeat = etRe.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(repeat)) {


                    btnCreateAcc.setBackgroundColor(795548);
                    mProgressDialog.setTitle("Registering User");
                    mProgressDialog.setMessage("Please wait.Creating your account..");
                    mProgressDialog.setCanceledOnTouchOutside(false);
                    mProgressDialog.show();
                    createAccount(name, email, password);


                }
            }
            else{
                Toast.makeText(RegisterActivity.this,"Please Check Your network connection and try again!",Toast.LENGTH_SHORT).show();
            }


        }


    });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    private void createAccount(String name,String email, String password) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                  Toast.makeText(RegisterActivity.this,"hhh",Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                   Intent mainIntent = new Intent(RegisterActivity.this,MainActivity.class);
                   mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   startActivity(mainIntent);
                 finish();

                }
                else{
                    mProgressDialog.hide();
                   Toast.makeText(RegisterActivity.this,"The email you entered is not valid!Please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}




