package com.example.andoidbasecourse.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;




}