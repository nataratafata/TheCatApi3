package com.example.sherdonbrown.thecatapi.ModelData;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Objects {
    @SerializedName("data")
    @Expose
    private List<Items> data = null;

    private List<Objects_Conteg> data_Cate = null;

    public List<Items> getData() {
        return data;
    }

    public List<Objects_Conteg> getData_Cate() {
        return data_Cate;
    }

    public void setData(List<Items> data) {
        this.data = data;
    }
    public void setData_Cate(List<Objects_Conteg> data_Cate) {
        this.data_Cate = data_Cate;
    }

}
