package com.example.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ImageViewTutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_tutorial);
        final ListView listview = (ListView) findViewById(R.id.tutorialListView);

        class CustomAdapter extends ArrayAdapter<Contact> {
            public CustomAdapter(Context context, int resource, int textViewId, Contact[] contacts) {
                super(context, resource, textViewId, contacts);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                Contact contact = (Contact) super.getItem(position);

                View view = super.getView(position, convertView, parent);

                TextView text1 = (TextView) view.findViewById(R.id.tutorialTextView);
                ImageView img = (ImageView) view.findViewById(R.id.tutorialImageView);

                //BasicNameValuePair data = list.get(position);

                text1.setText(contact.FullName);
                img.setImageResource(android.R.drawable.btn_star);
                return view;
            }

        }

        CustomAdapter adapter = new CustomAdapter(this,R.layout.imageview_tutorial_layout , R.id.tutorialTextView, SampleContacts.contacts);
        listview.setRecyclerListener(new AbsListView.RecyclerListener() {
            @Override
            public void onMovedToScrapHeap(View view) {
                ImageView img = (ImageView) view.findViewById(R.id.tutorialImageView);
                img.setImageDrawable(null);
            }
        });
        listview.setAdapter(adapter);


        /* Alternate way of overriding GetView implementation inline.

        final ArrayAdapter<String> adapter = new ArrayAdapter(this,
                R.layout.imageview_tutorial_layout, R.id.tutorialTextView, SampleContacts.contacts) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                Contact contact = (Contact) super.getItem(position);

                View view = super.getView(position, convertView, parent);

                TextView text1 = (TextView) view.findViewById(R.id.tutorialTextView);
                ImageView img = (ImageView) view.findViewById(R.id.tutorialImageView);

                //BasicNameValuePair data = list.get(position);

                text1.setText(contact.FullName);
                img.setImageResource(android.R.drawable.btn_star);
                return view;
            }

        };
        listview.setAdapter(adapter);
        */


    }

}
