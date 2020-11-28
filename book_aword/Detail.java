package com.example.book_aword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    int likeFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent it = getIntent();

        TextView title = (TextView)findViewById(R.id.bookName);
        title.setSelected(true);

    }

    public void pushAddBtn(View view)
    {

        TextView tv = (TextView)findViewById(R.id.addMyList);

        if(likeFlag == 0) {
            //view.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.pink));
            Toast.makeText(this, "해당 구절이 마이리스트에 담겼습니다.", Toast.LENGTH_SHORT).show();
            tv.setText("마이리스트에서 제외");
            tv.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.pink));
            likeFlag = 1;
        }

        else{
            //view.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.gray));
            Toast.makeText(this, "해당 구절이 마이리스트에서 제외되었습니다.", Toast.LENGTH_SHORT).show();
            tv.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.lightGray));
            tv.setText("마이리스트에 추가");
            likeFlag = 0;
        }

    }


    public void pushBackBtn(View view) {
        finish();
    }
}
