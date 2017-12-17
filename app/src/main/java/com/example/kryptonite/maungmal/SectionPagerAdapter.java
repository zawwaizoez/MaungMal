package com.example.kryptonite.maungmal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Kryptonite on 12/17/2017.
 */

class SectionPagerAdapter extends FragmentPagerAdapter{

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:

                RequestsFragment requestsFragment = new RequestsFragment();
                return requestsFragment;


            case 1:
                ChatFragment  chatFragment = new ChatFragment();
                return  chatFragment;
            case 2:
                FriendsFragment  friendsFragment = new FriendsFragment();
                return  friendsFragment;
                default:
                    return null;
        }




    }

    @Override
    public int getCount() {
        return 3;
    }
}
