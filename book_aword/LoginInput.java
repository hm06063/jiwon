package com.example.book_aword;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginInput extends AppCompatActivity implements View.OnClickListener{


    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonSignin;
    TextView textviewSignup;
    TextView textviewFindPassword;
    ProgressDialog progressDialog;
    //define firebase object
    //FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logininput);
        Intent it = getIntent();

        //firebaseAuth = FirebaseAuth.getInstance();

        /*if(firebaseAuth.getCurrentUser() != null){
            //이미 로그인 되었다면 이 액티비티를 종료함
            //finish();
            //그리고 profile 액티비티를 연다.
            //startActivity(new Intent(getApplicationContext(), Login.class)); //추가해 줄 ProfileActivity


        }*/

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textviewSignup= (TextView) findViewById(R.id.textViewSignup);
        textviewFindPassword = (TextView) findViewById(R.id.textViewFindpassword);
        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        progressDialog = new ProgressDialog(this);

        //button click event
        buttonSignin.setOnClickListener(this);
        textviewSignup.setOnClickListener(this);
        textviewFindPassword.setOnClickListener(this);
    }

    //firebase userLogin method
    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "E-mail을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        else {

            progressDialog.setMessage("로그인중입니다. 잠시만 기다려 주세요.");
            progressDialog.show();
            finish();
            startActivity(new Intent(getApplicationContext(), Profile.class));
        }

        //logging in the user
        /*final Task<AuthResult> authResultTask = firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Login.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "로그인 실패!", Toast.LENGTH_LONG).show();
                            textviewMessage.setText("로그인 실패 유형\n - password가 맞지 않습니다.\n -서버에러");
                        }
                    }
                });*/
    }



    @Override
    public void onClick(View view) {
        if(view == buttonSignin) {//로그인 버튼 눌렀을 때
            userLogin();
        }
        if(view == textviewSignup) {//회원가입 버튼 눌렀을 때
            //finish();
            startActivity(new Intent(this, Join.class));
        }
        if(view == textviewFindPassword) {
            //finish();
            //startActivity(new Intent(this, FindActivity.class));
        }
    }


}
