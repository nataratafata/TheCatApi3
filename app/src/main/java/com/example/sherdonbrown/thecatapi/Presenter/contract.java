package com.example.sherdonbrown.thecatapi.Presenter;
import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;

import java.util.List;
//import java.util.Objects;

public class contract {

    public interface View_Cat {

        void displayProgressDialog();
        void List(Objects Model);
        //void List(List<Objects> Model);
        void dismissProgressDialog();


        void populateCategoryList(List<Objects_Conteg> obj);
    }

    public interface Presenter_Cat{

        void onBind(View_Cat view_cat);
        void getCatFromAPI();

        void getCategoryFromAPI();

        void unBind();
        void initializeRetrofit();
    }
}
