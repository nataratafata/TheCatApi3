package com.example.sherdonbrown.thecatapi;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.sherdonbrown.thecatapi.Presenter.presenter;
import com.example.sherdonbrown.thecatapi.fragments.CatFragment;
import com.example.sherdonbrown.thecatapi.fragments.favoriteFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //Value
    public int val = 0;
    BottomNavigationView buttonNavigationView;
    public static presenter ListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNavigationView = findViewById(R.id.bottom_navigation_view);
        buttonNavigationView.setOnNavigationItemSelectedListener(this);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.container, new CatFragment()).commit();

    }

    public boolean onNavigationItemSelected(@NonNull MenuItem items) {
       // favoriteFragment Favorite = new favoriteFragment();

        switch (items.getItemId()) {
            case R.id.navigation_account_back:
                presenter.category_page = val--;
                ListPresenter.getCatFromAPI();
                break;
            case R.id.navigation_account_forward:
                presenter.category_page = val++;
                ListPresenter.getCatFromAPI();
                break;
            case R.id.navigation_account_favorite:
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.container, new favoriteFragment()).addToBackStack(null).commit();

                break;
        }
        return true;
    }

}
