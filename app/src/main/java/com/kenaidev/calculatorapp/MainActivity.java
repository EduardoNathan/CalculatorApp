package com.kenaidev.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.kenaidev.calculatorapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlus, btnMinus, btnDivision, btnTimes;
    EditText edtFirstNumber, edtSecondNumber;
    TextView txtResult;
    Button btnOpen;

    int numeroUm, numeroDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnDivision = findViewById(R.id.btn_division);
        btnTimes = findViewById(R.id.btn_times);
        btnOpen = findViewById(R.id.btn_open);

        edtFirstNumber = findViewById(R.id.edt_first_number);
        edtSecondNumber = findViewById(R.id.edt_second_number);

        txtResult = findViewById(R.id.txt_result);


        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnTimes.setOnClickListener(this);
        btnOpen.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (edtFirstNumber.getText().toString().isEmpty() || edtSecondNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha os campos.", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btn_plus) {

            numeroUm = Integer.parseInt(edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(edtSecondNumber.getText().toString());

            int resultado = numeroUm + numeroDois;

            txtResult.setText(String.valueOf(resultado));

        } else if (view.getId() == R.id.btn_minus) {

            numeroUm = Integer.parseInt(edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(edtSecondNumber.getText().toString());

            int resultado = numeroUm - numeroDois;

            txtResult.setText(String.valueOf(resultado));

        } else if (view.getId() == R.id.btn_division) {

            numeroUm = Integer.parseInt(edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(edtSecondNumber.getText().toString());

            if (numeroDois != 0) {
                int resultado = numeroUm / numeroDois;
                txtResult.setText(String.valueOf(resultado));

            } else {
                Toast.makeText(this, "Não é possível dividir por 0.", Toast.LENGTH_SHORT).show();
            }

        } else if (view.getId() == R.id.btn_times) {

            numeroUm = Integer.parseInt(edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(edtSecondNumber.getText().toString());

            int resultado = numeroUm * numeroDois;

            txtResult.setText(String.valueOf(resultado));
        }}
}