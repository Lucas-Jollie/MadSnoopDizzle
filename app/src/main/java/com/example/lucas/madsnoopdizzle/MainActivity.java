package com.example.lucas.madsnoopdizzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner genderChoiceSpinner;
    private String itemSelectedInSpinner;
    private TextView userName, userAge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemToGenderChoiceSpinner();

        addListenerToGenderChoiceSpinner();

        userName = (TextView) findViewById(R.id.editText);

        userAge = (TextView) findViewById(R.id.ageInput);




    }

    public void addItemToGenderChoiceSpinner(){
        genderChoiceSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> genderChoiceSpinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.gender,
                        android.R.layout.simple_spinner_item);

        genderChoiceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderChoiceSpinner.setAdapter(genderChoiceSpinnerAdapter);
    }

    public void addListenerToGenderChoiceSpinner(){

        genderChoiceSpinner = (Spinner) findViewById(R.id.spinner);

        genderChoiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

                if (itemSelectedInSpinner.equals("other")) {

                    itemSelectedInSpinner = "ambiguous person";

                }
                else if (itemSelectedInSpinner.equals("Male")){

                    itemSelectedInSpinner = "playa";
                }
                else if (itemSelectedInSpinner.equals("Female")) {

                    itemSelectedInSpinner = "ho";
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Please select a gender!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void whenClicked(View view) {

        Intent getInfoScreenIntent= new Intent(this, AskInfo.class);



        String passName = userName.getText().toString();
        String passAge = userAge.getText().toString();

        getInfoScreenIntent.putExtra("passName", passName);
        getInfoScreenIntent.putExtra("passAge", passAge);
        getInfoScreenIntent.putExtra("passGender", itemSelectedInSpinner);

        startActivity(getInfoScreenIntent);
    }
}
