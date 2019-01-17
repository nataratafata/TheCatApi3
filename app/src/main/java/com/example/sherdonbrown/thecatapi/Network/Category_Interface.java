package com.example.sherdonbrown.thecatapi.Network;

import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;

import java.util.List;

import rx.Observable;

public interface Category_Interface {
    Observable<List<Objects_Conteg>> getCategories();
}
