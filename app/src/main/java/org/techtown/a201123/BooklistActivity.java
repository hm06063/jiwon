package org.techtown.a201123;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class BooklistActivity extends AppCompatActivity{

    FirebaseDatabase mPostReference = FirebaseDatabase.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email = user.getEmail();
    String[] user_data = email.split("@|\\.");

    String category ="";
    Button btn_Insert;
    ArrayAdapter<String> arrayAdapter;

   // ArrayList<String> category = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("이메일",email);//Good
        email = user_data[0] + "-" + user_data[1] + "-" + user_data[2];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        btn_Insert = (Button) findViewById(R.id.btn_insert);
        //mPostReference = FirebaseDatabase.getInstance().getReference();

        final DatabaseReference mletgo = mPostReference.getReference();

        final String[] category_list = {"인문","여행","소설","에세이", "시", "경제경영","교양과학", "예술", "자기계발"};

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,category_list);
        final ListView listView = (ListView) findViewById(R.id.itemList);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(arrayAdapter);


        btn_Insert.setOnClickListener(new View.OnClickListener() { //다음으로 화면 이동
            @Override
            public void onClick(View view) {
                SparseBooleanArray checkedItems = listView.getCheckedItemPositions(); //체크박스로 체크한 셀의 정보를 담고 있는 희소 논리 배열 얻어오기
                int count = arrayAdapter.getCount(); //전체 몇개인지 세기
                Log.d("클릭","" + checkedItems.size());
                if(checkedItems.size()!=0){
                    for(int i=0; i<count; i++){
                        if(checkedItems.get(i)){ //희소 논리 배열의 해당 인덱스가 선택되어 있다면
                            //category.add(""+i) ; //arrayList에 추가하기 category_list[i]
                            category += i +", ";
                            //++index;
                            Log.d("데이터확인", String.valueOf(checkedItems.get(i)));
                        }
                    }
                }

                arrayAdapter.notifyDataSetChanged();
                //postFirebaseDatabase(true);
                //화면 전환 및 정보 전송

                DatabaseReference melt_email = mletgo.child("user_data").child(email);
                melt_email.setValue(category);

            }
        });


        btn_Insert.setEnabled(true);
    }
/*
    public void postFirebaseDatabase(boolean add){
        //Log.d("배열값",category.get(0)); Good
        //Log.d("배열값",category.get(1));
        mPostReference = FirebaseDatabase.getInstance().getReference();
        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add){
            FirebasePost post = new FirebasePost(email, category);
            postValues = post.toMap();
        }
        childUpdates.put("/user_data/" + email, postValues);
        //mPostReference.setValue(childUpdates);
        mPostReference.updateChildren(childUpdates);
    }
*/

}
