package vip.parvez.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.favourite_places:
                        Toast.makeText(getApplicationContext(), "Favourite", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.recent_places:
                        Toast.makeText(getApplicationContext(), "Recent", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nearby_places:
                        Toast.makeText(getApplicationContext(), "Nearby", Toast.LENGTH_LONG).show();
                        break;

                }
                return false;
            }
        });
    }
}
