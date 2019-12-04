package com.example.lab8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class YourMusicActivity extends AppCompatActivity {

    private String bandName;
    private String bandUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_music);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findBandWebsite(view);
            }
        });


        Intent intent = getIntent();
        bandName = intent.getStringExtra("yourBand");
        bandUrl = intent.getStringExtra("yourURL");
        Log.i("band received", bandName);
        Log.i("url received", bandUrl);

        TextView displayBandName = findViewById(R.id.textView2);
        displayBandName.setText("Your suggested band is " + bandName);

    }

    private void findBandWebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(bandUrl));
        startActivity(intent);

    }

}
