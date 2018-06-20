package parvez.vip.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    List<Movie> movies;

    public RecyclerAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView title;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
