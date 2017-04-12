package com.example.android.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.quizz.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout question1;
    private LinearLayout question2;
    private LinearLayout question3;
    private LinearLayout question4;
    private LinearLayout question5;
    private Button checkButton;
    private LinearLayout result_layout;

    private RadioGroup radioGroupWorld;
    private RadioButton radioButtonGermany;
    private RadioButton radioButtonBrasil;
    private RadioButton radioButtonArgentina;
    private RadioButton radioButtonItaly;


    private EditText editTextMascot;

    private CheckBox checkBoxIf;
    private CheckBox checkBoxSuper;
    private CheckBox checkBoxInstanceOf;
    private CheckBox checkBoxAwait;

    private RadioGroup radioGroupEuropean;
    private RadioButton radioButtonPortugal;
    private RadioButton radioButtonRussia;
    private RadioButton radioButtonFrance;
    private RadioButton radioButtonSlovenia;

    private RadioGroup radioGroupCouch;
    private RadioButton radioButtonMourinho;
    private RadioButton radioButtonMenotti;
    private RadioButton radioButtonPozzo;
    private RadioButton radioButtonGaal;

    private TextView resultTextView;
    private TextView messageTextView;
    private Button tryAgainButton;

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question1 = (LinearLayout) findViewById(R.id.question1);
        question2 = (LinearLayout) findViewById(R.id.question2);
        question3 = (LinearLayout) findViewById(R.id.question3);
        question4 = (LinearLayout) findViewById(R.id.question4);
        question5 = (LinearLayout) findViewById(R.id.question5);
        checkButton = (Button) findViewById(R.id.check_button);
        result_layout = (LinearLayout) findViewById(R.id.result_layout);

        radioGroupWorld = (RadioGroup) findViewById(R.id.radioGroupWorld);
        radioButtonGermany = (RadioButton) findViewById(R.id.radioButtonGermany);
        radioButtonBrasil = (RadioButton) findViewById(R.id.radioButtonBrasil);
        radioButtonArgentina = (RadioButton) findViewById(R.id.radioButtonArgentina);
        radioButtonItaly = (RadioButton) findViewById(R.id.radioButtonItaly);

        editTextMascot = (EditText) findViewById(R.id.mascot);

        checkBoxIf = (CheckBox) findViewById(R.id.checkBoxIf);
        checkBoxSuper = (CheckBox) findViewById(R.id.checkBoxSuper);
        checkBoxInstanceOf = (CheckBox) findViewById(R.id.checkBoxInstance);
        checkBoxAwait = (CheckBox) findViewById(R.id.checkBoxAwait);

        radioGroupEuropean = (RadioGroup) findViewById(R.id.radioGroupEuropean);
        radioButtonPortugal = (RadioButton) findViewById(R.id.radioButtonPortugal);
        radioButtonRussia = (RadioButton) findViewById(R.id.radioButtonRussia);
        radioButtonFrance = (RadioButton) findViewById(R.id.radioButtonFrance);
        radioButtonSlovenia = (RadioButton) findViewById(R.id.radioButtonSlovenia);


        radioGroupCouch = (RadioGroup) findViewById(R.id.radioGroupCouch);
        radioButtonMourinho = (RadioButton) findViewById(R.id.radioButtonMourinho);
        radioButtonMenotti = (RadioButton) findViewById(R.id.radioButtonMenotti);
        radioButtonPozzo = (RadioButton) findViewById(R.id.radioButtonPozzo);
        radioButtonGaal = (RadioButton) findViewById(R.id.radioButtonGaal);

        resultTextView = (TextView) findViewById(R.id.result);
        messageTextView = (TextView) findViewById(R.id.message);
        tryAgainButton = (Button) findViewById(R.id.try_button);
    }

    public void calculateScore(View view) {
        resultQuestion1(view);
        resultQuestion2(view);
        resultQuestion3(view);
        resultQuestion4(view);
        resultQuestion5(view);

        question1.setVisibility(View.GONE);
        question2.setVisibility(View.GONE);
        question3.setVisibility(View.GONE);
        question4.setVisibility(View.GONE);
        question5.setVisibility(View.GONE);
        checkButton.setVisibility(View.GONE);

        if (score == 5) {
            messageTextView.setText("Excellent");
            resultTextView.setText("Your score is 5/5");
        } else if (score == 4) {
            messageTextView.setText("Very good");
            resultTextView.setText("Your score is 4/5");
        } else if (score == 3) {
            messageTextView.setText("Good");
            resultTextView.setText("Your score is 3/5");
        } else if (score == 2) {
            messageTextView.setText("Try Again");
            resultTextView.setText("Your score is 2/5");
        } else if (score == 1) {
            messageTextView.setText("Try Again");
            resultTextView.setText("Your score is 1/5");
        } else {
            messageTextView.setText("Try Again");
            resultTextView.setText("Your score is 0/5");
        }
        result_layout.setVisibility(View.VISIBLE);
    }

    public void resultQuestion1 (View view) {

        if (radioGroupWorld.getCheckedRadioButtonId() != -1)
        {
            // one of the radio buttons is checked
            if (radioButtonBrasil.isChecked()) {
                score++;
            }
        }

    }

    public void resultQuestion2 (View view) {
        String mascot = String.valueOf(editTextMascot.getText());

        if (mascot.equals("Duke") || mascot.equals("duke") || mascot.equals("DUKE")) {
            score++;
        }
    }

    public void resultQuestion3 (View view) {
        if (checkBoxIf.isChecked() && checkBoxSuper.isChecked() && checkBoxInstanceOf.isChecked() && !checkBoxAwait.isChecked()) {
            score++;
        }
    }

    public void resultQuestion4 (View view) {

        if (radioGroupEuropean.getCheckedRadioButtonId() != -1)
        {
            // one of the radio buttons is checked
            if (radioButtonPortugal.isChecked()) {
                score++;
            }
        }

    }

    public void resultQuestion5 (View view) {

        if (radioGroupCouch.getCheckedRadioButtonId() != -1)
        {
            // one of the radio buttons is checked
            if (radioButtonPozzo.isChecked()) {
                score++;
            }
        }

    }

    public void reset (View view) {
        question1.setVisibility(View.VISIBLE);
        question2.setVisibility(View.VISIBLE);
        question3.setVisibility(View.VISIBLE);
        question4.setVisibility(View.VISIBLE);
        question5.setVisibility(View.VISIBLE);
        checkButton.setVisibility(View.VISIBLE);

        result_layout.setVisibility(View.GONE);

        radioButtonBrasil.setChecked(false);
        radioButtonGermany.setChecked(false);
        radioButtonItaly.setChecked(false);
        radioButtonArgentina.setChecked(false);

        editTextMascot.setText("");

        checkBoxIf.setChecked(false);
        checkBoxSuper.setChecked(false);
        checkBoxInstanceOf.setChecked(false);
        checkBoxAwait.setChecked(false);

        radioButtonPortugal.setChecked(false);
        radioButtonRussia.setChecked(false);
        radioButtonFrance.setChecked(false);
        radioButtonSlovenia.setChecked(false);

        radioButtonGaal.setChecked(false);
        radioButtonPozzo.setChecked(false);
        radioButtonMourinho.setChecked(false);
        radioButtonMenotti.setChecked(false);

        score = 0;
    }
}
