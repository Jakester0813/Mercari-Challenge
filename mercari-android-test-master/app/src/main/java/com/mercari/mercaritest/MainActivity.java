package com.mercari.mercaritest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.managers.ItemManager;
import com.mercari.mercaritest.utils.HelperFunctions;

import org.json.JSONException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String response;
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        response = HelperFunctions.getInstance().getStringFromDataJSON(this);

        try {
            items = ItemManager.getInstance().getItemLists(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response = "done";
    }
}
