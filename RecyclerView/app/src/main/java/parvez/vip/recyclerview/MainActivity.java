package parvez.vip.recyclerview;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView movieList;
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieList = findViewById(R.id.recycler_view);
        movies = new ArrayList<>();
        movies.add(new Movie("Tere Naam"));
        movies.add(new Movie("Wanted"));
        movies.add(new Movie("Gool Maal"));
        movies.add(new Movie("Tom and Jerry"));
        movies.add(new Movie("Titanic"));

        int ot = getResources().getConfiguration().orientation;
        switch (ot) {

            case Configuration.ORIENTATION_LANDSCAPE:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                movieList.setLayoutManager(gridLayoutManager);
                Log.d("my orient", "ORIENTATION_LANDSCAPE");
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                movieList.setLayoutManager(linearLayoutManager);
                Log.d("my orient", "ORIENTATION_PORTRAIT");
                break;

            case Configuration.ORIENTATION_SQUARE:
                gridLayoutManager = new GridLayoutManager(this, 2);
                movieList.setLayoutManager(gridLayoutManager);
                Log.d("my orient", "ORIENTATION_SQUARE");
                break;
            case Configuration.ORIENTATION_UNDEFINED:
                linearLayoutManager = new LinearLayoutManager(this);
                movieList.setLayoutManager(linearLayoutManager);
                Log.d("my orient", "ORIENTATION_UNDEFINED");
                break;
            default:
                linearLayoutManager = new LinearLayoutManager(this);
                movieList.setLayoutManager(linearLayoutManager);
                Log.d("my orient", "default val");
                break;
        }
        movieList.setHasFixedSize(true);
        movieList.setAdapter(new RecyclerAdapter(movies));
        Toast.makeText(getApplicationContext(), getResources().getConfiguration().orientation + " ", Toast.LENGTH_LONG).show();
        
    }

}
