package com.example.yuan.demodiaryapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * ViewPager的适配器
 * Created by yuan on 2017/11/12.
 */

public class FragmentAdapter extends FragmentPagerAdapter
{

    private List<Fragment> fragmentList;
    private List<String> tabList;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabList)
    {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabList = tabList;
    }


    @Override
    public Fragment getItem(int position)
    {
        return fragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return tabList.get(position);
    }
}
