package com.mercari.mercaritest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.utils.HelperFunctions;
import com.mercari.mercaritest.utils.MercariConstants;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ItemDataInstrumentedUnitTest {

    Context appContext;
    String mResponseString;
    JSONObject jsonObject, itemObject;
    JSONArray itemArray;

    //Test #1: Testing the result is ok
    @Test
    public void result_is_ok() throws Exception {
        appContext = InstrumentationRegistry.getTargetContext();
        mResponseString = HelperFunctions.getInstance().getStringFromDataJSON(appContext);
        assertNotNull(mResponseString);
        jsonObject = new JSONObject(mResponseString);
        assertNotNull(jsonObject.getString(MercariConstants.RESULT));
        assertEquals(jsonObject.getString(MercariConstants.RESULT),MercariConstants.OK);
    }

    //Test #2: Testing the first item isn't null
    @Test
    public void item_data_is_there() throws Exception {
        appContext = InstrumentationRegistry.getTargetContext();
        mResponseString = HelperFunctions.getInstance().getStringFromDataJSON(appContext);
        assertNotNull(mResponseString);
        jsonObject = new JSONObject(mResponseString);
        itemArray = jsonObject.getJSONArray(MercariConstants.DATA);
        assertNotNull(itemArray);
        itemObject = itemArray.getJSONObject(0);
        assertNotNull(itemObject);
        assertNotNull(itemObject.getString(MercariConstants.ID));
        assertNotNull(itemObject.getString(MercariConstants.NAME));
        assertNotNull(itemObject.getString(MercariConstants.STATUS));
        assertNotNull(itemObject.getString(MercariConstants.NUM_LIKES));
        assertNotNull(itemObject.getString(MercariConstants.NUM_COMMENTS));
        assertNotNull(itemObject.getString(MercariConstants.PRICE));
        assertNotNull(itemObject.getString(MercariConstants.PHOTO));
    }
}