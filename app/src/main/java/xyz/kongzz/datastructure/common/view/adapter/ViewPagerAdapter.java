package xyz.kongzz.datastructure.common.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import xyz.kongzz.datastructure.common.view.fragment.DiscoverFragment;
import xyz.kongzz.datastructure.common.view.fragment.HomeFragment;
import xyz.kongzz.datastructure.common.view.fragment.MineFragment;

/**
 * 作者:Kong
 * 时间:2018/7/2515:55
 * 描述:这是 ViewPagerAdapter
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] mFragments = new Fragment[]{new HomeFragment(), new DiscoverFragment(), new MineFragment()};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
