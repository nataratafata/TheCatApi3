package com.example.sherdonbrown.thecatapi.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.sherdonbrown.thecatapi.DataAdapter.CatAdapter;
import com.example.sherdonbrown.thecatapi.MainActivity;
import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;
import com.example.sherdonbrown.thecatapi.Presenter.contract;
import com.example.sherdonbrown.thecatapi.Presenter.presenter;
import com.example.sherdonbrown.thecatapi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.sherdonbrown.thecatapi.MainActivity.ListPresenter;

public class CatFragment extends Fragment implements AdapterView.OnItemSelectedListener, contract.View_Cat{

    private CatAdapter mAdapter;
    private RecyclerView mRecyclerView;
    ArrayAdapter<String> adpt;
    ArrayAdapter<String> adptLimit;
    public SwipeRefreshLayout mySwipeRefresh;
    //spinner
    ArrayList<String> spinnerArray = new ArrayList<>();
    ArrayList<String> ID = new ArrayList<>();
    //get limit
    ArrayList<String> limitArray = new ArrayList<>();
    HashMap<String, String> map = new HashMap<>();
    Objects localDB;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.limit)
    Spinner limit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initializePresenterandCallAPI();
        //Local DB
        localDB = new Objects();

        //Category of api to display
        spinnerArray = new ArrayList<>();
        ID = new ArrayList<>();
        adpt = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinnerArray); //selected item will look like a spinner set from XML
        adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adpt);

        //Limit of api to display
        limitArray = new ArrayList<>();

        adptLimit = new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_spinner_item,
                        limitArray); //selected item will look like a spinner set from XML
        adptLimit.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        limit.setAdapter(adptLimit);

        //hash map for the key and value
        map = new HashMap<>();

        for (int i = 0; i < spinnerArray.size(); i++) {
            map.put(ID.get(i), spinnerArray.get(i));
        }

        spinner.setOnItemSelectedListener(this);
        limit.setOnItemSelectedListener(this);
    }

    public void initializePresenterandCallAPI() {
        ListPresenter = new presenter();
        ListPresenter.onBind(this);
        ListPresenter.initializeRetrofit();
        ListPresenter.getCatFromAPI();
        ListPresenter.getCategoryFromAPI();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ListPresenter.unBind();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.spinner:
                presenter.category_value = ID.get(position);
                ListPresenter.getCatFromAPI();
                break;
            case R.id.limit:
                presenter.category_limit = limitArray.get(position);
                ListPresenter.getCatFromAPI();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void displayProgressDialog() {

    }

    @Override
    public void List(List<Objects> Model) {

        mRecyclerView = getActivity().findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new CatAdapter(Model);
        mRecyclerView.setAdapter(mAdapter);
        mySwipeRefresh.setRefreshing(false);
    }

    @Override
    public void dismissProgressDialog() {

    }

    public void populateCategoryList(List<Objects_Conteg> list){

        for (Objects_Conteg category:
                list) {
            //iterate

            ID.add(category.getId().toString());
            spinnerArray.add(category.getName());


        }
        limitArray.add("1");
        limitArray.add("3");
        limitArray.add("5");
        limitArray.add("10");
        limitArray.add("15");
        limitArray.add("25");
        limitArray.add("50");
        adpt.notifyDataSetChanged();
        adptLimit.notifyDataSetChanged();

    }

}
