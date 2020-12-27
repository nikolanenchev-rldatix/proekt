package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DB=new DBHelper(this);
        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        btnlogin=(Button) findViewById(R.id.btnsignin1);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String user=username.getText().toString();
            String pass=password.getText().toString();
                Boolean checkUserPass=DB.checkusernamepassword(user,pass);
                if(checkUserPass == true) {
                    Toast.makeText(getApplicationContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent i2 = new Intent(LoginActivity.this, CityActivity.class);
                    i2.putExtra("user",user);
                    startActivity(i2);
                }
                else
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}