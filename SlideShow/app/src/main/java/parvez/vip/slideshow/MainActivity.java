package parvez.vip.slideshow;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    SlideShowAdapter slideShowAdapter;
    CircleIndicator circleIndicator;
    int images[] = {R.drawable.item_1, R.drawable.item_2, R.drawable.item_3, R.drawable.item_4, R.drawable.item_5};

    Handler handler;
    Timer timer;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        circleIndicator = findViewById(R.id.circular);
        slideShowAdapter = new SlideShowAdapter(this, images);

        viewPager.setAdapter(slideShowAdapter);

        circleIndicator.setViewPager(viewPager);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                int i = viewPager.getCurrentItem();
                i++;
                if (i == slideShowAdapter.getCount()) {
                    i = 0;
                }
                viewPager.setCurrentItem(i, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 5000, 5000);
    }
}
