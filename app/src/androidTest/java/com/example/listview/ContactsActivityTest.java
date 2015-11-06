package com.example.listview;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Console;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ContactsActivityTest extends ActivityInstrumentationTestCase2<ContactsActivity> {

    private Activity mActivity;
    private ListView listView;

    public ContactsActivityTest() {
        super(ContactsActivity.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        listView = (ListView) mActivity.findViewById(R.id.listView);

    }


    /*public void test1(){
        Object obj = listView.getItemAtPosition(1);

        Log.v("app",obj.getClass() + ":::" + obj);

        View view = listView.getChildAt(1);

        TextView text1 = (TextView) view.findViewById(android.R.id.text1);

        Log.v("app", (String) text1.getText());
        TextView text2 = (TextView) view.findViewById(android.R.id.text2);
        Log.v("app", (String) text2.getText());


    };*/

    public void test1(){

        try{

            Object obj = listView.getItemAtPosition(1);
            Log.v("ContactsActivityTest", obj.toString());

            assertNotNull(obj);

            View view = listView.getChildAt(1);

            assertNotNull(view);

            if(obj == null || view == null){
                return;
            }

            assertEquals(obj.getClass(),SampleContacts.contacts[1].getClass());
            assertEquals(obj,SampleContacts.contacts[1]);

            TextView text1 = (TextView) view.findViewById(android.R.id.text1);
            Log.v("ContactsActivityTest", text1.getText().toString());

            assertEquals((String) text1.getText(), SampleContacts.contacts[1].FullName);

        }
        catch(Exception e)
        {
            Log.v("ContactsActivityTest", e.toString());

        }

    };


};