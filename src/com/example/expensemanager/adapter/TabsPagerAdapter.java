package com.example.expensemanager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.expensemanager.CardsFragment;
import com.example.expensemanager.CashFragment;
import com.example.expensemanager.ReportsFragment;
import com.example.expensemanager.SettingsFragment;


public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new CashFragment();
            case 1:
                // Games fragment activity
                return new CardsFragment();
            case 2:
                // Movies fragment activity
                return new ReportsFragment();

            case 3:
                // Movies fragment activity
                return new SettingsFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 4;
    }

}