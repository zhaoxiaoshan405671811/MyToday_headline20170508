package com.example.a1.mytoday_headline20170508;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class Navigation extends AppCompatActivity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                Intent intent = new Intent(Navigation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
    private int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean first = sharedPreferences.getBoolean("first", true);
        if(first){
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("frist",false);
            edit.commit();
            handler.sendEmptyMessageDelayed(0,5000);
        }else {
            Intent intent = new Intent(Navigation.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
