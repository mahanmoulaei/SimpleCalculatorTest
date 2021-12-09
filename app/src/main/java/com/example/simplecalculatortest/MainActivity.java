package com.example.simplecalculatortest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.icu.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextCalculation;
    TextView textViewGeneratedOperation;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDecimal, buttonDash, buttonClear, buttonGenerate, buttonQuit, buttonValidate, buttonShowAll;
    Operation generatedOperation;
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private boolean activateValidationButton = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Hides The Notification Bar

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide(); //Hides The Application Title

        setContentView(R.layout.activity_main);

        InitializeScreenComponents();
    }

    private void InitializeScreenComponents() {
        editTextCalculation = findViewById(R.id.editTextCalculation);
        editTextCalculation.setText(null);

        textViewGeneratedOperation = findViewById(R.id.textViewGeneratedOperation);
        textViewGeneratedOperation.setText(null);

        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);

        buttonDecimal = findViewById(R.id.buttonDecimal);
        buttonDecimal.setOnClickListener(this);

        buttonDash = findViewById(R.id.buttonDash);
        buttonDash.setOnClickListener(this);

        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);

        buttonGenerate = findViewById(R.id.buttonGenerate);
        buttonGenerate.setOnClickListener(this);

        buttonQuit = findViewById(R.id.buttonQuit);
        buttonQuit.setOnClickListener(this);

        buttonValidate = findViewById(R.id.buttonValidate);
        buttonValidate.setOnClickListener(this);

        buttonShowAll = findViewById(R.id.buttonShowAll);
        buttonShowAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button0: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button0.getText().toString());
                break;
            }
            case R.id.button1: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button1.getText().toString());
                break;
            }
            case R.id.button2: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button2.getText().toString());
                break;
            }
            case R.id.button3: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button3.getText().toString());
                break;
            }
            case R.id.button4: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button4.getText().toString());
                break;
            }
            case R.id.button5: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button5.getText().toString());
                break;
            }
            case R.id.button6: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button6.getText().toString());
                break;
            }
            case R.id.button7: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button7.getText().toString());
                break;
            }
            case R.id.button8: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button8.getText().toString());
                break;
            }
            case R.id.button9: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + button9.getText().toString());
                break;
            }
            case R.id.buttonDash: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + buttonDash.getText().toString());
                break;
            }
            case R.id.buttonDecimal: {
                editTextCalculation.setText(editTextCalculation.getText().toString() + buttonDecimal.getText().toString());
                break;
            }
            case R.id.buttonGenerate: {
                generatedOperation = MathOperationGenerator.GenerateOperation();
                textViewGeneratedOperation.setText(String.valueOf(generatedOperation));
                activateValidationButton = true;
                break;
            }
            case R.id.buttonClear: {
                editTextCalculation.setText(null);
                break;
            }
            case R.id.buttonQuit: {
                System.exit(0);
                break;
            }
            case R.id.buttonValidate: {
                if (activateValidationButton == true) {
                    Double rightNumber = new Double(generatedOperation.getRightNumber());
                    Double leftNumber = new Double(generatedOperation.getLeftNumber());
                    Operator operator = generatedOperation.getOperator();
                    //Toast.makeText(this, operator.toString(), Toast.LENGTH_SHORT).show();
                    switch (operator.toString()) {
                        case "MINUS": {
                            Double answer = leftNumber - rightNumber;
                            if (Double.compare(Double.valueOf(editTextCalculation.getText().toString()), Double.valueOf(decimalFormat.format(answer))) == 0) {
                                Toast.makeText(this, "Correct !!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Incorrect !!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                        case "PLUS": {
                            Double answer = leftNumber + rightNumber;
                            if (Double.compare(Double.valueOf(editTextCalculation.getText().toString()), Double.valueOf(decimalFormat.format(answer))) == 0) {
                                Toast.makeText(this, "Correct !!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Incorrect !!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                        case "MULTIPLIER": {
                            Double answer = leftNumber * rightNumber;
                            if (Double.compare(Double.valueOf(editTextCalculation.getText().toString()), Double.valueOf(decimalFormat.format(answer))) == 0) {
                                Toast.makeText(this, "Correct !!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "Incorrect !!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                        case "DIVIDER": {
                            Double answer = leftNumber / rightNumber;
                            if (Double.compare(Double.valueOf(editTextCalculation.getText().toString()), Double.valueOf(decimalFormat.format(answer))) == 0) {
                                //Toast.makeText(this, "Correct !!", Toast.LENGTH_SHORT).show();
                                Toast.makeText(this, "Correct !! " + Double.valueOf(decimalFormat.format(answer)).toString(), Toast.LENGTH_SHORT).show();
                            } else {
                                //Toast.makeText(this, "Incorrect !!", Toast.LENGTH_SHORT).show();
                                Toast.makeText(this, "Incorrect !! " + Double.valueOf(decimalFormat.format(answer)).toString(), Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                    }
                } else {
                    Toast.makeText(this, "You Have To Generate An Operation First!!!", Toast.LENGTH_SHORT).show();
                }
            }
            case R.id.buttonShowAll: {

                break;
            }
        }
    }
}