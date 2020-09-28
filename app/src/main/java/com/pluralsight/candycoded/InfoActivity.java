package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);

        /*
            The code below will execute when the user select text_view_phone (textView) and the Map will be launch
         */
        final TextView phone = findViewById(R.id.text_view_phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCallDial(getString(R.string.call_candy_number));
            }
        });


        /*
            The code below will execute when the user select text_view_address (textView) and the Map will be launch
         */
        final TextView map = findViewById(R.id.text_view_address);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMap(getString(R.string.candy_location_on_map));
            }
        });

    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    private void launchMap(String location) {
        Uri uri = Uri.parse(location);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage(getString(R.string.google_map_package_name));
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***

    private void launchCallDial(String call){
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(call))));
    }

}
