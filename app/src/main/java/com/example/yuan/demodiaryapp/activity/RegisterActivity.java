package com.example.yuan.demodiaryapp.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yuan.demodiaryapp.R;

public class RegisterActivity extends AppCompatActivity
{

    private Button registerButton;
    private EditText registerName;
    private EditText registerPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("注册");
        registerButton = (Button) findViewById(R.id.btn_register);
        registerName = (EditText) findViewById(R.id.register_name);
        registerPassword = (EditText) findViewById(R.id.register_password);
        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //创建一个SharedPreferences.Editor接口对象，user表示要写入的xml文件名
                SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();

                String name = registerName.getText().toString();
                String password = registerPassword.getText().toString();
                if ("".equals(name) || "".equals(password))
                {
                    Toast.makeText(RegisterActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //将获取的值放入文件
                    editor.putString("name", name);
                    editor.putString("address", password);
                    //提交
                    editor.commit();
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
}
