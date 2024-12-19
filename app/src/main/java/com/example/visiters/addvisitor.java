package com.example.visiters;

import android.content.Intent;
import android.os.Bundle;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class addvisitor extends AppCompatActivity {
    EditText et1,et2;
    String s1,s2;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addvisitor);

        et1=(EditText) findViewById(R.id.e1);
        et2=(EditText) findViewById(R.id.e2);
        btn1=(Button) findViewById(R.id.add);
        btn2=(Button) findViewById(R.id.back);
        btn1.setOnClickListener(new View.OnClickListener() {
            private Object callApi;

            @Override
            public void onClick(View v) {
                s1=et1.getText().toString();
                s2=et2.getText().toString();


                if(s1.isEmpty()||s2.isEmpty()){
                  Toast.makeText(getApplicationContext(),"invalid,all values are mandatory",Toast.LENGTH_LONG).show();
                }
                else{
                   callApi();
                }
            }

            private void callApi() {
                String apiurl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",s1);
                    data.put("lastname",s2);


                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        data,
                        response -> Toast.makeText(getApplicationContext(), "Successfully Addded", Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(getApplicationContext(), "error occured", Toast.LENGTH_LONG).show()
                );
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(obj);
            }
        });


    }
}