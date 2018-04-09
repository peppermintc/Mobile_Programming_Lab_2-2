package org.androidtown.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;   //텍스트장, 버튼 선언
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = findViewById(R.id.editText);  //레퍼런스
        nextBtn = findViewById(R.id.btn_next);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //next버튼 동작
                String myUrl = Url.getText().toString();    //텍스트 창으로부터 텍스트 받아 저장
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("Url",myUrl);   //인텐트 생성

                startActivity(intent);  //NewActivity 실행
            }
        });
    }
}
