package me.chunyu.spike.wcl_circle_reveal_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.chunyu.spike.wcl_circle_reveal_demo.R;

public class LoginActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void signIn(View view) {
        startActivity(new Intent(this, SignActivity.class));
    }

    public void clickLogin(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }



}
