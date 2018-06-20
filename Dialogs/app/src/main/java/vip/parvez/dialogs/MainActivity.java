package vip.parvez.dialogs;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generalAlertDialog(View view) {
        AlertDialog alertDialog;
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(this);
        builder.setMessage("Hi! This is a General Alert Dialog");
        alertDialog = builder.create();
        alertDialog.show();

    }

    public void cancelableAlertDialog(View view) {
        AlertDialog alertDialog;
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(this, R.style.ThemeAlertDialog);
        builder.setMessage("Hi! This is a Cancleable Alert Dialog");
        builder.setPositiveButtonIcon(getResources().getDrawable(R.drawable.cancel));
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("DISCARD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }

        );
        alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorAccent));
        Button btn = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    public void confirmationDialog(View view) {
        final String items[] = {"Easy", "Medium", "Hard", "Very Hard"};
        AlertDialog alertDialog;
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(this, R.style.ThemeAlertDialog);
        builder.setTitle("Confirmation Dialog");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    public void circularProgressDialog(View view) {
        ProgressDialog dialog = new ProgressDialog(this, R.style.ThemeAlertDialog);
        dialog.setTitle("Progressing");
        dialog.setMessage("Loading");
        dialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void linearProgressDialog(View view) {
        final ProgressDialog dialog = new ProgressDialog(this, R.style.ThemeAlertDialog);
        dialog.setTitle("Progressing");
        dialog.setMessage("Loading");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setIndeterminate(false);
        dialog.setProgress(0);
        dialog.setMax(100);
        dialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                i += 5;
                if (i <= 100) {
                    dialog.setProgress(i);
                } else {
                    timer.cancel();
                }
                if (i >= 100) {
                    dialog.dismiss();
                }
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 0, 1000);
    }
}
