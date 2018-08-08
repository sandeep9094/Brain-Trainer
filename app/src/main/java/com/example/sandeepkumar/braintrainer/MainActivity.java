package com.example.sandeepkumar.braintrainer;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton, ans1, ans2, ans3, ans4, playAgainButton;
    TextView sumTextView,pointsTextView,resultTextView,timerTextView;
    ArrayList<Integer> answers = new ArrayList<>();
    int correctAnsLocation;
    int score = 0;
    int totalQuestions = 0;
    CountDownTimer timer;
    ConstraintLayout gameLayout;

    @SuppressLint("SetTextI18n")
    public void playAgain(View view){
        score = 0;
        totalQuestions = 0;

        timerTextView.setText("0s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);

        generateQuetions();

        //total time of clock is 30 seconds = 30,000 milli seconds
        //Tick ever second i.e. 1 second =1000 milli seconds
        timer = new CountDownTimer(30000,1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                timerTextView.setText(String .valueOf(l/1000) + "s");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                resultTextView.setText("Your Score :" + Integer.toString(score)+ "/" + Integer.toString(totalQuestions));
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @SuppressLint("SetTextI18n")
    public void generateQuetions(){
        Random rand = new Random();                             //Creating Random Class Object

        int a = rand.nextInt(21);                       //Creating random Int btw 0 to 20
        int b = rand.nextInt(21);                       //Creating random Int btw 0 to 20
        correctAnsLocation = rand.nextInt(4);
        answers.clear();

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

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(ConstraintLayout.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    public void chooseAns(View view){
        if((view.getTag().toString()).equals(Integer.toString(correctAnsLocation))){
           score++;
           resultTextView.setText("Correct");
        } else{
            resultTextView.setText("Wrong!");
        }
        totalQuestions++;
        pointsTextView.setText(Integer.toString(score)+ "/" + Integer.toString(totalQuestions));
        generateQuetions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);

        startButton = findViewById(R.id.startButton);
        playAgainButton = findViewById(R.id.playAgainButton);
        sumTextView = findViewById(R.id.sumTextView);
        pointsTextView = findViewById(R.id.pointsTextView);
        resultTextView = findViewById(R.id.resultTextView);
        timerTextView = findViewById(R.id.timerTextView);
        gameLayout = findViewById(R.id.gameLayout);

        playAgain(timerTextView);

    }
}