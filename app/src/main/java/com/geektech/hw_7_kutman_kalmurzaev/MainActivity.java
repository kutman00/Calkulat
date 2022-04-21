package com.geektech.hw_7_kutman_kalmurzaev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double firstVar, secondVar;
    private Boolean inOperationClick;
    private String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickNumber(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_tochka:
                setNumber(".");
                break;
            case R.id.btn_plus_minus:
                setNumber("-");
                break;
            case R.id.btn_clear:
                textView.setText("0");
                inOperationClick = false;
                firstVar = 0.0;
                secondVar = 0.0;
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void onOperation(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                firstVar = Double.parseDouble(textView.getText().toString());
                inOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                firstVar = Double.parseDouble(textView.getText().toString());
                inOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_umnojenie:
                firstVar = Double.parseDouble(textView.getText().toString());
                inOperationClick = true;
                operation = "*";
                break;
            case R.id.btn_delenie:
                firstVar = Double.parseDouble(textView.getText().toString());
                inOperationClick = true;
                operation = "/";
                break;
            case R.id.btn_percent:
                firstVar = Double.parseDouble(textView.getText().toString());
                inOperationClick = true;
                operation = "%";
                break;

            case R.id.btn_ravno:
                secondVar = Double.parseDouble(textView.getText().toString());
                Double result = 0.0;

                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        textView.setText(result.toString());
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        textView.setText(result.toString());
                        break;
                    case "*":
                        result = firstVar * secondVar;
                        textView.setText(result.toString());
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        textView.setText(result.toString());
                        break;
                    case "%":
                        result = firstVar / 100.0f;
                        textView.setText(result.toString());
                        break;
                }
        }
    }

    private void setNumber(String number) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(number);
        } else if (inOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        inOperationClick = false;
    }
}