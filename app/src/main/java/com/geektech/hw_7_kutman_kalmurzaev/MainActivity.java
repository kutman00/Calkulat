package com.geektech.hw_7_kutman_kalmurzaev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_Result;
    private Double firstVar, secondVar;
    private Boolean inOperationClick;
    private String operation;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Result = findViewById(R.id.tv_result);
        btn_next = findViewById(R.id.btn_next);
        Log.d("shamal", "onCreate Main");
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = tv_Result.getText().toString();
                Intent intent = new Intent(MainActivity.this, Result_Activity.class);
                intent.putExtra("key1", result);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("shamal", "onStart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("shamal", "onResume Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("shamal", "onPause Main");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("shamal", "onRestart Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("shamal", "onStop Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal", "onDestroy Main");
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
                tv_Result.setText("0");
                inOperationClick = false;
                firstVar = 0.0;
                secondVar = 0.0;
                break;
        }
        btn_next.setVisibility(View.GONE);
    }

    @SuppressLint("NonConstantResourceId")
    public void onOperation(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                inOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                inOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_umnojenie:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                inOperationClick = true;
                operation = "*";
                break;
            case R.id.btn_delenie:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                inOperationClick = true;
                operation = "/";
                break;
            case R.id.btn_percent:
                firstVar = Double.parseDouble(tv_Result.getText().toString());
                inOperationClick = true;
                operation = "%";
                break;

            case R.id.btn_ravno:
                secondVar = Double.parseDouble(tv_Result.getText().toString());
                Double result = 0.0;

                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "*":
                        result = firstVar * secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "%":
                        result = firstVar / 100.0f;
                        tv_Result.setText(result.toString());
                        break;
                }
                btn_next.setVisibility(View.VISIBLE);
        }
    }

    private void setNumber(String number) {
        if (tv_Result.getText().toString().equals("0")) {
            tv_Result.setText(number);
        } else if (inOperationClick) {
            tv_Result.setText(number);
        } else {
            tv_Result.append(number);
        }
        inOperationClick = false;
    }
}