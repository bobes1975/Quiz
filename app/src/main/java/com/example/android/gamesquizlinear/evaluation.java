package com.example.android.gamesquizlinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class evaluation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        Intent sentScoreA = getIntent();

        final int newScore = sentScoreA.getIntExtra("sentScoreTo", 0);

        evaluation(newScore);
    }

// evaluation of quiz

    private void evaluation(final int newScore) {

        //1st place
        if (newScore > 13) {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result1);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place1);

        //2nd place
        } else if (newScore > 10) {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result2);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place2);

        //3rd place
        } else if (newScore > 5) {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result3);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place3);

        //4th place
        } else {
            TextView evaluationText = (TextView) findViewById(R.id.evaluation);
            evaluationText.setText(R.string.result4);

            ImageView trophyPicture = (ImageView) findViewById(R.id.result);
            trophyPicture.setImageResource(R.drawable.place4);
        }
    } ;
    //onClick restart button

    public void reset(View v) {
        Intent intentReset = new Intent(this, MainActivity.class);
        startActivity(intentReset);
    }
}
