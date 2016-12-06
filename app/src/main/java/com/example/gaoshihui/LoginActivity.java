package com.example.gaoshihui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static com.example.gaoshihui.IntroduceActivity.mManager;

public class LoginActivity extends AppCompatActivity {
    //declare
    Button mButtonLogin, mButtonSignIn;
    EditText mEditTextEmail, mEditTextPassword;
    TextView mTextViewForgottenPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mManager.readAccountList(this);


        mEditTextEmail = (EditText) findViewById(R.id.login_account);
        mEditTextPassword = (EditText) findViewById(R.id.login_password);


        mButtonLogin = (Button) findViewById(R.id.login_button_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin(LoginActivity.this);
            }
        });

        mButtonSignIn = (Button) findViewById(R.id.login_button_sign_in);
        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean ifNull() {
        String a = mEditTextEmail.getText().toString();
        String b = mEditTextPassword.getText().toString();

        return a.equals("") || b.equals("");
    }

    private void onLogin(Context context) {
        if (ifNull()) {
            Toast.makeText(LoginActivity.this,"填好再点哦", Toast.LENGTH_SHORT).show();
        } else {
            try {
                if (mManager.logIn(mEditTextEmail.getText().toString(), mEditTextPassword.getText().toString(), context)) {
                    Toast.makeText(LoginActivity.this, "开始搞事吧", Toast.LENGTH_SHORT).show();
                    finishActivity(1);
                    finish();

                } else Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (AccountManager.NotExistException e) {
                Toast.makeText(LoginActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

