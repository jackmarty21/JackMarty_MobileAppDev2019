package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner spinner;
    private TheGarageBand myTheGarageBand = new TheGarageBand();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.findMusicButton);
        spinner = findViewById(R.id.genreSpinner);

        View.OnClickListener onclick = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                findMusic(view);
            }
        };
        button.setOnClickListener(onclick);
    }

    private void findMusic(View view) {

        Integer genre = spinner.getSelectedItemPosition();
        myTheGarageBand.setBandName(genre);
        String bandName = myTheGarageBand.getBandName();
        String bandURL = myTheGarageBand.getBandURL();
        Log.i("band suggested", bandName);
        Log.i("url suggested", bandURL);

        Intent intent = new Intent(this, YourMusicActivity.class);
        intent.putExtra("yourBand", bandName);
        intent.putExtra("yourURL", bandURL);
        startActivity(intent);

    }
}
