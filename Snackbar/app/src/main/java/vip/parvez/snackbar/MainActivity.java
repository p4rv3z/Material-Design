package vip.parvez.snackbar;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    View view;
    Snackbar snackbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.main_activity);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar = Snackbar.make(v, "Hi! This is FAB.\nHi! This is Parvez.", Snackbar.LENGTH_INDEFINITE);
                snackbar.setDuration(8000);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        });
    }

    public void generalSnackBar(View v) {
        snackbar = Snackbar.make(view, "Hi! This is parvez.", Snackbar.LENGTH_LONG);
        //snackbar.setDuration(1000);
        snackbar.show();
    }

    public void cusSnackBar(View view) {
        snackbar = Snackbar.make(view, "Hi! This is FAB.\nHi! This is Parvez.", Snackbar.LENGTH_INDEFINITE);
        snackbar.setDuration(8000);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        View v = snackbar.getView();
        v.setBackgroundColor(getResources().getColor(R.color.colorSnackbarBackground));

        TextView tv = v.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(getResources().getColor(R.color.colorSnackbarText));

        TextView tvAction = v.findViewById(android.support.design.R.id.snackbar_action);
        tvAction.setTextColor(getResources().getColor(R.color.colorSnackbarAction));
        snackbar.show();
    }
}
