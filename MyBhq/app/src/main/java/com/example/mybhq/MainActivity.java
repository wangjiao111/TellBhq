package com.example.mybhq;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText et_number;
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but=(Button) findViewById(R.id.button);
        et_number=(EditText) findViewById(R.id.et_number);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=et_number.getText().toString().trim();//获取文本,并去掉空格
                if(TextUtils.isEmpty(number)){
                    Toast.makeText(MainActivity.this,"号码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                //统一资源标识符
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
    }
}
