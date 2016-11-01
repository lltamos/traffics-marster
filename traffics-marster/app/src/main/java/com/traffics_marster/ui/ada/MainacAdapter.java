package com.traffics_marster.ui.ada;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.traffics_marster.ui.frg.ChooseFragment;
import com.traffics_marster.ui.frg.LayerFragment;
import com.traffics_marster.ui.frg.ToolFragment;

import java.util.ArrayList;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class MainacAdapter extends FragmentStatePagerAdapter {
    public ArrayList<Fragment> mArr;

    public MainacAdapter(FragmentManager fm) {
        super(fm);
        mArr = new ArrayList();
        mArr.add(new ToolFragment());
        mArr.add(new LayerFragment());
        mArr.add(new ChooseFragment());
        mArr.add(new ChooseFragment());
        mArr.add(new ChooseFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mArr.get(position);
    }

    @Override
    public int getCount() {
        return mArr.size();
    }
}
