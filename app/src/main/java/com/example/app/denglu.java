package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class denglu extends AppCompatActivity {
    Button zhuce,duqu;
    EditText zhanghao;
    CheckBox cun;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);

        zhuce=findViewById(R.id.zhuce);
        zhanghao=findViewById(R.id.zhanghao);
        cun=findViewById(R.id.cun);
        duqu=findViewById(R.id.read);

        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent1=getIntent();
               // Bundle bundle=intent1.getExtras();
                //String a=bundle.getString("yonghu");
               // zhanghao.setText(a)   ;
                Intent intent=new Intent(denglu.this,zhuce.class);
                startActivity(intent);
            }
        });
            cun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String a=zhanghao.getText().toString();
                    sp=getSharedPreferences("sttte",MODE_PRIVATE);
                    SharedPreferences.Editor spp=sp.edit();
                    if(cun.isChecked()==true){
                        try{
                            FileOutputStream out =denglu.this.openFileOutput("shuju.txt",MODE_PRIVATE);
                            byte[] s=a.getBytes();
                            out.write(s);
                            out.close();
                            spp.putString("seey",a);
                            spp.commit();
                            Toast.makeText(denglu.this,"数据已保存",Toast.LENGTH_SHORT).show();
                        }catch (FileNotFoundException e){
                            Toast.makeText(denglu.this,"数据未写入",Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            Toast.makeText(denglu.this,"数据保存失败",Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        spp.clear();
                        spp.commit();
                    }
                }
            });

            duqu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sp=getSharedPreferences("sttte",MODE_PRIVATE);
                    String b=sp.getString("seey",null);
                    try{
                        FileInputStream in =denglu.this.openFileInput("shuju.txt");
                        byte[] a=new byte[1024];
                        in.read(a);
                        String s=new String(a);
                        zhanghao.setText(s);
                        in.close();
                    }
                    catch (IOException e) {
                        Toast.makeText(denglu.this,"数据读取失败",Toast.LENGTH_SHORT).show();
                    }
                }
            });


    }
}