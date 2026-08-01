package com.malik100ma.androidcalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean newNumber = true;


    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        tvDisplay = findViewById(R.id.textView);
        findViewById(R.id.btn1).setOnClickListener(v -> addDigit("1"));
        findViewById(R.id.btn2).setOnClickListener(v -> addDigit("2"));
        findViewById(R.id.btn3).setOnClickListener(v -> addDigit("3"));
        findViewById(R.id.btn4).setOnClickListener(v -> addDigit("4"));
        findViewById(R.id.btn5).setOnClickListener(v -> addDigit("5"));
        findViewById(R.id.btn6).setOnClickListener(v -> addDigit("6"));
        findViewById(R.id.btn7).setOnClickListener(v -> addDigit("7"));
        findViewById(R.id.btn8).setOnClickListener(v -> addDigit("8"));
        findViewById(R.id.btn9).setOnClickListener(v -> addDigit("9"));
        findViewById(R.id.btn0).setOnClickListener(v -> addDigit("0"));
        findViewById(R.id.btnC).setOnClickListener(v -> clearAll());
        findViewById(R.id.btnDel).setOnClickListener(v -> clearDigit());
        findViewById(R.id.btnPoint).setOnClickListener(v -> addPoint());
    }

    private void addPoint() {
        String text = tvDisplay.getText().toString();

        if (newNumber) {
            tvDisplay.setText("0.");
            newNumber = false;
        } else if (!text.contains(".")) {
            tvDisplay.append(".");
        }
    }

    public void clearDigit() {
        if (newNumber == true) {
            return;
        }
        String text = tvDisplay.getText().toString();
        if (text.length() > 1) {
            tvDisplay.setText(text.substring(0, text.length() - 1));
        } else {
            newNumber = true;
            tvDisplay.setText("0");
        }


    }

    public void clearAll() {
        newNumber = true;
        tvDisplay.setText("0");
        setTextSize();
    }

    public void addDigit(String digit) {
        if (newNumber) {
            tvDisplay.setText(digit);
            newNumber = false;
        } else {
            tvDisplay.append(digit);
        }
        if (tvDisplay.length() > 8) {
            tvDisplay.setTextSize(32);
        } else {
            tvDisplay.setTextSize(64);
        }
    }

    private void setTextSize() {
        if (tvDisplay.length() > 8) {
            tvDisplay.setTextSize(32);
        } else {
            tvDisplay.setTextSize(64);
        }
    }
}