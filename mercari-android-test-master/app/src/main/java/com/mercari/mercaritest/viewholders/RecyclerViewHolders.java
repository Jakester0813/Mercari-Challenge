package com.mercari.mercaritest.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercari.mercaritest.R;
import com.mercari.mercaritest.data.model.Item;

/**
 * Created by Jake on 5/27/2017.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder{

    public ImageView soldImage;
    public ImageView itemImage;
    public TextView priceText;
    public TextView itemNameText;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        this.soldImage = (ImageView)itemView.findViewById(R.id.iv_item_sold);
        this.itemImage = (ImageView)itemView.findViewById(R.id.iv_item_image);
        this.priceText = (TextView)itemView.findViewById(R.id.tv_item_price);
        this.itemNameText = (TextView)itemView.findViewById(R.id.tv_item_name);
    }
}
