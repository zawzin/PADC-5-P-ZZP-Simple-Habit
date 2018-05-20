package xyz.zzp.simplehabit.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;
    private List<String> tabTitleList;
    public ItemAdapter(FragmentManager fm){
        super(fm);
        mFragmentList = new ArrayList<>();
        tabTitleList = new ArrayList<>();
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addTab(String tabLabel, Fragment fragment){
        tabTitleList.add(tabLabel);
        mFragmentList.add(fragment);
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
}
