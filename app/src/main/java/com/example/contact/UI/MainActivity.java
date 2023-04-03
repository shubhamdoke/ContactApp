package com.example.contact.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contact.R;

public class MainActivity extends AppCompatActivity {
    EditText user_id, password;
    Button login;
    SharedPreferences preferences;
    SharedPreferences.Editor myEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_id=findViewById(R.id.user_id);
        password=findViewById(R.id.pass);
        login=findViewById(R.id.btnpost);

        String id = "Test@123";
        String pass = "Pass@123";
        preferences = getSharedPreferences("User_info", MODE_PRIVATE);
        myEdit = preferences.edit();

        if(preferences.contains("email")){
            startActivity(new Intent(MainActivity.this, Dashboard.class));
            finish();
        }
        else
        {

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String uid = user_id.getText().toString();
                    String upass = password.getText().toString();
                    if (uid.equals(id) && upass.equals(pass)) {
                        startActivity(new Intent(MainActivity.this, Dashboard.class));
                        finish();
                        myEdit.putString("email", uid);
                        myEdit.putString("pass", upass);
                        myEdit.commit();
                    } else {
                        Toast.makeText(MainActivity.this, "Please Enter your all Details", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}