package com.example.book_aword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int likeFlag = 0;
    int loadingFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent it = getIntent();

        Intent intent = new Intent(this, Loading.class);
        startActivity(intent);

    }

    public void goSetting(View view)
    {
        Intent it = new Intent(this, Setting.class);
        startActivity(it);
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

    public void goDetail(View view)
    {
        Intent it_detail = new Intent(this, Detail.class);
        startActivity(it_detail);

    }


    public void pushLikeBtn(View view)
    {
        ImageView img = (ImageView)findViewById(R.id.likeBtn);

        if(likeFlag == 0) {
            img.setImageResource(R.drawable.fullhrt);
            //view.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.pink));
            Toast.makeText(this, "해당 구절이 마이리스트에 담겼습니다.", Toast.LENGTH_SHORT).show();
            likeFlag = 1;
        }

        else{
            //view.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.gray));
            img.setImageResource(R.drawable.emptyhrt);
            Toast.makeText(this, "해당 구절이 마이리스트에서 제외되었습니다.", Toast.LENGTH_SHORT).show();
            likeFlag = 0;
        }

    }

}