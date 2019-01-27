package com.example.sherdonbrown.thecatapi.DataAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class favorite extends RecyclerView.Adapter<favorite.ViewHolder>{

    //public static ArrayList<Objects> catFavorite = new ArrayList<>();
///empty constructor


    //favorite
   // Objects localDB;
    public favorite() {
        Log.e("Poe", "Hit in the adapter " + CatAdapter.catFavorite.size());

    }

    @NonNull
    @Override
    public favorite.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movies_fragment_container,viewGroup,false);
        return new favorite.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String url = CatAdapter.catFavorite.get(i).getUrl();
        Picasso.get().load(url)
                .resize(75, 100).centerCrop().into(viewHolder.CatPoster);
    }




    @Override
    public int getItemCount() {
        return CatAdapter.catFavorite.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView breed, categorie;
        private ImageView CatPoster;

        public ViewHolder(View itemView) {
            super(itemView);


            CatPoster = itemView.findViewById(R.id.cat_poster);
        }
    }

}
