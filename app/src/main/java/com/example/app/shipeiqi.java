package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shipeiqi extends AppCompatActivity {

    GridView gvie;
    Button tianjia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipeiqi);
        gvie=findViewById(R.id.gvie);
        tianjia=findViewById(R.id.t_tianjia);

        int img[]={R.drawable.img,R.drawable.img1,R.drawable.img2,R.drawable.img3};
        String name[]={"饿了么","新浪微博","qq音乐","找靓机"};

        List<Map<String,?>> list=new ArrayList<Map<String,?>>();
        for(int b=0;b<img.length;b++){
            Map<String,Object>ite=new HashMap<String,Object>();
            ite.put("imgs",img[b]);
            ite.put("name",name[b]);
            list.add(ite);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.layout_name,new String[]{"imgs","name"},new int[]{R.id.vie2,R.id.vie3});
        gvie.setAdapter(simpleAdapter);

        gvie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(shipeiqi.this,info.class);
                intent.putExtra("xuhao",i);
                startActivity(intent);
            }
        });
        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(shipeiqi.this,tianinfo.class);
                startActivity(intent1);
            }
        });


    }
}
