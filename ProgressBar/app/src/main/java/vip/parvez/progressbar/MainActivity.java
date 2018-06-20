package vip.parvez.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar circularProgressBar;
    ProgressBar linearProgressBar;
    ProgressBar linearProgressBar2;

    Handler handler;
    Runnable runnable;
    Timer timer;

    Handler handler2;
    Runnable runnable2;
    Timer timer2;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circularProgressBar = findViewById(R.id.circular_progress_bar);
        linearProgressBar = findViewById(R.id.linear_progress_bar);
        linearProgressBar2 = findViewById(R.id.linear_progress_bar2);

        circularProgressBar.setVisibility(View.VISIBLE);
        linearProgressBar.setVisibility(View.VISIBLE);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                timer.cancel();
                circularProgressBar.setVisibility(View.GONE);
                linearProgressBar.setVisibility(View.GONE);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 8000, 1000);


        // linear progress bar 2
        linearProgressBar2.setVisibility(View.VISIBLE);
        linearProgressBar2.setProgress(0);
        linearProgressBar2.setSecondaryProgress(10);
        linearProgressBar2.setMax(100);
        handler2 = new Handler();
        runnable2 = new Runnable() {
            @Override
            public void run() {
                i += 5;
                if (i <= 100) {
                    linearProgressBar2.setProgress(i);
                    linearProgressBar2.setSecondaryProgress(i + 10);
                } else {
                    timer2.cancel();
                }
                if (i >= 100) {
                    linearProgressBar2.setVisibility(View.GONE);
                }
            }
        };
        timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                handler2.post(runnable2);
            }
        }, 8000, 1000);
    }
}
