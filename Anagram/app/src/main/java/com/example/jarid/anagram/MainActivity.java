package com.example.jarid.anagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    Button buttonRead;
    TextView textView1;
    EditText editText3;
    String[] result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        buttonRead = (Button)findViewById(R.id.buttonRead);
        textView1 = (TextView)findViewById(R.id.editText3);

        buttonRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = "";
                try{
                    InputStreamReader inputs = new InputStreamReader(getAssets().open("anagrams.txt"));
                    BufferedReader br = new BufferedReader(inputs);
                    /*InputStream inputs = getAssets().open("anagrams.txt");
                    int size = inputs.available();
                    byte[] buffer = new byte[size];
                    inputs.readLine(buffer);
                    inputs.close();*/
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = br.readLine()) != null) {
                        stringBuffer.append(line);
                        stringBuffer.append("\n");
                    }
                    inputs.close();

                    text = new String();
                    result = text.split(" ");
                    finish();

                } catch(IOException e){
                    e.printStackTrace();;

                }

                textView1.setText(result[2]);
            }
        });
    }
}
