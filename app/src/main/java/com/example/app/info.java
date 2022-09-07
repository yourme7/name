package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class info extends AppCompatActivity {
    ImageView imgvie;
    TextView tevie;
    Button tiao;
    int img[]={R.drawable.img,R.drawable.img1,R.drawable.img2,R.drawable.img3};
    String name[]={"饿了么","新浪微博","qq音乐","找靓机"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        imgvie=findViewById(R.id.imgvie);
        tevie=findViewById(R.id.tevie);
        tiao=findViewById(R.id.tiao);
        Intent intent=getIntent();
        int xuhao=intent.getIntExtra("xuhao",0);

        imgvie.setImageResource(img[xuhao]);
        tevie.setText(name[xuhao]);

        tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(info.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}