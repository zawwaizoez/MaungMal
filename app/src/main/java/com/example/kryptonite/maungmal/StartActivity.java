package com.example.kryptonite.maungmal;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class StartActivity extends AppCompatActivity {


    private Button btnRegister,btnLogin,btnfacebooklogin;
    private EditText etEmail,etPassword;
    private TextView forgotpassword;
    private ProgressDialog LoginProgressDialog;
    private FirebaseAuth mAuth;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mAuth = FirebaseAuth.getInstance();
        LoginProgressDialog = new ProgressDialog(this);

        btnfacebooklogin=(Button)findViewById(R.id.btnfacebooklogin);
        btnRegister =(Button)findViewById(R.id.btnRegister);
        btnLogin =(Button)findViewById(R.id.btnLoginp);
        etEmail =(EditText)findViewById(R.id.loginEmail);
        etPassword =(EditText)findViewById(R.id.loginPassword);
        forgotpassword=(TextView)findViewById(R.id.forgotpassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();



            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StartActivity.this,RegisterActivity.class));

            }
        });
    }

    private void startLogin() {
        String loginEmail =etEmail.getText().toString();
        String loginPassword = etPassword.getText().toString();
        if(isNetworkConnected()){
         if(!TextUtils.isEmpty(loginEmail)&& !TextUtils.isEmpty(loginPassword)){
             LoginProgressDialog.setTitle("Logging User");
             LoginProgressDialog.setMessage("Please Wait while logging in..");
             LoginProgressDialog.show();

             loginUser(loginEmail,loginPassword);
         }


        }


    }

    private void loginUser(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

//                            updateUI(user);
                            startActivity(new Intent(StartActivity.this,MainActivity.class));
                            finish();
                            LoginProgressDialog.dismiss();



                        } else {
                            // If sign in fails, display a message to the user.


                            Toast.makeText(StartActivity.this, "Email or Password is incorrect.Please try again",
                                    Toast.LENGTH_SHORT).show();
                            LoginProgressDialog.hide();
                        }


                    }
                });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

}
