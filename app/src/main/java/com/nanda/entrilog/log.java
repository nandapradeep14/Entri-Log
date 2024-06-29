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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class log extends AppCompatActivity {

    AppCompatButton b1,b2;
    EditText ed1,ed2,ed3,ed4;
    String apiUrl="http://10.0.4.16:3000/api/students";
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
                SharedPreferences preference=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor= preference.edit();
                editor.clear();
                editor.apply();
                Intent i2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i2);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //value reading
                String getName=ed1.getText().toString();
                String getadmno=ed2.getText().toString();
                String getdept=ed3.getText().toString();
                String getsysno=ed4.getText().toString();

                //creating json object
                JSONObject student=new JSONObject();

                try {
                    student.put("name",getName);
                    student.put("admission_number",getadmno);
                    student.put("system_number",getsysno);
                    student.put("department",getdept);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            //json object requires creation
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(

                        Request.Method.POST,
                        apiUrl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "succesfully added", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();

                            }

});
                //request queue
            RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(jsonObjectRequest);


            }

        });




    }
}