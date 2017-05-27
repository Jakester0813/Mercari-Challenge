package com.mercari.mercaritest.managers;

import com.mercari.mercaritest.data.model.HomeResponse;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.data.model.Response;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Jake on 5/27/2017.
 */

public class ItemManager {

    private static ItemManager instance = null;
    protected  ItemManager(){

    }

    public static ItemManager getInstance(){
        if (instance == null){
            instance = new ItemManager();
        }
        return instance;
    }


    public List<Item> getItemLists(String data) throws JSONException{

        List<Item> items;

        Response response = HomeResponse.getInstance().parseResponse(data);

        items = response.data;

        return items;
    }
}
