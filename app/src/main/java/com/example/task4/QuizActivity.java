package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private MaterialRadioButton option1,option2,option3,option4;
    private int currentQuestionIndex = 0, score=0;
    private List<String> questions ;
    private TextView questionView;
    private Button nextButton;
    private Map<String,  Map<String,Boolean>> questionAnswerMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionView = findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.radioButton1);
        option2 = findViewById(R.id.radioButton2);
        option3 = findViewById(R.id.radioButton3);
        option4 = findViewById(R.id.radioButton4);
        nextButton = findViewById(R.id.nextButton);

        questionAnswerMap = Utils.getScienceQuestions();

        questions = new ArrayList<>(questionAnswerMap.keySet());

        showQuestion();
    }

    private void showQuestion() {
        questionView.setText(questions.get(currentQuestionIndex));

        ArrayList<String> questionKey = new ArrayList(Objects.requireNonNull(questionAnswerMap.get(questions.get(currentQuestionIndex))).keySet());

        Log.d("size",(Integer.toString(questionKey.size())));
//        option1.setText(questionKey.get(0));
//        option2.setText(questionKey.get(1));
//        option3.setText(questionKey.get(2));
//        option4.setText(questionKey.get(3));


    }
}