package com.example.gaoshihui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.gaoshihui.IntroduceActivity.mManager;

public class SignInActivity extends AppCompatActivity {

     Button mButtonSignIn;
     EditText mEditTextEmail, mEditTextPassword;
     ImageView mCheckRepeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEditTextPassword=(EditText)findViewById(R.id.sign_in_password);

        mCheckRepeat = (ImageView) findViewById(R.id.sign_in_if_repeat);
        mEditTextEmail = (EditText) findViewById(R.id.sign_in_account);
        mEditTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals(""))mCheckRepeat.setImageResource(R.drawable.angry);
                else {
                    if(mManager.mAccountNum.get(mEditTextEmail.getText().toString())==null)mCheckRepeat.setImageResource(R.drawable.hilarious);
                        else mCheckRepeat.setImageResource(R.drawable.angry);
                    }
                }

        });
        mButtonSignIn=(Button)findViewById(R.id.sign_in_button_sign_in);
        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextEmail.getText().toString().equals("")) mCheckRepeat.setImageResource(R.drawable.angry);
                else {
                    if(ifNull()) Toast.makeText(SignInActivity.this,"w",Toast.LENGTH_SHORT).show();
                    try {
                        mManager.signIn(mEditTextEmail.getText().toString(), mEditTextPassword.getText().toString());
                        SignInActivity.this.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }}
            }
        });}


    public boolean ifNull() {
        String a = mEditTextEmail.getText().toString();
        String b = mEditTextPassword.getText().toString();


        if (a.equals("") || b.equals(""))
             return true ;
        else return false;
    }
}
