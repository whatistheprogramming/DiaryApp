package com.example.yuan.demodiaryapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.yuan.demodiaryapp.R;

/**
 * Created by yuan on 2017/11/12.
 */

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 当按下Back键，会执行onBackPressed里的代码
     */
    private long firstTime = 0;

    @Override
    public void onBackPressed()
    {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime >= 2000)
        {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        }
        else
        {
            finish();
        }
    }
}
