package com.example.visiters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
            @Override
            public void onClick(View v) {
                s1=et1.getText().toString();
                s2=et2.getText().toString();
                Toast.makeText(getApplicationContext(),s1+""+s2, Toast.LENGTH_SHORT).show();
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