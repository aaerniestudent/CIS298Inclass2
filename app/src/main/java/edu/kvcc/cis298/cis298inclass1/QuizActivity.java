package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup mQuestionGroup;
    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;
    private RadioButton mChoice4;
    private Button mSubmitButton;
    private Button mNextButton;
    //variable for the question string
    private TextView mQuestionTextView;


    //The questions that will be used it is an array of type
    //question. that contains 5 questions. it is a hard coded
    //array. in most apps, you would want your data to come from
    //somewhere else. (database, internet) Not be hard coded.
    private Question [] mQuestionBank = new Question[] {
            new Question(R.string.question_1_multiple,R.id.multiple_choice_3,
                    new int[]{R.string.question_1_choice_1, R.string.question_1_choice_2,
                    R.string.question_1_choice_3, R.string.question_1_choice_4}),
            new Question(R.string.question_2_multiple,R.id.multiple_choice_2,
                    new int[]{R.string.question_2_choice_1, R.string.question_2_choice_2,
                    R.string.question_2_choice_3, R.string.question_2_choice_4})
    };

    private int mCurrentIndex = 0;

    //Private methods that will be used inside the OnCreate
    //I wrote these not google
    private void updateQuestion() {
        //Get the question instance stored in mCurrentIndex
        //of the mQuestionBank array. then call the getTextResId
        //method (property) to return the integer that points to the string
        //resource in strings.xml that we want to use.
        int question = mQuestionBank[mCurrentIndex].getTextResId();

        //Assign the integer for the string resource to the
        //text view so the next question displays.
        mQuestionTextView.setText(question);

        int[] choices = mQuestionBank[mCurrentIndex].getChoiceResIds();
        mChoice1.setText(choices[0]);
        mChoice2.setText(choices[1]);
        mChoice3.setText(choices[2]);
        mChoice4.setText(choices[3]);
    }

    private void checkAnswer(int selectedRadioButtonId){
        int correctAnswer = mQuestionBank[mCurrentIndex].getCorrectAnswerResId();
        int messageResId = 0;
        if (correctAnswer == selectedRadioButtonId) {
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

        mQuestionGroup = (RadioGroup) findViewById(R.id.multiple_group);

        mChoice1 = (RadioButton) findViewById(R.id.multiple_choice_1);
        mChoice2 = (RadioButton) findViewById(R.id.multiple_choice_2);
        mChoice3 = (RadioButton) findViewById(R.id.multiple_choice_3);
        mChoice4 = (RadioButton) findViewById(R.id.multiple_choice_4);


        //method declared above. Changes the question to the next in the array.
        updateQuestion();
        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedAnswerId = mQuestionGroup.getCheckedRadioButtonId();
                checkAnswer(selectedAnswerId);
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
