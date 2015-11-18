package com.example.listview;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ContactsSortingActivityTest extends ActivityInstrumentationTestCase2<Contacts_SortingActivity> {

    private Activity mActivity;
    private ListView listView;
    private Button ascButton;
    private Button descButton;

    public ContactsSortingActivityTest() {
        super(Contacts_SortingActivity.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        listView = (ListView) mActivity.findViewById(R.id.listViewSorting);
        ascButton = (Button) mActivity.findViewById(R.id.ascendingButton);
        descButton = (Button) mActivity.findViewById(R.id.descendingButton);

    }


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

            assertEquals(obj.getClass(), SampleContacts.contacts[1].getClass());
            assertEquals(obj, SampleContacts.contacts[1]);

            TextView text1 = (TextView) view.findViewById(android.R.id.text1);
            Log.v("ContactsActivityTest", text1.getText().toString());

            assertEquals((String) text1.getText(), SampleContacts.contacts[1].FullName);

            //Now, click the sort ascending button.
            getInstrumentation().runOnMainSync(new Runnable() {
                @Override
                public void run() {
                    ascButton.requestFocus();
                }
            });
            getInstrumentation().waitForIdleSync();
            TouchUtils.clickView(this, ascButton);
            getInstrumentation().waitForIdleSync();

            Contact[] ascContacts = SampleContacts.contacts.clone();
            Arrays.sort(ascContacts);


            obj = listView.getItemAtPosition(1);
            Log.v("ContactsActivityTest", obj.toString());

            assertNotNull(obj);

            view = listView.getChildAt(1);

            assertNotNull(view);

            if(obj == null || view == null){
                return;
            }

            assertEquals(obj, ascContacts[1]);

            text1 = (TextView) view.findViewById(android.R.id.text1);
            Log.v("ContactsActivityTest", text1.getText().toString());

            assertEquals((String) text1.getText(), ascContacts[1].FullName);

            //Now, click the sort descending button.
            getInstrumentation().runOnMainSync(new Runnable() {
                @Override
                public void run() {
                    descButton.requestFocus();
                }
            });
            getInstrumentation().waitForIdleSync();
            TouchUtils.clickView(this, descButton);
            getInstrumentation().waitForIdleSync();

            Contact[] descContacts = SampleContacts.contacts.clone();
            Arrays.sort(descContacts, Collections.reverseOrder());


            obj = listView.getItemAtPosition(1);
            Log.v("ContactsActivityTest", obj.toString());

            assertNotNull(obj);

            view = listView.getChildAt(1);

            assertNotNull(view);

            if(obj == null || view == null){
                return;
            }

            assertEquals(obj, descContacts[1]);

            text1 = (TextView) view.findViewById(android.R.id.text1);
            Log.v("ContactsActivityTest", text1.getText().toString());

            assertEquals((String) text1.getText(), descContacts[1].FullName);

        }
        catch(Exception e)
        {
            Log.v("ContactsActivityTest", e.toString());

        }

    };


};