package com.example.gaoshihui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class IntroduceActivity extends AppCompatActivity {


    public static AccountManager mManager = new AccountManager() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        try{
        mManager.createFile(this.getApplicationContext());}catch (IOException e){
            System.out.println("文件已建好");
        }

        ImageButton mEnter;

        mEnter = (ImageButton) findViewById(R.id.main_enter);
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(IntroduceActivity.this, LoginActivity.class),1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            finish();
            startActivity(new Intent(IntroduceActivity.this,MainActivity.class)) ;
        }else{
            Toast.makeText(IntroduceActivity.this,"登录界面选择自杀",Toast.LENGTH_SHORT);
        }
    }

    static {
        int accountNums = 0;
    }
}
