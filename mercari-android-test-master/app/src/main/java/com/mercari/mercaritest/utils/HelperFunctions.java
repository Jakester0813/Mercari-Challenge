package com.mercari.mercaritest.utils;

import android.app.Activity;
import android.content.Context;

import com.mercari.mercaritest.data.model.HomeResponse;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jake on 5/27/2017.
 */

public class HelperFunctions {
    private static HelperFunctions instance = null;
    protected  HelperFunctions(){

    }

    public static HelperFunctions getInstance(){
        if (instance == null){
            instance = new HelperFunctions();
        }
        return instance;
    }

    public String getStringFromDataJSON(Context context){
        String json = null;
        try {
            InputStream is = context.getAssets().open("all.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
