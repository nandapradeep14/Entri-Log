package com.nanda.entrilog;

import android.content.Intent;
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

public class log extends AppCompatActivity {

    AppCompatButton b1,b2;
    EditText ed1,ed2,ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log);
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.no);
        ed3=(EditText) findViewById(R.id.sysno);
        ed4=(EditText) findViewById(R.id.dept);

        b1=(AppCompatButton) findViewById(R.id.lout);
        b2=(AppCompatButton) findViewById(R.id.add);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName=ed1.getText().toString();
                String getadmno=ed2.getText().toString();
                String getdept=ed3.getText().toString();
                String getsysno=ed4.getText().toString();
                Toast.makeText(getApplicationContext(),getName+getadmno+getdept+getsysno, Toast.LENGTH_LONG).show();
            }

        });




    }
}