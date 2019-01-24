package com.example.sherdonbrown.thecatapi.DataAdapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
//import java.util.Objects;

import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder>{

    private List<Objects> mCatModel;


    //favorite
    Objects localDB;
    public CatAdapter(List<Objects> list) {
        mCatModel = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movies_fragment_container,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {


        holder.categorie.setText(mCatModel.get(i).getId());
        holder.CatPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Please work", holder.getAdapterPosition() + "");
            }
        });


        String url = mCatModel.get(i).getUrl();
        Picasso.get().load(url)
                .resize(75, 100).centerCrop().into(holder.CatPoster);


        //ADD FAVORITES

    }
    //
    @Override
    public int getItemCount() {
        return mCatModel.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView breed, categorie;
        private ImageView CatPoster;

        public ViewHolder(View itemView) {
            super(itemView);

            categorie = itemView.findViewById(R.id.categories);
            CatPoster = itemView.findViewById(R.id.cat_poster);
        }
    }
}
