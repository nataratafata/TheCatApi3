package com.example.sherdonbrown.thecatapi.ModelData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("breeds")
    @Expose
    private String breeds;
    @SerializedName("categories")
    @Expose
    private String categories;
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("poster")
    @Expose
    private String poster;

    public String getBreeds() {
        return breeds;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }


    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
