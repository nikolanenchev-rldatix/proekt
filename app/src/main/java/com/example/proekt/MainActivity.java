package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup,signin;
    DBHelper DB;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB= new DBHelper(this);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        repassword=(EditText) findViewById(R.id.repassword);
        signup=(Button) findViewById(R.id.btnsignup);
        signin=(Button) findViewById(R.id.btnsignin);
            signin.setOnClickListener(v -> {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            });
        signup.setOnClickListener(v -> {
            String s1 = username.getText().toString();
            String s2 = password.getText().toString();
            String s3 = repassword.getText().toString();
            if(s1.equals("")||s2.equals("")||s3.equals("")){
                Toast.makeText (getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();

            }
            else {
                if (s2.equals(s3)) {
                    Boolean check = DB.checkusername(s1);
                    if (check) {
                        boolean insert = DB.insertData(s1, s2);
                        if (insert) {
                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}