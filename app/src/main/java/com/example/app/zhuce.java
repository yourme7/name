package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class zhuce extends AppCompatActivity {
    Button denglu;
    EditText zhanghao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        denglu=findViewById(R.id.denglu);
        zhanghao=findViewById(R.id.zhanghao);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=zhanghao.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("yonghu",a);
                Intent intent=new Intent(zhuce.this,shipeiqi.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}