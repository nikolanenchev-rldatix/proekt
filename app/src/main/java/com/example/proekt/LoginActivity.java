package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        btnlogin=(Button) findViewById(R.id.btnsignin1);
        DB=new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String user=username.getText().toString();
            String pass=password.getText().toString();
            if(user.equals("")||pass.equals(""))
                Toast.makeText(LoginActivity.this,"Please enter both field", Toast.LENGTH_SHORT).show();
            else {
                Boolean checkUserPass=DB.checkusernamepassword(user,pass);
                if(checkUserPass==true){
                    Toast.makeText(LoginActivity.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), CityActivity.class));

                }
                else{
                    Toast.makeText(LoginActivity.this,"Invalid parameters", Toast.LENGTH_SHORT).show();

                }
            }
            }
        });
    }
}