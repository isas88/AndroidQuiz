package com.example.isas88.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;


public class MainActivity extends AppCompatActivity {

    //initialize the global variables
    CheckBox quiz1_Java;
    CheckBox quiz1_Cplusplus;
    CheckBox quiz1_Kotlin;
    RadioButton quiz2_True;
    EditText quiz3_Text;
    RadioButton quiz4_500;
    RadioButton quiz5_styles;
    int correctAnswers;
    int totalQuestions;
    String chkText;
    int scorePercentage;
    LayoutInflater inflater;
    View layout;
    TextView text;
    FrameLayout frame20;
    FrameLayout frame40;
    FrameLayout frame60;
    FrameLayout frame80;
    FrameLayout frame100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set view global variables mapping their ID's defined in xml
        quiz1_Java=findViewById(R.id.java_checkbox);
        quiz1_Cplusplus=findViewById(R.id.cplusplus_checkbox);
        quiz1_Kotlin=findViewById(R.id.kotlin_checkbox);
        quiz2_True=findViewById(R.id.true_radiobutton);
        quiz3_Text=findViewById(R.id.quiz3_edittext);
        quiz4_500=findViewById(R.id.correct500_radiobutton);
        quiz5_styles=findViewById(R.id.styles_radiobutton);

        inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout));
        text = layout.findViewById(R.id.text);
        frame20 = layout.findViewById(R.id.percent20);
        frame40 = layout.findViewById(R.id.percent40);
        frame60 = layout.findViewById(R.id.percent60);
        frame80 = layout.findViewById(R.id.percent80);
        frame100 =layout.findViewById(R.id.percent100);

        //initialize the #of questions
        totalQuestions = 5;
        chkText = "";
    }

    public void showResult(View V){

        //reset correct answers & score% to recalculate when submit button is pressed
        correctAnswers = 0;
        scorePercentage = 0;

        //increment correctAnswers variable for every correct answer
        if (quiz1_Java.isChecked() && quiz1_Cplusplus.isChecked() && quiz1_Kotlin.isChecked()){
            correctAnswers ++;
        }

        if (quiz2_True.isChecked()){
            correctAnswers ++;
        }

        chkText = quiz3_Text.getText().toString().toUpperCase();
        if (chkText.equals("ONCLICK()") || chkText.equals("ONCLICK") || chkText.equals("ANDROID:ONCLICK()") || chkText.equals("ANDROID:ONCLICK")
            || chkText.equals("ONCLICK();") || chkText.equals("ANDROID:ONCLICK();") ) {
            correctAnswers ++;
        }

        if (quiz4_500.isChecked()){
            correctAnswers ++;
        }

        if (quiz5_styles.isChecked()){
            correctAnswers ++;
        }

        //calculate score percentage based on # of correct answers
        scorePercentage = (correctAnswers*100)/totalQuestions;


        //Toast notification layout population based on the score
        // to display the Toast notification for the quiz results
        text.setText("Score: " +scorePercentage +"%");

        //set the color of each FrameLayout based on the percentage scored
        switch (scorePercentage){
            case 20:
                frame20.setBackgroundColor(getResources().getColor(R.color.percent_fail));
                text.setTextColor(getResources().getColor(R.color.percent_fail));
                frame40.setBackgroundResource(0);
                frame60.setBackgroundResource(0);
                frame80.setBackgroundResource(0);
                frame100.setBackgroundResource(0);
                break;

            case 40:
                frame20.setBackgroundColor(getResources().getColor(R.color.percent_fail));
                frame40.setBackgroundColor(getResources().getColor(R.color.percent_fail));
                text.setTextColor(getResources().getColor(R.color.percent_fail));
                frame60.setBackgroundResource(0);
                frame80.setBackgroundResource(0);
                frame100.setBackgroundResource(0);
                break;

            case 60:
                frame20.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame40.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame60.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame80.setBackgroundResource(0);
                frame100.setBackgroundResource(0);
                text.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;

            case 80:
                frame20.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame40.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame60.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame80.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame100.setBackgroundResource(0);
                text.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;

            case 100:
                frame20.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame40.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame60.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame80.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                frame100.setBackgroundColor(getResources().getColor(R.color.percent_pass));
                text.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;

            case 0:
                frame20.setBackgroundResource(0);
                frame40.setBackgroundResource(0);
                frame60.setBackgroundResource(0);
                frame80.setBackgroundResource(0);
                frame100.setBackgroundResource(0);
                text.setTextColor(getResources().getColor(R.color.percent_fail));
                break;

        }

        //show the toast notification
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

}
