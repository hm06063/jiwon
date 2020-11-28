package com.example.book_aword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent it = getIntent();
    }

    public void goHome(View view)
    {
        Intent it_home = new Intent(this, MainActivity.class);
        startActivity(it_home);
    }

    public void goMyList(View view)
    {
        Intent it_myList = new Intent(this, MyList.class);
        startActivity(it_myList);
    }


    public void goSetting(View view)
    {
        Intent it_setting = new Intent(this, Setting.class);
        startActivity(it_setting);
    }

    public void goLoginInput(View view) {
        Intent it_loginInput = new Intent(this, LoginInput.class);
        startActivity(it_loginInput);
    }

    public void goJoin(View view)
    {
        Intent it_join = new Intent(this, Join.class);
        startActivity(it_join);
    }
}
