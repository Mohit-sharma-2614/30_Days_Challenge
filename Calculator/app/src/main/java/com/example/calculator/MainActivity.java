package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNum1,etNum2;
    Button btPlus,btMinus,btMultiply,btDevide;
    TextView tvAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1=findViewById(R.id.etNum1);
        etNum2=findViewById(R.id.etNum2);

        btPlus=findViewById(R.id.btAdd);
        btMinus=findViewById(R.id.btSubtract);
        btMultiply=findViewById(R.id.btMultiply);
        btDevide=findViewById(R.id.btDevide);

        tvAns=findViewById(R.id.tvAns);

        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1,num2,ans;
                num1 = Integer.parseInt(etNum1.getText().toString());
                num2 = Integer.parseInt(etNum2.getText().toString());
                ans = num1 + num2;
                tvAns.setText("Ans is = "+ans);
            }
        });
        btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1,num2,ans;
                num1 = Integer.parseInt(etNum1.getText().toString());
                num2 = Integer.parseInt(etNum2.getText().toString());
                ans = num1 - num2;
                tvAns.setText("Ans is = "+ans);
            }
        });
        btMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1,num2,ans;
                num1 = Integer.parseInt(etNum1.getText().toString());
                num2 = Integer.parseInt(etNum2.getText().toString());
                ans = num1 * num2;
                tvAns.setText("Ans is = "+ans);
            }
        });
        btDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1,num2,ans;
                num1 = Integer.parseInt(etNum1.getText().toString());
                num2 = Integer.parseInt(etNum2.getText().toString());
                ans = num1 / num2;
                tvAns.setText("Ans is = "+ans);
            }
        });
    }
}