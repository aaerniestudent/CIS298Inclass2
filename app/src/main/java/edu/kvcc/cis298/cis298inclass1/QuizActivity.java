package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    //create a class level Widget variables so
    //that we will have access to stuff from the view
    //no value yet. just declared the variables
    private Button mTrueButton;
    private Button mFalseButton;

    //I didn't write this code it was given by google
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //fetch the widget control from the view and then
        // cast and assign the class variable we setup
        mTrueButton = (Button) findViewById(R.id.true_button);

        //now that I have a handle to the view widget, I can.
        //setup an onclick listener for the widget.
        //This onclicklistenr for the widget uses an anonymous inner class.
        //we are passing what we want to have happen onClick.
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use a toast message to print a message to the
                //screen that will fade out after the duration
                //listed as LENGTH_SHORT
                //this method requires 3 parameters.
                //the context, which will usually be Activity.this,
                //the message, which will usually be a string from strings.xml
                //the length, which will usually be one of the predefined constants
                Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
            }
        });

        //see notes from true button
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT).show();
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
