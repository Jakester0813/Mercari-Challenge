package com.mercari.mercaritest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mercari.mercaritest.adapters.ItemAdapter;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.managers.ItemManager;
import com.mercari.mercaritest.utils.HelperFunctions;

import org.json.JSONException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String mResponseString;
    List<Item> mItemsList;

    RecyclerView mItemRecyclerView;
    ItemAdapter mItemAdapter;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the data required to populate into the RecyclerView
        mResponseString = HelperFunctions.getInstance().getStringFromDataJSON(this);

        try {
            mItemsList = ItemManager.getInstance().getItemLists(mResponseString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mResponseString = "done";

        //Set up RecyclerView
        mItemRecyclerView = (RecyclerView) findViewById(R.id.rv_items);
        mGridLayoutManager = new GridLayoutManager(this, 3);
        mItemRecyclerView.setLayoutManager(mGridLayoutManager);
        mItemAdapter = new ItemAdapter(this, mItemsList);
        mItemRecyclerView.setAdapter(mItemAdapter);
    }
}
