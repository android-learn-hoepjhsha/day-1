package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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

        EditText edtNumber1 = findViewById(R.id.edtNumber1);
        EditText edtNumber2 = findViewById(R.id.edtNumber2);
        TextView txtResult = findViewById(R.id.txtResult);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);

        @SuppressLint("SetTextI18n") View.OnClickListener listener = v -> {
            String strNum1 = edtNumber1.getText().toString();
            String strNum2 = edtNumber2.getText().toString();

            if (strNum1.isEmpty() || strNum2.isEmpty()) {
                txtResult.setText("Result: Please enter both numbers");
                return;
            }

            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);
            double result = 0;
            String op = "";
            int id = v.getId();

            if (id == R.id.btnAdd) {
                result = num1 + num2;
                op = "+";
            } else if (id == R.id.btnSubtract) {
                result = num1 - num2;
                op = "-";
            } else if (id == R.id.btnMultiply) {
                result = num1 * num2;
                op = "×";
            } else if (id == R.id.btnDivide) {
                if (num2 == 0) {
                    txtResult.setText("Result: Cannot divide by zero");

                    return;
                }

                result = num1 / num2;
                op = "÷";
            }

            txtResult.setText("Result: " + num1 + " " + op + " " + num2 + " = " + result);
        };

        btnAdd.setOnClickListener(listener);
        btnSubtract.setOnClickListener(listener);
        btnMultiply.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);
    }
}