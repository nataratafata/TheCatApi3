package com.example.sherdonbrown.thecatapi.Network;


//this is an interactor
import com.example.sherdonbrown.thecatapi.ModelData.Objects;

import java.util.List;

import rx.Observable;

public interface Cat_Interface {
   Observable<List<Objects>> getListParams(String id, String limit, int page);
}
