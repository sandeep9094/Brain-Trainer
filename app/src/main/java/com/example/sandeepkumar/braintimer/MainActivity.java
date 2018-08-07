package com.example.sandeepkumar.braintimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView sumTextView;

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    public void chooseAns(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        sumTextView = (TextView) findViewById(R.id.sumTextView);
        Random rand = new Random();                             //Creating Random Class Object

        int a = rand.nextInt(21);                       //Creating random Int btw 0 to 20
        int b = rand.nextInt(21);                       //Creating random Int btw 0 to 20

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
    }
}
