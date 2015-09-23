package edu.kvcc.cis298.cis298inclass1;

/**
 * Created by aaernie7528 on 9/23/2015.
 */
public class Question {

    //Class level variable to hold the question text
    //In order to get a string from strings.xml, we need
    //an integer as a reference value
    private int mTextRessId;
    //Boolean flag for whether the question is true or false
    private boolean mAnswerTrue;

    //Constructor that accepts 2 parameters. The string id,
    //and the bool answer
    public Question (int textRessId, boolean answerTrue) {
        mTextRessId = textRessId;
        mAnswerTrue = answerTrue;

    }

    //getter for mAnswerTrue
    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    //setter for mAnswerTrue
    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    //getter for mTextRessId
    public int getTextRessId() {
        return mTextRessId;
    }

    //setter for mTextRessId
    public void setTextRessId(int textRessId) {
        mTextRessId = textRessId;
    }
}
