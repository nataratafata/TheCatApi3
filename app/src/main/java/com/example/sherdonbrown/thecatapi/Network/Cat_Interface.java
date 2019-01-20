package com.example.sherdonbrown.thecatapi.Network;

//import java.util.Objects;


//import rx.Observable;

//this is an interactor
import com.example.sherdonbrown.thecatapi.ModelData.Objects;

import java.util.List;

import rx.Observable;

public interface Cat_Interface {
   // Observable<Objects> getCatList();
   // Observable<List<Objects>> getCatList();
   // Observable<List<Objects>> getListParams();
   Observable<List<Objects>> getListParams(String id);
}
