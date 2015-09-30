package edu.kvcc.cis298.cis298inclass1;

/**
 * Created by aaernie7528 on 9/23/2015.
 */
public class Question {

    //Class level variable to hold the question text
    //In order to get a string from strings.xml, we need
    //an integer as a reference value
    private int mTextResId;
    //Boolean flag for whether the question is true or false
    private int mCorrectAnswerResId;

    public int[] mChoiceResIds;

    //Constructor that accepts 2 parameters. The string id,
    //and the bool answer
    public Question (int textResId, int correctAnswerResId, int [] choiceResIds) {
        mTextResId = textResId;
        mCorrectAnswerResId = correctAnswerResId;
        mChoiceResIds = choiceResIds;

    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getCorrectAnswerResId() {
        return mCorrectAnswerResId;
    }

    public void setCorrectAnswerResId(int correctAnswerResId) {
        mCorrectAnswerResId = correctAnswerResId;
    }

    public int[] getChoiceResIds() {
        return mChoiceResIds;
    }

    public void setChoiceResIds(int[] choiceResIds) {
        mChoiceResIds = choiceResIds;
    }
}
