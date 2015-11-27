package com.example.listview;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class Countries_PaginationActivityTest extends ActivityInstrumentationTestCase2<Countries_PaginationActivity> {

    private Activity mActivity;
    private ListView listView;
    private Button nextButton;

    public Countries_PaginationActivityTest() {
        super(Countries_PaginationActivity.class);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        listView = (ListView) mActivity.findViewById(R.id.idlistCountries);
        nextButton = (Button) mActivity.findViewById(R.id.idNextButton);

    }


    public void test1(){

        validateCountryAtPosition(1, "Albania");
        validateCountryAtPosition(4, "Angola");

        // Hit next to go to 2nd page
        TouchUtils.clickView(this, nextButton);
        validateCountryAtPosition(1, "Argentina");
        validateCountryAtPosition(4, "Austria");


        // Hit next to go to 3rd page
        TouchUtils.clickView(this, nextButton);
        validateCountryAtPosition(0, "Azerbaijan");
        validateCountryAtPosition(2, "Bahrain");

        assertEquals(nextButton.isEnabled(), true );

    };

    private void validateCountryAtPosition(int position, String expectedValue){

        try{

            View view = listView.getChildAt(position);

            TextView text1 = (TextView) view.findViewById(android.R.id.text1);
            Log.v("Countries_Pagination", text1.getText().toString());

            assertEquals("Country value did not match",(String) text1.getText(), expectedValue);

        }
        catch(Exception e)
        {
            Log.e("Countries_Pagination", e.toString());
            fail(e.toString());

        }
    }


};