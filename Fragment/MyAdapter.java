package com.radhey.myapplication.ViewPagerEx;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {
    public MyAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0 :
                Fragment1 one = new Fragment1();
                return one;
            case 1 :
                Fragment2 two = new Fragment2();
                return two;
            case 2 : Fragment3 three = new Fragment3();
            return three;
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
