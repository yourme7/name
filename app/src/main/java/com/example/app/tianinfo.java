package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.util.Database;

public class tianinfo extends AppCompatActivity {
    EditText t_na,t_txt;
    Button b_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianinfo);
        t_na=findViewById(R.id.t_na);
        t_txt=findViewById(R.id.t_txt);
        b_add=findViewById(R.id.b_add);


        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=t_na.getText().toString();
                String info=t_txt.getText().toString();

                Database dd=new Database(tianinfo.this);
                ContentValues va=new ContentValues();
                va.put("name",name);
                va.put("info",info);
                dd.tian(va);
                Toast.makeText(tianinfo.this,"数据添加成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}