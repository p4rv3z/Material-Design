package vip.parvez.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(getApplicationContext(), "Item 1 selected", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_2:
                Toast.makeText(getApplicationContext(), "Item 2 selected", Toast.LENGTH_LONG).show();

                break;
            case R.id.item_3:
                Toast.makeText(getApplicationContext(), "Item 3 selected", Toast.LENGTH_LONG).show();

                break;

            case R.id.search:
                Toast.makeText(getApplicationContext(), "Search selected", Toast.LENGTH_LONG).show();

                break;

            case R.id.cart:
                Toast.makeText(getApplicationContext(), "Cart selected", Toast.LENGTH_LONG).show();

                break;

            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "Home selected", Toast.LENGTH_LONG).show();
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.item_3).setEnabled(false);
        return true;
    }
}
