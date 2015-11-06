package com.example.listview;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class Contacts2itemTest extends ActivityInstrumentationTestCase2<Contacts_2item> {

    private Activity mActivity;
    private ListView listView;

    public Contacts2itemTest() {
        super(Contacts_2item.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        listView = (ListView) mActivity.findViewById(R.id.listView2item);

    }


    public void test1(){

        try{

            Object obj = listView.getItemAtPosition(1);
            Log.v("Contacts2itemTest", obj.toString());

            assertNotNull(obj);

            View view = listView.getChildAt(1);

            assertNotNull(view);

            if(obj == null || view == null){
                return;
            }

            assertEquals(obj.getClass(),SampleContacts.contacts[1].getClass());
            assertEquals(obj,SampleContacts.contacts[1]);

            TextView text1 = (TextView) view.findViewById(android.R.id.text1);
            Log.v("Contacts2itemTest", text1.getText().toString());

            assertEquals((String) text1.getText(), SampleContacts.contacts[1].FullName);

            TextView text2 = (TextView) view.findViewById(android.R.id.text2);
            Log.v("Contacts2itemTest", text2.getText().toString());

            assertEquals("Company value does not match",(String) text2.getText(), SampleContacts.contacts[1].Company);
        }
        catch(AssertionError e)
        {
            Log.v("Contacts2itemTest", e.getMessage());
            throw e;

        }

    };


};