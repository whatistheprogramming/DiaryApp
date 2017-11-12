package com.example.yuan.demodiaryapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.yuan.demodiaryapp.R;
import com.example.yuan.demodiaryapp.adapter.FragmentAdapter;
import com.example.yuan.demodiaryapp.fragment.ListDiaryFragment;
import com.example.yuan.demodiaryapp.fragment.PersonFragment;
import com.example.yuan.demodiaryapp.fragment.WriteDiaryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 2017/11/12.
 */

public class MainActivity extends AppCompatActivity
{

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView()
    {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        FragmentManager fragmentManager = getSupportFragmentManager();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new WriteDiaryFragment());
        fragments.add(new ListDiaryFragment());
        fragments.add(new PersonFragment());

        List<String> tabs = new ArrayList<>();
        tabs.add("写日记");
        tabs.add("日记中心");
        tabs.add("个人中心");

        FragmentAdapter fragmentAdapter = new FragmentAdapter(fragmentManager, fragments, tabs);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);



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
