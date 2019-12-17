package com.example.martyfinalpart1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText nameText;
    private ToggleButton veggieToggle;
    private RadioGroup burritoTaco;
    private CheckBox salsaCheck;
    private CheckBox cheeseCheck;
    private CheckBox sourCreamCheck;
    private CheckBox guacamoleCheck;
    private Spinner locationSpinner;
    private Switch glutenFreeSwtich;
    private TextView description;
    private ImageView foodPic;
    private Button locationButton;
    private BurritoClass myBurritoClass = new BurritoClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.editText);
        veggieToggle = findViewById(R.id.toggleButton);
        burritoTaco = findViewById(R.id.radioGroup);
        salsaCheck = findViewById(R.id.salsaCheck);
        cheeseCheck = findViewById(R.id.cheeseCheck);
        sourCreamCheck = findViewById(R.id.sourcreamCheck);
        guacamoleCheck = findViewById(R.id.guacamoleCheck);
        locationSpinner = findViewById(R.id.spinner);
        glutenFreeSwtich = findViewById(R.id.switch1);
        description = findViewById(R.id.burritoDetails);
        foodPic = findViewById(R.id.imageView);
        locationButton = findViewById(R.id.locationButton);

        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findLocation(v);
            }
        };
        //add listener to button
        locationButton.setOnClickListener(onclick);

    }

    private void findLocation(View view) {
        Integer location = locationSpinner.getSelectedItemPosition();
        myBurritoClass.setBurritoLocation(location);
        String yourLocation= myBurritoClass.getBurritoLocation();
        String yourURL = myBurritoClass.getLocationURL();

        Intent intent = new Intent(this,LocationActivity.class);
        intent.putExtra("yourLocation", yourLocation);
        intent.putExtra("yourURL", yourURL);
        startActivity(intent);
    }

    public void buildBurrito(View view) {
        //Get Edit Text
        String nameValue = nameText.getText().toString();

        //Meat or Veggie
        boolean meatOrVeggie = veggieToggle.isChecked();

        //Radio Boxes
        int foodType = burritoTaco.getCheckedRadioButtonId();

        //check boxes
        Boolean salsa = salsaCheck.isChecked();
        Boolean cheese = cheeseCheck.isChecked();
        Boolean sourCream = sourCreamCheck.isChecked();
        Boolean guacamole = guacamoleCheck.isChecked();

        //switch
        Boolean glutenFree = glutenFreeSwtich.isChecked();


        //spinner
        String location = String.valueOf(locationSpinner.getSelectedItem());

        String foodTypeString;
        String tortillaTypeString;
        String meatOrVeggieString;

        if (nameValue == "") {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please enter your name";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (foodType == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please selected a food type";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if ((salsa == true && cheese == true) || (salsa == true && sourCream == true) || (salsa == true && guacamole == true) || (cheese == true && sourCream == true) || (cheese == true && guacamole == true) || (sourCream == true && guacamole == true)) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please only select 1 topping";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        else {

            //Burrito
            if (foodType == R.id.radioButton) {
                foodTypeString = "burrito";
                foodPic.setImageResource(R.drawable.burrito);
            } else {
                foodTypeString = "taco";
                foodPic.setImageResource(R.drawable.taco);
            }
            //Meat or Veggie
            if (meatOrVeggie == true) {
                meatOrVeggieString = "meat";
            } else {
                meatOrVeggieString = "veggie";
            }
            //Gluten Free
            if (glutenFree == true) {
                tortillaTypeString = "corn tortilla";
            } else {
                tortillaTypeString = "flour tortilla";
            }
            //Topping
            if (salsa == true) {
                description.setText(nameValue + " wants a " + meatOrVeggieString + " " + foodTypeString + " on a " + tortillaTypeString + " with salsa. You should go to " + location + ".");
            }
            else if (cheese == true) {
                description.setText(nameValue + " wants a " + meatOrVeggieString + " " + foodTypeString + " on a " + tortillaTypeString + " with cheese. You should go to " + location + ".");
            }
            else if (sourCream == true) {
                description.setText(nameValue + " wants a " + meatOrVeggieString + " " + foodTypeString + " on a " + tortillaTypeString + " with sour cream. You should go to " + location + ".");
            }
            else if (guacamole == true) {
                description.setText(nameValue + " wants a " + meatOrVeggieString + " " + foodTypeString + " on a " + tortillaTypeString + " with guacamole. You should go to " + location + ".");
            }
            else {
                description.setText(nameValue + " wants a " + meatOrVeggieString + " " + foodTypeString + " on a " + tortillaTypeString + ". You should go to " + location + ".");
            }


        }

    }
}
