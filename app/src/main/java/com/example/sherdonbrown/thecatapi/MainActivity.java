package com.example.sherdonbrown.thecatapi;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sherdonbrown.thecatapi.DataAdapter.CatAdapter;
import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;
import com.example.sherdonbrown.thecatapi.Network.Cat_Interface;
import com.example.sherdonbrown.thecatapi.Presenter.contract;
import com.example.sherdonbrown.thecatapi.Presenter.presenter;
import com.example.sherdonbrown.thecatapi.ModelData.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Objects;

//import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, contract.View_Cat/*SwipeRefreshLayout.OnRefreshListener */{

    private static final String TAG_1 = MainActivity.class.getSimpleName();
    private presenter ListPresenter;
    private Cat_Interface Interacter;
    private CatAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Spinner spinner;
    ArrayAdapter<String> adpt;
   //->>>>> String spinnerArray[] arr;
    public SwipeRefreshLayout mySwipeRefresh;
    public List<Objects> catList;
    //spinner
    ArrayList<String> spinnerArray = new ArrayList<String>();
    ArrayList<String> ID = new ArrayList<String>();
    HashMap<String,String> map = new HashMap<>();


    @Override
    public void displayProgressDialog() {

    }



    @Override
    public void List(List<Objects> Model) {

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new CatAdapter(Model);
        mRecyclerView.setAdapter(mAdapter);
        mySwipeRefresh.setRefreshing(false);
    }



    @Override
    public void dismissProgressDialog() {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializePresenterandCallAPI();
        spinner = findViewById(R.id.spinner);
        spinnerArray = new ArrayList<>();
        ID = new ArrayList<>();
        adpt = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray); //selected item will look like a spinner set from XML
        adpt.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(adpt);


        //hash map for the key and value
        map = new HashMap<>();

        for(int i = 0; i< spinnerArray.size(); i++) {
            map.put(ID.get(i), spinnerArray.get(i));
        }
        Log.e("FindMe", "The ID size is: " + ID.size());
        Log.e("FindMe", "The Map size is: " + map.size());
        Log.e("FindMe", "The Spinner size is: " + spinnerArray.size());

        spinner.setOnItemSelectedListener(this);
    }

    public void initializePresenterandCallAPI(){
       // Interacter = new Connection_Service();
        ListPresenter = new presenter();
        Log.d(TAG_1, "SETUP PRESENTER");
        ListPresenter.onBind(this);
        ListPresenter.initializeRetrofit();
        ListPresenter.getCatFromAPI();
        ListPresenter.getCategoryFromAPI();
//        mySwipeRefresh.setRefreshing(false);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ListPresenter.unBind();
    }


    public void populateCategoryList(List<Objects_Conteg> list){

        for (Objects_Conteg category:
             list) {
            //iterate

            //spinnerArray.add(category.getId().toString());
            ID.add(category.getId().toString());
            spinnerArray.add(category.getName());
           // ID.indexOf(1);

           // ID.add(category.getId().toString());

        }
        adpt.notifyDataSetChanged();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // presenter.getValueFromSpinner(parent.getItemAtPosition(position).toString());
        // presenter.getValueFromSpinner(parent.getItemAtPosition(position).toString());
        //HashMap cate_id = <int, String>

        Log.e("Pow", spinnerArray.get(position));
        Log.e("Poo", ID.get(position));

        presenter.category_value = ID.get(position);
        ListPresenter.getCatFromAPI();



        //presenter.getValueFromSpinner(ID.toString());
        // presenter.getValueFromSpinner(map.get(ID.get(position)));
        //presenter.getValueFromSpinner(map.get(ID.get(position)));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
