package com.example.lucas.madsnoopdizzle;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;


public class DisplayStory extends  AskInfo {



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // set layout and get info
        setContentView(R.layout.story_screen);

        Intent secondCall = getIntent();

        // initiate textview and parts of text
        final TextView makeStory;
        final String part1, part2, part3, part4, part5, part6, part7, part8, part9, part10,
                part11, part12, part13, part14, part15, part16, part17, part18, part19, part20,
                part21, part22, part23;


        // pass info from prev screen to string
        makeStory = (TextView)findViewById(R.id.storyText);
        String animal = secondCall.getExtras().getString("favoAnimal");
        String country = secondCall.getExtras().getString("favoCountry");
        String food = secondCall.getExtras().getString("favoFood");
        String hero = secondCall.getExtras().getString("favoHero");
        String number = secondCall.getExtras().getString("favoNumb");
        String adjective = secondCall.getExtras().getString("favoAdje");
        String name = secondCall.getExtras().getString("userName");
        String age = secondCall.getExtras().getString("userAge");
        String gender = secondCall.getExtras().getString("userGender");

        // recreate sentences for story (import text did not work)
        part1 = " was a mothaf'in ";
        part2 = " from da hood. ";
        part3 = " was taught to be a real nigga in err' day life. ";
        part4 = " put on some of they gear, still bustin' a grub. Chawning on some ";
        part5 = ", ";
        part6 = " ran into ";
        part7 = " members of rival gang Purple ";
        part8 = ". They be slinging some angel dust from ";
        part9 = ". One of them spotted ";
        part10 = " and said &quot;Watch me make it rain on this ";
        part11 = " B.&quot; &quot;Don' try to be no ";
        part12 = ", yung ";
        part13 = ". I got ";
        part14 = " caps with you name on 'em&quot;. \n";
        part15 = " bailed outta that place. &quot;Imma go back to ";
        part16 = "!&quot; ";
        part17 = " said. Before ";
        part18 = " knew it, the Purple";
        part19 = " nailed ";
        part20 = " and busted ";
        part21 = " caps in ";
        part22 = "'s ass.\n\nAnd thus concludeth the saga of ";
        part23 = "... May the OG Lord hold his soul in the G paradise for all of eternity.";
        Character space = ' ';

        // compose story
        String compStory = name + part1 + adjective + space + gender + part2 + name + part3 + name
                + part4 + food + part5 + name + part6 + number + part7 + animal + part8 + country
                + part9 + name + part10 + adjective + part11 + hero + part12 + name + part13 + number
                + part14 + name + part15 + country + part16 + name + part17 + name + part18 + animal
                + part19 + name + part20 + age + part21 + name + part22 + name + part23;
        // align text and set text
        makeStory.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        makeStory.setText(compStory);
    }
}
