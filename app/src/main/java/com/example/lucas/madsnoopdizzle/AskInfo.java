package com.example.lucas.madsnoopdizzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AskInfo extends Activity {

    private TextView favAnimal, country, favFood, hero, number, adjective;
    private String passName, passAge, passGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ask_more_info);

        Intent activityThatCalled = getIntent();

        passName = activityThatCalled.getExtras().getString("passName");
        passAge = activityThatCalled.getExtras().getString("passAge");
        passGender = activityThatCalled.getExtras().getString("passGender");


        favAnimal = (TextView) findViewById(R.id.favAnimal);
        country = (TextView) findViewById(R.id.anyCount);
        favFood = (TextView) findViewById(R.id.favFood);
        hero = (TextView) findViewById(R.id.nameHero);
        number = (TextView) findViewById(R.id.askNumb);
        adjective = (TextView) findViewById(R.id.someAdjective);



    }

    public void createStory(View view) {

        Intent createStoryFromInput = new Intent(this, DisplayStory.class);

        String passAnimal = favAnimal.getText().toString();
        String passCountry = country.getText().toString();
        String passFood = favFood.getText().toString();
        String passHero = hero.getText().toString();
        String passNumb = number.getText().toString();
        String passAdje = adjective.getText().toString();


        createStoryFromInput.putExtra("userGender", passGender);
        createStoryFromInput.putExtra("favoAnimal", passAnimal);
        createStoryFromInput.putExtra("favoCountry", passCountry);
        createStoryFromInput.putExtra("favoFood", passFood);
        createStoryFromInput.putExtra("favoHero", passHero);
        createStoryFromInput.putExtra("favoNumb", passNumb);
        createStoryFromInput.putExtra("favoAdje", passAdje);
        createStoryFromInput.putExtra("userName", passName);
        createStoryFromInput.putExtra("userAge", passAge);

        startActivity(createStoryFromInput);
    }
}
