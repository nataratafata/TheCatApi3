package com.example.sherdonbrown.thecatapi.DataAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
//import java.util.Objects;
import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder>{

    private Objects mCatModel;

    public CatAdapter(Objects list) {
        mCatModel = list;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView breed, categorie;
        private ImageView CatPoster;

        public ViewHolder(View itemView) {
            super(itemView);

           // breed = itemView.findViewById(R.id.breeds);
            categorie = itemView.findViewById(R.id.categories);
            CatPoster = itemView.findViewById(R.id.cat_poster);

        }
    }

   // public CatAdapter (Objects List){
    //    mCatModel = List;
    //}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movies_fragment_container,viewGroup,false);
        return new ViewHolder(view);
    }






    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        //category


        //Items
        holder.breed.setText(mCatModel.getData().get(i).getBreeds());

        holder.categorie.setText(mCatModel.getData().get(i).getCategories());
        //holder.genre.getText();

        String url = mCatModel.getData().get(i).getPoster();
        Picasso.get().load(url)
                .resize(75, 100).centerCrop().into(holder.CatPoster);
    }
    //
    @Override
    public int getItemCount() {
        return mCatModel.getData().size();
    }
}
