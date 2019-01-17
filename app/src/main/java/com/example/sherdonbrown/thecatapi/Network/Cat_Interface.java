package com.example.sherdonbrown.thecatapi.Network;

//import java.util.Objects;


//import rx.Observable;

//this is an interactor
import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;

import java.util.List;

import rx.Observable;

public interface Cat_Interface {
   // Observable<Objects> getCatList();
   // Observable<List<Objects>> getCatList();
    Observable<Objects> getListParams();

}
