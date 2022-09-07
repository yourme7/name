package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Zuoye extends AppCompatActivity {
    Button chaweizhang,tingche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuoye);

        chaweizhang=findViewById(R.id.chaweizhang);
        tingche=findViewById(R.id.tingche);

        chaweizhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Zuoye.this,Chaweizhang.class);
                startActivity(intent);
            }
        });
        tingche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 =new Intent(Zuoye.this,Zuoye2.class);
                startActivity(intent1);
            }
        });
    }


}