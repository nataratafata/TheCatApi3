package com.example.sherdonbrown.thecatapi.Presenter;

import android.util.Log;

import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;
import com.example.sherdonbrown.thecatapi.Network.Cat_Interface;

import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.Network.Category_Interface;
import com.example.sherdonbrown.thecatapi.Network.Connection_Service;
import com.example.sherdonbrown.thecatapi.Network.Connection_Service_category;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class presenter implements contract.Presenter_Cat{

    private contract.View_Cat iView_List;
    public Cat_Interface iCat_interacter;
    private Category_Interface iCategory_interacter;
    public static String category_value;
    public static String category_limit;
    public static int category_page;

    public presenter(){}
    public presenter(Cat_Interface iCat_interacter){
        this.iCat_interacter = iCat_interacter;
    }

    public presenter(Category_Interface iCategory_interacter, int i)
    {
        this.iCategory_interacter = iCategory_interacter;
    }
    @Override
    public void onBind(contract.View_Cat view_cat) {
        this.iView_List = view_cat;
    }
    //initializeRetrofit

    @Override
    public void getCatFromAPI() {
        iCat_interacter.getListParams(category_value, category_limit, category_page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Objects>>() {
                    @Override
                    public void onCompleted() {
                        iView_List.displayProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_List.dismissProgressDialog();
                        Log.d("Test", "ON ERROR");
                    }

                   @Override
                   public void onNext(List<Objects> obj) {

                        iView_List.List(obj);
                   }



                });

    }
public static void getValueFromSpinner(String id){
        Log.d(id, " ID FOR CHANGING THE IMAGE LOG");
        category_value = id;

}

    @Override
    public void getCategoryFromAPI() {
        iCategory_interacter.getCategories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Objects_Conteg>>() {
                    @Override
                    public void onCompleted() {
                        iView_List.displayProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_List.dismissProgressDialog();
                    }

                    @Override
                    public void onNext(List<Objects_Conteg> objects_conteg) {
                        iView_List.populateCategoryList(objects_conteg);
                    }



                });

    }
//method to point category api getCategories
    //on nexst call the method from the main acdtiiv y to populate inflatge
    @Override
    public void unBind() {
        this.iView_List = null;
    }

    @Override
    public void initializeRetrofit() {
        iCat_interacter = new Connection_Service();
        iCategory_interacter = new Connection_Service_category();

    }

}
