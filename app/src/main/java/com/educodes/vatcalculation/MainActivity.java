package com.educodes.vatcalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutAmount, textInputLayoutRate;
    private Button button1, button8, button18, buttonCalculate;
    private TextView textResultTotalIncluding, textResultVatInIcluding, textResultGrandTotalIncluding, textResultTotalExcluding, textResultVatExcluding, textResultGrandTotalExcluding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        button1.setOnClickListener(this::onClick);
        button8.setOnClickListener(this::onClick);
        button18.setOnClickListener(this::onClick);
        buttonCalculate.setOnClickListener(this::onClick);

    }

    public void Calculate() {

        if (textInputLayoutAmount.getEditText().getText().toString().equals("") || textInputLayoutRate.getEditText().getText().toString().equals("")) {

            Toast.makeText(this, "Hatalı Giriş Yaptınız", Toast.LENGTH_SHORT).show();
        } else {

            float amount = Float.parseFloat(textInputLayoutAmount.getEditText().getText().toString());
            float vatRate = Float.parseFloat(textInputLayoutRate.getEditText().getText().toString());

            textResultTotalIncluding.setText(String.format("%.2f", (amount / (100 + vatRate)) * 100));
            textResultVatInIcluding.setText(String.format("%.2f", (amount / (100 + vatRate)) * vatRate));
            textResultGrandTotalIncluding.setText(String.format("%.2f", amount));

            textResultTotalExcluding.setText(String.format("%.2f", amount));
            textResultVatExcluding.setText(String.format("%.2f", (amount / 100 * (vatRate))));
            textResultGrandTotalExcluding.setText(String.format("%.2f", (amount + (amount / 100 * (vatRate)))));

        }
    }

    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button1:
                textInputLayoutRate.getEditText().setText("1");
                Calculate();
                break;

            case R.id.button8:
                textInputLayoutRate.getEditText().setText("8");
                Calculate();
                break;

            case R.id.button18:
                textInputLayoutRate.getEditText().setText("18");
                Calculate();
                break;

            case R.id.buttonCalculate:
                Calculate();
                break;
        }
    }

    private void initViews() {

        textInputLayoutAmount = findViewById(R.id.textInputLayoutAmount);
        textInputLayoutRate = findViewById(R.id.textInputLayoutRate);
        button1 = findViewById(R.id.button1);
        button8 = findViewById(R.id.button8);
        button18 = findViewById(R.id.button18);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textResultTotalIncluding = findViewById(R.id.textResultTotalIncluding);
        textResultVatInIcluding = findViewById(R.id.textResultVatInIcluding);
        textResultGrandTotalIncluding = findViewById(R.id.textResultGrandTotalIncluding);
        textResultVatInIcluding = findViewById(R.id.textResultVatInIcluding);
        textResultTotalExcluding = findViewById(R.id.textResultTotalExcluding);
        textResultVatExcluding = findViewById(R.id.textResultVatExcluding);
        textResultGrandTotalExcluding = findViewById(R.id.textResultGrandTotalExcluding);

    }
}