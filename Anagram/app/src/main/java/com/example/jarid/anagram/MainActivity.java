package com.example.jarid.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        Button buttonExit = (Button)findViewById(R.id.buttonExit);


        // Switch Activity pass username data
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View main) {
                EditText userinput = (EditText)findViewById(R.id.editTextUser);
                String username = userinput.getText().toString();
                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);

            }
        });

        // Close Application
        buttonExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View main){
                finish();
                System.exit(0);

            }

        });

    }

}