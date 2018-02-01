package com.example.android.gamesquizlinear;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class editTextQuestion extends AppCompatActivity {

    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_question);

        Intent sentScoreA = getIntent();

        final int newScore = sentScoreA.getIntExtra(util.SENT_SCORE, 0);

        answerET(newScore);
    }

    //help button wit web page

    public void help_Q1(View view) {
        goToUrl(getString(R.string.web_help_no11_ET));
    }


    private void goToUrl(String url) {

        url = getString(R.string.web_help_no11_ET);
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    //Check the correct answer (box No.1, 2 and 3)
    public void answerET(final int newScore) {
        Button btnNext = (Button) findViewById(R.id.question_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score = newScore;


                EditText answerField = (EditText) findViewById(R.id.editTextAnswer);
                String answerET = answerField.getText().toString().toLowerCase();

                String quizAnswer = getString(R.string.answer_no_11);

                if (answerET.equals(quizAnswer)) {
                    score = score + 1;

                }

                String scoreMessage = getString(R.string.youHave) + String.valueOf(score) + getString(R.string.correntAnswer);

                Toast.makeText(editTextQuestion.this,
                        scoreMessage, Toast.LENGTH_LONG).show();

                //sent int score to Evaluation activity
                Intent sentScore = new Intent(editTextQuestion.this, evaluation.class);
                sentScore.putExtra("sentScoreTo", score);
                startActivity(sentScore);

            }
        });
    }
}