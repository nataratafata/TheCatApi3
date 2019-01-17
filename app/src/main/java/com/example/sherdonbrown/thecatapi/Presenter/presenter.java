package com.example.sherdonbrown.thecatapi.Presenter;

import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;
import com.example.sherdonbrown.thecatapi.Network.Cat_Interface;

//import java.util.Objects;
import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.Network.Category_Interface;
import com.example.sherdonbrown.thecatapi.Network.Connection_Service;
import com.example.sherdonbrown.thecatapi.Network.Connection_Service_category;

import java.util.List;
import java.util.Locale;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class presenter implements contract.Presenter_Cat{

    private contract.View_Cat iView_List;
    private Cat_Interface iCat_interacter;
    private Category_Interface iCategory_interacter;

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
        iCat_interacter.getListParams().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Objects>() {
                    @Override
                    public void onCompleted() {
                        iView_List.displayProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView_List.dismissProgressDialog();
                    }

                   // @Override
                 //   public void onNext(Objects obj) {
                  //      iView_List.List(obj);
                //    }
                   @Override
                   public void onNext(Objects obj) {

                        iView_List.List(obj);
                   }



                });

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
