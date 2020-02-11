package com.squats.assignment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.squats.assignment.R;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsername,edtPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateInputData();
            }
        });

    }

    private void validateInputData() {

                String username=edtUsername.getText().toString();
                String password=edtPassword.getText().toString();


                if(TextUtils.isEmpty(username)){
                    edtUsername.requestFocus();
                    edtUsername.setError(getString(R.string.validateUser));
                }
                else if(TextUtils.isEmpty(password)) {
                    edtPassword.requestFocus();
                    edtPassword.setError(getString(R.string.validatePasswd));
                }
                else if(!username.equals("sushant")){
                    edtUsername.requestFocus();
                    edtUsername.setError(getString(R.string.validateUser));
                }else if(!password.equals("sushant@123")){
                    edtUsername.requestFocus();
                    edtUsername.setError(getString(R.string.validateUser));
                }else {

                    moveToNextActivity();
                }



    }

    private void moveToNextActivity() {

        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        finish();
    }
}
