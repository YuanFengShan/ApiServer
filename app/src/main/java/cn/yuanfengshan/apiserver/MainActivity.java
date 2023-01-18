package cn.yuanfengshan.apiserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.yuanfengshan.api.base.IModule1Api;
import cn.yuanfengshan.api.base.IModule2Api;
import cn.yuanfengshan.base.api.framework.ApiServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String helloWordString = IModule1Api.getServer().getHelloWordString();
                Toast.makeText(v.getContext(), helloWordString, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.main_btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String helloWordString = IModule2Api.getServer().getHelloWordString();
                Toast.makeText(v.getContext(), helloWordString, Toast.LENGTH_SHORT).show();
            }
        });


    }
}