package com.geektech.hw_7_kutman_kalmurzaev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result_Activity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = findViewById(R.id.text2);
        button = findViewById(R.id.btn_clear);
        String result = getIntent().getStringExtra("key1");
        textView.setText(result);
        Log.d("shamal", "onCreate Result");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                System.exit(1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("shamal", "onStart Result");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("shamal", "onResume  Result");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("shamal", "onPause  Result");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("shamal", "onRestart Result");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("shamal", "onStop Resultn");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("shamal", "onDestroy Result");
    }

}