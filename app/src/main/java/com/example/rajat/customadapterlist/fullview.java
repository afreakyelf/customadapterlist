package com.example.rajat.customadapterlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class fullview extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullview);

        image = findViewById(R.id.image);
        String img =getIntent().getStringExtra("image");
        image.setImageResource(Integer.parseInt(img));
    }
}
