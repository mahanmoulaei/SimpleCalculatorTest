package com.example.simplecalculatortest;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ShowAllActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonGoBackToCalculator;
    TextView textViewShowAllGeneratedOperations;
    String AllGeneratedOperations = "", AnswerPercentage = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Hides The Notification Bar

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide(); //Hides The Application Title

        setContentView(R.layout.activity_showall);

        InitializeScreenComponents();

        AllGeneratedOperations = getIntent().getStringExtra("AllGeneratedOperations");

        AnswerPercentage = getIntent().getStringExtra("AnswerPercentage");

        ShowAllOperationsHistory();
    }

    private void ShowAllOperationsHistory() {
        AllGeneratedOperations += AnswerPercentage;
        textViewShowAllGeneratedOperations.setText(AllGeneratedOperations);
        textViewShowAllGeneratedOperations.setMovementMethod(new ScrollingMovementMethod());
    }

    private void InitializeScreenComponents() {
        textViewShowAllGeneratedOperations = findViewById(R.id.textViewShowAllGeneratedOperations);
        textViewShowAllGeneratedOperations.setText(null);

        buttonGoBackToCalculator = findViewById(R.id.buttonGoBackToCalculator);
        buttonGoBackToCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.buttonGoBackToCalculator: {
                finish();
            }
        }
    }
}
