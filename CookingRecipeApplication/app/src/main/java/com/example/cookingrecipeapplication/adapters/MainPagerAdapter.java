package com.example.cookingrecipeapplication.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cookingrecipeapplication.fragments.AmericanFragment;
import com.example.cookingrecipeapplication.fragments.AsianFragment;
import com.example.cookingrecipeapplication.fragments.EuropeanFragment;
import com.example.cookingrecipeapplication.fragments.MediterraneanFragment;
import com.example.cookingrecipeapplication.fragments.VeganFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private static final int TAB_COUNT = 5;
    private String[] tabTitles = {"אמריקן", "ירקות", "אוכל סיני", "ים תיכוני", "ארופאי"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;
        switch (position) {
            case 0:
                frag = AmericanFragment.newInstance(tabTitles[position]);
                break;
            case 1:
                frag = VeganFragment.newInstance(tabTitles[position]);
                break;
            case 2:
                frag = AsianFragment.newInstance(tabTitles[position]);
                break;
            case 3:
                frag = MediterraneanFragment.newInstance(tabTitles[position]);
                break;
            case 4:
                frag = EuropeanFragment.newInstance(tabTitles[position]);
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
