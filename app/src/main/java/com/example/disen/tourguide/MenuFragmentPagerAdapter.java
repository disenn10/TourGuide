package com.example.disen.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

/**
 * Created by disen on 6/19/2017.
 */

public class MenuFragmentPagerAdapter extends FragmentPagerAdapter {
    Context mcontext;
    public MenuFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mcontext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AboutFragment();
            case 1:
                return new TopSightsFragment();
            case 2:
                return new DictionaryFragment();
            case 3:
                return new FunFactsFragment();
            default:
                return new Restaurants();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mcontext.getString(R.string.about);
            case 1:
                return mcontext.getString(R.string.topSights);
            case 2:
                return mcontext.getString(R.string.dictionary);
            case 3:
                return mcontext.getString(R.string.facts);
            default:
                return mcontext.getString(R.string.restaurants);
        }
    }
}
