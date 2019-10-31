package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.editText);
    }


    public void changeText(View view) {

        String textValue = myTextView.getText().toString();

        TextView message = findViewById(R.id.message);
        message.setText("Your Birthday is " + textValue);

        ImageView myImage = findViewById(R.id.imageView);
        myImage.setImageResource(R.drawable.bdaycake);
    }
}
