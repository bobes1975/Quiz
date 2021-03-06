package com.example.android.gamesquizlinear;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class RadioBoxQuestion extends AppCompatActivity {

    static final String stateQuestionNumber = "stateQuestionNumber";
    static final String stateScore = "stateScore";

    ImageView gamePicture;
    private QuestionLibrary myQuestionLibrary = new QuestionLibrary();
    private int score = 0;
    private TextView quizQuestionNumberView;
    private TextView quizQuestionView;
    private RadioButton radioButtonChoice1;
    private RadioButton radioButtonChoice2;
    private RadioButton radioButtonChoice3;
    private RadioButton radioButtonChoice4;
    private String quizAnswer;
    private String urlHelpLink;
    private int questionNumber = 0;
    private RadioGroup radioQuestionGroup;


    public RadioBoxQuestion() {
        score = 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_box_question);

        quizQuestionNumberView = (TextView) findViewById(R.id.question_1);
        quizQuestionView = (TextView) findViewById(R.id.text_question_1);
        radioQuestionGroup = (RadioGroup) findViewById(R.id.radio_group_question_1);
        radioButtonChoice1 = (RadioButton) findViewById(R.id.option_question_1_1);
        radioButtonChoice2 = (RadioButton) findViewById(R.id.option_question_1_2);
        radioButtonChoice3 = (RadioButton) findViewById(R.id.option_question_1_3);
        radioButtonChoice4 = (RadioButton) findViewById(R.id.option_question_1_4);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            questionNumber = savedInstanceState.getInt(stateQuestionNumber);
            score = savedInstanceState.getInt(stateScore);
        }

        question();
        updateQuestion();
    }

    //Save question number and score during display rotation
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the question number
        questionNumber = questionNumber - 1;
        savedInstanceState.putInt(stateQuestionNumber, questionNumber);
        savedInstanceState.putInt(stateScore, score);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    //update question for radio buttons part of quiz
    public void question() {

        // find correct answer
        radioQuestionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // find which radio button is selected and compare it with correct answer

                if (checkedId == R.id.option_question_1_1) {

                    String choice = radioButtonChoice1.getText().toString();
                    if (choice == quizAnswer) {

                        score = score + 1;
                    }

                } else if (checkedId == R.id.option_question_1_2) {

                    String choice = radioButtonChoice2.getText().toString();
                    if (choice == quizAnswer) {

                        score = score + 1;
                    }

                } else if (checkedId == R.id.option_question_1_3) {

                    String choice = radioButtonChoice3.getText().toString();
                    if (choice == quizAnswer) {

                        score = score + 1;
                    }

                } else if (checkedId == R.id.option_question_1_4) {

                    String choice = radioButtonChoice4.getText().toString();
                    if (choice == quizAnswer) {

                        score = score + 1;
                    }
                }
            }
        });
    }


    //update question texts, choices and web link for help button

    public void updateQuestion() {
        gamePicture = (ImageView) findViewById(R.id.quizImage1);

        quizQuestionNumberView.setText(myQuestionLibrary.getQuizQuestionNumber(questionNumber));
        quizQuestionView.setText(myQuestionLibrary.getQuizQuestionText(questionNumber));
        radioButtonChoice1.setText(myQuestionLibrary.getQuizChoice1(questionNumber));
        radioButtonChoice2.setText(myQuestionLibrary.getQuizChoice2(questionNumber));
        radioButtonChoice3.setText(myQuestionLibrary.getQuizChoice3(questionNumber));
        radioButtonChoice4.setText(myQuestionLibrary.getQuizChoice4(questionNumber));
        quizAnswer = myQuestionLibrary.getCorrectAnswer(questionNumber);
        urlHelpLink = myQuestionLibrary.getUrlHelp(questionNumber);

        //update quiz picture
        String pictureNo = myQuestionLibrary.getPicture(questionNumber);
        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/" + pictureNo, null, c.getPackageName());
        ((ImageView) findViewById(R.id.quizImage1)).setImageResource(id);

        //update question number
        questionNumber++;
    }

    //help button wit web page
    public void help_Q1(View view) {
        goToUrl(urlHelpLink);
    }

    public void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);

    }

    //next button
    public void next(View view) {
        int amountOfQuestions = 7;
        if (amountOfQuestions == questionNumber) {

            evaluation();
        } else {
            updateQuestion();
        }
    }

    //after finishing quiz call evaluation
    public void evaluation() {

//sent int score to 2nd CheckBox question activity
        Intent sentScore = new Intent(RadioBoxQuestion.this, CheckBoxQuestion1.class);
        sentScore.putExtra("sentScoreTo", score);
        startActivity(sentScore);

    }
}