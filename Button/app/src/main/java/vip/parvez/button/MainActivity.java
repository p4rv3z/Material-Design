package vip.parvez.button;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnGeneral,btnFlat;
    FloatingActionButton btnFloating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGeneral = findViewById(R.id.btn_general);
        btnFlat = findViewById(R.id.btn_flat);
        btnFloating = findViewById(R.id.btn_floating);

        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "General Button Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        btnFlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Flat Button Clicked.", Toast.LENGTH_SHORT).show();
            }
        });
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Floating Button Clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
