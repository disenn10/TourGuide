package com.example.disen.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TopSightsDetailsActivity extends AppCompatActivity {
    String desc;
    String title;
    String webpage;
    String maps;
    int image;
    ImageView imageView;
    TextView desc_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_sights_details);
        Intent intent = getIntent();
        imageView = (ImageView)findViewById(R.id.imageDetails);
        desc_view = (TextView)findViewById(R.id.desc_details) ;
        title = intent.getStringExtra(getString(R.string.title));
        desc = intent.getStringExtra(getString(R.string.desc));
        webpage = intent.getStringExtra(getString(R.string.webpage));
        maps = intent.getStringExtra(getString(R.string.lat_lon));;
        image = intent.getIntExtra(getString(R.string.image),0);
        this.setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView.setImageResource(image);
        desc_view.setText(desc);
        LinearLayout webPage = (LinearLayout)findViewById(R.id.webpageIcon);
        webPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(TopSightsDetailsActivity.this.webpage);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
        LinearLayout map = (LinearLayout)findViewById(R.id.direction);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri geolocation = Uri.parse(getString(R.string.parsegeolocation) + maps + " (" + title + ")");
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, geolocation);
                if(geoIntent.resolveActivity(getPackageManager())!= null){
                    startActivity(geoIntent);
                }
            }
        });


    }
}
