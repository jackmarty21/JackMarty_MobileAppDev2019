package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView foodChoice;
    private ToggleButton hotCold;
    private Spinner protein;
    private RadioGroup cookStyle;
    private CheckBox saladCheck;
    private CheckBox riceCheck;
    private CheckBox noodleCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodChoice = findViewById(R.id.foodChoice);
        hotCold = findViewById(R.id.toggleButton);
        protein = findViewById(R.id.spinner);
        cookStyle = findViewById(R.id.radioGroup);
        saladCheck = findViewById(R.id.checkBox);
        riceCheck = findViewById(R.id.checkBox2);
        noodleCheck = findViewById(R.id.checkBox3);
    }

    public void findRecipe(View view) {
        boolean temperature = hotCold.isChecked();
        String proteinType = String.valueOf(protein.getSelectedItem());
        int cookStyleId = cookStyle.getCheckedRadioButtonId();
        boolean saladSide = saladCheck.isChecked();
        boolean riceSide = riceCheck.isChecked();
        boolean noodleSide = noodleCheck.isChecked();

        String myRecipe = null;

        if(cookStyleId == -1) {
            Context toastContext = getApplicationContext();
            CharSequence toastText = "Select a Cooking Style";
            int duration = Toast.LENGTH_SHORT;

            Toast mytoast = Toast.makeText(toastContext, toastText, duration);
            mytoast.show();
        } else {
            //Hot
            if (temperature) {
                //Chicken
                if (proteinType.equals("Chicken")) {
                    //Baked
                    if (cookStyleId == R.id.radioButton) {
                        //noodleSide #1
                        if (noodleSide) {
                            myRecipe = "Recommendation: Chicken Noodle Casserole";
                        }
                        //RiceSide #2
                        else if (riceSide) {
                            myRecipe = "Recommendation: Chicken and Rice";
                        }
                        //SaladSide #3
                        else if (saladSide) {
                            myRecipe = "Recommendation: Baked Chicken Salad";
                        }
                    }
                    //Fried
                    if (cookStyleId == R.id.radioButton2) {
                        //RiceSide #1
                        if (riceSide) {
                            myRecipe = "Recommendation: Chicken Fried Rice";
                        }
                        //SaladSide #2
                        else if (saladSide) {
                            myRecipe = "Recommendation: Fried Chicken with a Salad";
                        }
                        //NoodleSide #3
                        else if (noodleSide) {
                            myRecipe = "Recommendation: Chicken Stir Fry";
                        }
                    }
                    //Grilled
                    if (cookStyleId == R.id.radioButton3) {
                        //Salad #1
                        if (saladSide) {
                            myRecipe = "Recommendation: Chicken Caeser Salad";
                        }
                        //Rice #2
                        else if (riceSide) {
                            myRecipe = "Recommendation: Lemon Chicken and Rice";
                        }
                        //NoodleSide #3
                        else if (noodleSide) {
                            myRecipe = "Recommendation: Chicken Stir Fry";
                        }
                    }
                }
                //Steak
                if (proteinType.equals("Steak")) {
                    //Baked
                    if (cookStyleId == R.id.radioButton) {
                        Context toastContext = getApplicationContext();
                        CharSequence toastText = "Ewww...Baked Steak?";
                        int duration = Toast.LENGTH_SHORT;

                        Toast mytoast = Toast.makeText(toastContext, toastText, duration);
                        mytoast.show();
                    }
                    //Fried
                    if (cookStyleId == R.id.radioButton2) {
                        //RiceSide #1
                        if (riceSide) {
                            myRecipe = "Recommendation: Fried Steak and Rice";
                        }
                        //SaladSide #2
                        else if (saladSide) {
                            myRecipe = "Recommendation: Fried Steak Salad";
                        }
                        //NoodleSide #3
                        else if (noodleSide) {
                            myRecipe = "Recommendation: Fried Steak Stir Fry";
                        }
                    }
                    //Grilled
                    if (cookStyleId == R.id.radioButton3) {
                        //Salad #1
                        if (saladSide) {
                            myRecipe = "Recommendation: Chophouse Steak Salad";
                        }
                        //Rice #2
                        else if (riceSide) {
                            myRecipe = "Recommendation: Steak and Rice";
                        }
                        //NoodleSide #3
                        else if (noodleSide) {
                            myRecipe = "Recommendation: Teriyaki Steak Noodles";
                        }
                    }
                }
                //Veggie
                if (proteinType.equals("Veggie")) {
                    //Baked
                    if (cookStyleId == R.id.radioButton) {
                        //noodleSide #1
                        if (noodleSide) {
                            myRecipe = "Recommendation: Vegetable Noodle Casserole";
                        }
                        //RiceSide #2
                        else if (riceSide) {
                            myRecipe = "Recommendation: Vegetables and Rice";
                        }
                        //SaladSide #3
                        else if (saladSide) {
                            myRecipe = "Recommendation: Greek Salad";
                        }
                    }
                    //Fried
                    if (cookStyleId == R.id.radioButton2) {
                        //RiceSide #1
                        if (riceSide) {
                            myRecipe = "Recommendation: Vegetable Tempura Fried Rice";
                        }
                        //SaladSide #2
                        else if (saladSide) {
                            myRecipe = "Recommendation: Vegetable Tempura Salad";
                        }
                        //NoodleSide #3
                        else if (noodleSide) {
                            myRecipe = "Recommendation: Vegetable Tempura Stir Fry";
                        }
                    }
                    //Grilled
                    if (cookStyleId == R.id.radioButton3) {
                        //Salad #1
                        if (saladSide) {
                            myRecipe = "Recommendation: Grilled Veggie Salad";
                        }
                        //Rice #2
                        else if (riceSide) {
                            myRecipe = "Recommendation: Baked Zucchini and Rice";
                        }
                        //NoodleSide #3
                        else if (noodleSide) {
                            myRecipe = "Recommendation: Creamy Vegetable and Noodles";
                        }
                    }
                }
            }
            else {
                myRecipe = "Leftovers";
            }

            //text view
            foodChoice.setText(myRecipe);
        }
    }
}
