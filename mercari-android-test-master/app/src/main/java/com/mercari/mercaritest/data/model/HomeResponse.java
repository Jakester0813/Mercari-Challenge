package com.mercari.mercaritest.data.model;


import com.google.gson.JsonParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeResponse {
    private static HomeResponse instance = null;
    protected  HomeResponse(){

    }

    public static HomeResponse getInstance(){
        if (instance == null){
            instance = new HomeResponse();
        }
        return instance;
    }


    public Response parseResponse(String result) throws JSONException {

        Response response;
        JSONArray dataArray;
        JSONObject responseObject;
        String resultString;
        Item item;
        ArrayList<Item> itemArray;

        responseObject = new JSONObject(result);

        resultString = responseObject.getString("result");
        dataArray = responseObject.getJSONArray("data");

        itemArray = new ArrayList<Item>();
        for (int i = 0; i < dataArray.length(); i++){
            item = parseItem(dataArray.getJSONObject(i));
            itemArray.add(item);
        }

        response = new Response(resultString, itemArray);

        return response;
    }

    private Item parseItem(JSONObject object) throws JSONException{
        Item item;
        String id, name, photo, status;
        long likes, comments, price;

        id = object.getString("id");
        name = object.getString("name");
        status = object.getString("status");
        likes = object.getLong("num_likes");
        comments = object.getLong("num_comments");
        price = object.getLong("price");
        photo = object.getString("photo");
        item = new Item(id, name,  likes, comments, price, photo, status);

        return item;
    }
}
