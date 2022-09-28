package com.example.assignmentibm.utils;

public class Consts {

    private static Consts mInstance;

    public synchronized static Consts getInstance() {
        if (mInstance == null)
            mInstance = new Consts();
        return mInstance;
    }

    public static final String BASE_URL = "https://random-data-api.com/api/";
}
