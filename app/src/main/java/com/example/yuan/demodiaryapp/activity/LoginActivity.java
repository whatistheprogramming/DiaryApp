package com.example.yuan.demodiaryapp.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yuan.demodiaryapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    //用户名和密码
    private EditText userName;
    private EditText userPassword;
    //登入和注册按钮
    private Button loginButton;
    private Button registerButton;
    //缓存
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //设置标题
        setTitle("登入");

        //初始化控件
        initView();
        //初始化数据
        initData();




    }

    private void initData()
    {
        String name = sharedPreferences.getString("name", "");
        if (!"".equals(name))
        {
            userName.setText(name);
            userPassword.setFocusable(true);
            userPassword.setFocusableInTouchMode(true);
            userPassword.requestFocus();
        }
    }

    private void initView()
    {
        userName = (EditText) findViewById(R.id.username);
        userPassword = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.btn_login);
        registerButton = (Button) findViewById(R.id.btn_register);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v)
    {
        //创建一个SharedPreferences.Editor接口对象，user表示要写入的xml文件名
        SharedPreferences.Editor editor = getSharedPreferences("user",MODE_PRIVATE).edit();

        switch (v.getId())
        {
            //登入
            case R.id.btn_login:
                String loginName = userName.getText().toString();
                String loginPassword = userPassword.getText().toString();
                if ("".equals(loginName) || "".equals(loginPassword))
                {
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else if (sharedPreferences.getString("name", "").equals(loginName) && sharedPreferences.getString("password", "").equals(loginPassword))
                {
                    Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(this, "您输入的用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }
                break;
            //注册
            case R.id.btn_register:
                registerDialog();
                break;
            default:
                break;
        }
    }

    /**
     * 注册对话框
     */
    private void registerDialog()
    {
        //创建对话框
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        //设置外部不可编辑
        dialogBuilder.setCancelable(false);
        //设置对话框标题
        dialogBuilder.setTitle("注册");
        //创建对话框布局
        LayoutInflater inflater = LayoutInflater.from(LoginActivity.this);
        View view = inflater.inflate(R.layout.activity_register, null);
        final EditText registerName = (EditText) view.findViewById(R.id.register_name);
        final EditText registerPassword = (EditText) view.findViewById(R.id.register_password);




        dialogBuilder.setView(view);
        //设置取消按钮
        dialogBuilder.setNegativeButton("取消", null);
        //设置完成按钮
        dialogBuilder.setPositiveButton("完成", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String name = registerName.getText().toString();
                String password = registerPassword.getText().toString();
                if ("".equals(name) || "".equals(password))
                {
                    Toast.makeText(LoginActivity.this, "注册失败，用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //将注册成功的用户名和密码存入应用缓存
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", name);
                    editor.putString("password", password);
                    editor.commit();
                    userName.setText(name);
                    userPassword.setText("");
                    //密码框获取焦点
                    userPassword.setFocusable(true);
                    userPassword.setFocusableInTouchMode(true);
                    userPassword.requestFocus();

                    Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //记住要调用dialog的show()方法让它显示,先创建
        dialogBuilder.create().show();

    }
}
