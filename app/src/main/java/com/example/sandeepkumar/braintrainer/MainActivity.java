package com.example.sandeepkumar.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView sumTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int correctAnsLocation;

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    public void chooseAns(View view){
        if((view.getTag().toString()).equals(Integer.toString(correctAnsLocation))){
            Log.i("correct ", "correct ");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ans1 = (Button)findViewById(R.id.ans1);
        Button ans2 = (Button)findViewById(R.id.ans2);
        Button ans3 = (Button)findViewById(R.id.ans3);
        Button ans4 = (Button)findViewById(R.id.ans4);

        startButton = (Button) findViewById(R.id.startButton);
        sumTextView = (TextView) findViewById(R.id.sumTextView);
        Random rand = new Random();                             //Creating Random Class Object

        int a = rand.nextInt(21);                       //Creating random Int btw 0 to 20
        int b = rand.nextInt(21);                       //Creating random Int btw 0 to 20
        correctAnsLocation = rand.nextInt(4);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
        int incorrectAnswer ;

        for (int i=0; i<4 ; i++){
            if(i == correctAnsLocation) {
                answers.add(a + b);
            } else {
                incorrectAnswer = rand.nextInt(51);
                while (incorrectAnswer ==(a+b)){
                    incorrectAnswer = rand.nextInt(51);
                }
                answers.add(incorrectAnswer);
            }
        }

        ans1.setText(Integer.toString(answers.get(0)));
        ans2.setText(Integer.toString(answers.get(1)));
        ans3.setText(Integer.toString(answers.get(2)));
        ans4.setText(Integer.toString(answers.get(3)));
    }
}
