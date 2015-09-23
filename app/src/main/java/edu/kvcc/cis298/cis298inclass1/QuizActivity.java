package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    //create a class level Widget variables so
    //that we will have access to stuff from the view
    //no value yet. just declared the variables
    private Button mTrueButton;
    private Button mFalseButton;
    //variable for the next button
    private Button mNextButton;
    //variable for the question string
    private TextView mQuestionTextView;


    //The questions that will be used it is an array of type
    //question. that contains 5 questions. it is a hard coded
    //array. in most apps, you would want your data to come from
    //somewhere else. (database, internet) Not be hard coded.
    private Question [] mQuestionBank = new Question[] {
            new Question(R.string.question_one, true),
            new Question(R.string.question_two, false),
            new Question(R.string.question_three, false),
            new Question(R.string.question_four, true),
            new Question(R.string.question_five, true)
    };

    private int mCurrentIndex = 0;

    //Private methods that will be used inside the OnCreate
    //I wrote these not google
    private void updateQuestion() {
            //Get the question instance stored in mCurrentIndex
            //of the mQuestionBank array. then call the getTextRessId
            //method (property) to return the integer that points to the string
            //resource in strings.xml that we want to use.
            int question = mQuestionBank[mCurrentIndex].getTextRessId();

            //Assign the integer for the string resource to the
            //text view so the next question displays.
            mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        }else{
             messageResId = R.string.incorrect_toast;
        }
        //use a toast message to print a message to the
        //screen that will fade out after the duration
        //listed as LENGTH_SHORT
        //this method requires 3 parameters.
        //the context, which will usually be Activity.this,
        //the message, which will usually be a string from strings.xml
        //the length, which will usually be one of the predefined constants
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    //I didn't write this code it was given by google
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Get a 'handle' to the text view in the layout
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        //fetch the widget control from the view and then
        //cast and assign the class variable we setup
        mTrueButton = (Button) findViewById(R.id.true_button);

        //now that I have a handle to the view widget, I can.
        //setup an onclick listener for the widget.
        //This onclicklistener for the widget uses an anonymous inner class.
        //we are passing what we want to have happen onClick.
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkAnswer(true);

            }
        });

        //method declared above. Changes the question to the next in the array.
        updateQuestion();

        //see notes from true button
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });



    }

    //these are methods that we did not write, but google provided
    //used for menus.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
