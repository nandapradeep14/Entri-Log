package com.nanda.entrilog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    AppCompatButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences  preference =getSharedPreferences("logoapp",MODE_PRIVATE);
        String username=preference.getString("user",null);
        if(username!=null)
        {
            Intent i = new Intent(getApplicationContext(), log.class);
            startActivity(i);
        }

        ed1=(EditText) findViewById(R.id.uname);
        ed2=(EditText) findViewById(R.id.pass);
        b1=(AppCompatButton) findViewById(R.id.logbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*SharedPreferences preference=getSharedPreferences("login",MODE_PRIVATE);
                String username=preference.getString("user",null);*/
                String getUsername = ed1.getText().toString();
                String getPassword = ed2.getText().toString();
                try {
                    if (username != null) {
                        Intent i = new Intent(getApplicationContext(), log.class);
                        startActivity(i);
                    }
                    if (getUsername.equals("admin") && getPassword.equals("1234")) {
                        SharedPreferences preference = getSharedPreferences("logoapp", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preference.edit();
                        editor.clear();
                        editor.apply();
                        //editor.putString("user","admin");


                        Intent i = new Intent(getApplicationContext(), log.class);
                        startActivity(i);


                    } else {
                        Toast.makeText(getApplicationContext(), "invalid credentials", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), toString(), Toast.LENGTH_LONG).show();
                }
            }

        });

            }
        }


