package com.example.android.doctorquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Submit button is clicked
     *
     * @param View
     */
    public void submitAnswers(View View) {

        EditText questionOne = (EditText) findViewById(R.id.doctorName);
        String answerDoctorName = questionOne.getText().toString();

        RadioButton questionTwo = (RadioButton) findViewById(R.id.radioEighth);
        boolean checkedEight = questionTwo.isChecked();

        RadioButton questionThree = (RadioButton) findViewById(R.id.radioTrue);
        boolean checkedQuestionThree = questionThree.isChecked();

        EditText questionFour = (EditText) findViewById(R.id.lastWordsAnswer);
        String lastWords = questionFour.getText().toString();

        CheckBox rose = (CheckBox) findViewById(R.id.roseCheckbox);
        boolean roseIsChecked = rose.isChecked();

        CheckBox abby = (CheckBox) findViewById(R.id.abbyCheckbox);
        boolean abbyIsChecked = !abby.isChecked();

        CheckBox martha = (CheckBox) findViewById(R.id.marthaCheckbox);
        boolean marthaIsChecked = martha.isChecked();

        CheckBox clair = (CheckBox) findViewById(R.id.clairCheckbox);
        boolean clairIsChecked = !clair.isChecked();

        boolean isAnswerFiveCorrect = correctAnswerFive(roseIsChecked, abbyIsChecked, marthaIsChecked, clairIsChecked);

        boolean isAnswerOneCorrect = correctAnswerOne(answerDoctorName);

        boolean isAnswerFourRight = correctAnswerFour(lastWords);

        int finalScore = calculateScore(isAnswerOneCorrect, checkedEight, checkedQuestionThree, isAnswerFourRight, isAnswerFiveCorrect);

        String scoreMessage = createScoreMessage(finalScore);
        displayMessage(scoreMessage);
    }

    /**
     * this method compares the answer from the first question to the correct answer
     */

    public boolean correctAnswerOne(String answerDoctorName) {

        String correctDoctorName = "David Tennant";
        boolean answerOneIsRight = answerDoctorName.equalsIgnoreCase(correctDoctorName);
        return answerOneIsRight;
    }


    /**
     * this method compares the answer from the fourth question to the correct answer
     */

    public boolean correctAnswerFour(String lastWords) {

        String correctLastWords = "I don't wanna go";
        boolean answerFourIsRight = lastWords.equalsIgnoreCase(correctLastWords);
        return answerFourIsRight;

    }

    /**
     * this method compares the answer from the fifth question to the correct answer
     */

    public boolean correctAnswerFive(boolean roseIsChecked, boolean abbyIsChecked, boolean marthaIsChecked, boolean clairIsChecked) {

        if (roseIsChecked && (abbyIsChecked) && (marthaIsChecked) && (clairIsChecked)) {

            return true;

        } else {

            return false;
        }

    }

    /**
     * This method calculates the score of the user based on their answers
     *
     * @param answerOneIsRight
     * @param correctAnswerTwo
     * @param correctAnswerThree
     * @param answerFourIsRight
     * @param correctAnswerFive
     * @return final score
     */

    public int calculateScore(boolean answerOneIsRight, boolean correctAnswerTwo, boolean correctAnswerThree, boolean answerFourIsRight, boolean correctAnswerFive) {

        int score = 0;

        if (answerOneIsRight) {

            score = score + 2;

        }
        if (correctAnswerTwo) {

            score = score + 2;

        }
        if (correctAnswerThree) {

            score = score + 2;

        }
        if (answerFourIsRight) {

            score = score + 2;

        }
        if (correctAnswerFive) {

            score = score + 2;
        }

        return score;

    }

    private String createScoreMessage(int score) {

        return "Your final Score is: " + score + " out of 10" +
                "\n Thank you for playing!!";
    }

    /**
     * Displays the user's final score
     */

    private void displayMessage(String message) {

        TextView finalScoreTextView = (TextView) findViewById(R.id.textScore);
        finalScoreTextView.setText(message);

    }

}