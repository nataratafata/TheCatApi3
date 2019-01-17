package com.example.sherdonbrown.thecatapi;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Canvas;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sherdonbrown.thecatapi.DataAdapter.CatAdapter;
import com.example.sherdonbrown.thecatapi.ModelData.Items;
import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;
import com.example.sherdonbrown.thecatapi.Network.Cat_Interface;
import com.example.sherdonbrown.thecatapi.Network.Connection_Service;
import com.example.sherdonbrown.thecatapi.Presenter.contract;
import com.example.sherdonbrown.thecatapi.Presenter.presenter;
import com.example.sherdonbrown.thecatapi.ModelData.Objects;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

//import java.util.Objects;

public class MainActivity extends AppCompatActivity implements contract.View_Cat/*SwipeRefreshLayout.OnRefreshListener */{

    private static final String TAG_1 = MainActivity.class.getSimpleName();
    private presenter ListPresenter;
    private Cat_Interface Interacter;
    private CatAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Spinner spinner;

    public SwipeRefreshLayout mySwipeRefresh;
    ArrayList<String> spinnerArray = new ArrayList<String>();


    @Override
    public void displayProgressDialog() {

    }



    @Override
    public void List(Objects Model) {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new CatAdapter(Model);
        mRecyclerView.setAdapter(mAdapter);
        mySwipeRefresh.setRefreshing(false);
    }

   // @Override
    //public void List(Objects Model) {



   // }

    //public void intentFunction() {
     //   Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
      //  Intent i = new Intent(this, MainActivity.class);
      //  startActivity(i);
    //}

    @Override
    public void dismissProgressDialog() {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mySwipeRefresh = findViewById(R.id.swipe_refresh);
//        mySwipeRefresh.setColorSchemeResources(R.color.oscuro_app);
//        mySwipeRefresh.setProgressBackgroundColorSchemeResource(R.color.MOVIE_APP);
//        mySwipeRefresh.setOnRefreshListener(this);



        //String selectQuery =
       // Cursor cursor = Items.
      //  CatAdapter rest = new CatAdapter();
//        spinnerArray.add("HATS");
//        spinnerArray.add("CLOTHS");
//        spinnerArray.add("SO");
//        spinnerArray.add("HATS");
        //todo call the presenter to get retrofit categories api

      /*  for (Objects category :
                Objects) {
            spinnerArray.add(category.toString());
        }
        while()
        {
            spinnerArray.add();
        }*/

        initializePresenterandCallAPI();
        spinner = findViewById(R.id.spinner);
        spinnerArray = new ArrayList<>();

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,spinnerArray.get(position),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //spinner.setOnItemSelectedListener(this);


       // populateCategoryList();

       /* Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> items=getCategories("categories.json");
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.txt, items);
        spinner.setAdapter(adapter);
*/
        //Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
     //   ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
      //          android.R.layout.simple_list_item_1, )
        //intentFunction();


    }





    /*public ArrayList<String> getCategories(String fileName){
        JSONArray jsonArray = null;
        ArrayList<String> cList = new ArrayList<String>();
        try{
            InputStream is = getResources().getAssets().open(fileName);
            int size = is.available();
            byte[] data=new byte[size];
            is.read(data);
            is.close();
            String json = new String(data, "UTF-8");
            jsonArray=new JSONArray(json);
            if(jsonArray != null)
            {
                for(int i = 0; i <jsonArray.length(); i++)
                {
                    cList.add(jsonArray.getJSONObject(i).getString("cname"));
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException je) {
            je.printStackTrace();
        }
        return cList;
    }
*/

    public void initializePresenterandCallAPI(){
        Interacter = new Connection_Service();
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

//    @Override
//    public void onRefresh() {
//        initializePresenterandCallAPI();
//    }

    public void populateCategoryList(List<Objects_Conteg> list){

        for (Objects_Conteg category:
             list) {
            //iterate

            //spinnerArray.add(category.getId().toString());
            spinnerArray.add(category.getName());

        }
    }
}
