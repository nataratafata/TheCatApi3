package com.example.sherdonbrown.thecatapi.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sherdonbrown.thecatapi.DataAdapter.favorite;
import com.example.sherdonbrown.thecatapi.R;


public class favoriteFragment extends Fragment {

    public RecyclerView favButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorite_image, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        favButton = getActivity().findViewById(R.id.favoriteCat);
        favButton.setLayoutManager(new GridLayoutManager(getActivity(),3));
        favButton.setAdapter(new favorite());

        Log.e("Poe", "Hit in the fav");
    }
}
