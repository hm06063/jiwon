package com.example.book_aword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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

    public void goLogout(View view)
    {
        Intent it_logOut = new Intent(this, Login.class);
        Toast.makeText(getApplicationContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(it_logOut);
    }

}
