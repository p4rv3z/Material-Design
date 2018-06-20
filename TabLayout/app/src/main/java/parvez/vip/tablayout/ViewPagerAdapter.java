package parvez.vip.tablayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    List<String> fragmentTitleList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> fragmentTitleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.fragmentTitleList = fragmentTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return (fragmentList == null) ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return (fragmentList == null) ? null : fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
