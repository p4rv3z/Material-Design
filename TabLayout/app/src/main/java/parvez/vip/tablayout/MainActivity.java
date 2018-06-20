package parvez.vip.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    List<Fragment> fragments;
    List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        fragments = new ArrayList<>();
        titles = new ArrayList<>();

        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        fragments.add(new FiveFragment());
        fragments.add(new SixFragment());

        titles.add("ITEM ONE");
        titles.add("");
        titles.add("ITEM THREE");
        titles.add("FOUR");
        titles.add("ITEM FIVE");
        titles.add("ITEM SIX");

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles);

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).setIcon(R.drawable.android);
        tabLayout.getTabAt(3).setIcon(R.drawable.android);

    }
}
