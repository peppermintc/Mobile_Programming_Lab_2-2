package org.androidtown.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;  //텍스트, 버튼 선언
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = findViewById(R.id.textView); //레퍼런스
        goBtn = findViewById(R.id.btn_go);
        backBtn = findViewById(R.id.btn_back);

        final Intent passedIntent = getIntent();    //인텐트 설정
        final String passedUrl = passedIntent.getStringExtra("Url");    //스트링 불러오기
        textView.setText(passedUrl);

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!passedUrl.matches("")) {    //URL 입력란이 공란이 아니라면 브라우저 실행
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }else{  //URL 입력란이 공란이라면 토스트 메시지 출력
                    Toast.makeText(NewActivity.this,"주소를 다시 입력해주세요.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //back 버튼 클릭시 토스트 메시지 출력하고 액티비티 종료
                Toast.makeText(NewActivity.this,"뒤로가기버튼을 눌렀습니다.",
                        Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }


}
