package com.example.android.gamesquizlinear;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxQuestion1 extends AppCompatActivity {

    public int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_question1);

        Intent sentScoreA = getIntent();

        final int newScore = sentScoreA.getIntExtra(util.SENT_SCORE, 0);

        answer1CheckBox(newScore);
    }

    //help button wit web page

    public void help_Q1(View view) {
        goToUrl(getString(R.string.web_help_no1_Box));
    }

    private void goToUrl(String url) {

        url = getString(R.string.web_help_no1_Box);
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    //Check the correct answer (box No.1, 2 and 3)

    public void answer1CheckBox(final int newScore) {
        Button btnNext = (Button) findViewById(R.id.question_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox checkBoxAnswer1 = (CheckBox) findViewById(R.id.option_question_1_1_box);

                CheckBox checkBoxAnswer3 = (CheckBox) findViewById(R.id.option_question_1_3_box);

                score = newScore;

                if (checkBoxAnswer1.isChecked()) {

                    score = score + 1;
                }

                if (checkBoxAnswer3.isChecked()) {
                    score = score + 1;
                }


                //sent int score to 2nd CheckBox question activity
                Intent sentScore = new Intent(CheckBoxQuestion1.this, CheckBoxQuestion2.class);
                sentScore.putExtra("sentScoreTo", score);
                startActivity(sentScore);

            }
        });
    }
}
