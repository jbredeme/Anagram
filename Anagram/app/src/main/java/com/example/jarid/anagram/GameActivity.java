package com.example.jarid.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.io.*;

public class GameActivity extends AppCompatActivity {
    Integer totalwords = 0;
    Integer wordsfound = 0;
    String[] words;
    TextView textViewNumTokens;
    TextView textViewAnagramWord;
    TextView textViewWordLabel;
    TextView textViewUsernameTitle;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button buttonQuit = (Button)findViewById(R.id.buttonQuit);
        Button buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        textViewUsernameTitle = (TextView)findViewById(R.id.textViewUsername);
        textViewNumTokens = (TextView)findViewById(R.id.textViewMatchedWords);
        textViewAnagramWord = (TextView)findViewById(R.id.textViewDisplayAnagram);
        textViewWordLabel = (TextView)findViewById(R.id.textViewAnagramWordLabel);


        username = getIntent().getStringExtra("username");

        // Check if username is empty
        if(!(username.equals(""))) {
            textViewUsernameTitle.setText("Let's Play " + helpers.toTitleCase(username) + "!");

        } else{
            textViewUsernameTitle.setText("Let's Play Stranger!");

        }

        // Read in flat file
        try{
            InputStreamReader inputs = new InputStreamReader(getAssets().open("anagrams.txt"));
            BufferedReader br = new BufferedReader(inputs);
            words = br.readLine().split(" ");
            textViewAnagramWord.setText(words[0]);
            words[0] = null;
            totalwords = words.length - 1;
            textViewNumTokens.setText(wordsfound + "/" + totalwords);

        }catch (IOException e){
            e.printStackTrace();;

        }


        // Most of our work
        buttonSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View sub) {
                EditText input = (EditText)findViewById(R.id.editTextUserInput);
                String submission = input.getText().toString();

                for(int i = 0; i < words.length; i++){
                    if(words[i] != null){
                        if(words[i].equals(submission)){
                            wordsfound += 1;
                            textViewNumTokens.setText(wordsfound + "/" + totalwords);
                            words[i] = null;

                        }

                        if(wordsfound == totalwords){
                            textViewUsernameTitle.setText("Great Job " + helpers.toTitleCase(username) + "!");
                            textViewWordLabel.setText("");
                            textViewAnagramWord.setText("You're the bestest!");
                            input.setText("");

                        }

                    }

                }
                input.setSelectAllOnFocus(true);
            }

        });


        // Switch back to main activity
        buttonQuit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }

        });
    }
}
