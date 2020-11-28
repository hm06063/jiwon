package com.example.book_aword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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

    public void goLogin(View view)
    {
        Intent it_login = new Intent(this, Login.class);
        startActivity(it_login);
    }

    public void goLoginInput(View view) {
        Intent it_loginInput = new Intent(this, LoginInput.class);
        startActivity(it_loginInput);
    }

}
