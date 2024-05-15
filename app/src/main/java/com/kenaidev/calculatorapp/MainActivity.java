package com.kenaidev.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.kenaidev.calculatorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int numeroUm, numeroDois;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnDivision.setOnClickListener(this);
        binding.btnTimes.setOnClickListener(this);

        binding.btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (binding.edtFirstNumber.getText().toString().isEmpty() || binding.edtSecondNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "Preencha os campos.", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btn_plus) {

            numeroUm = Integer.parseInt(binding.edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(binding.edtSecondNumber.getText().toString());

            int resultado = numeroUm + numeroDois;

            binding.txtResult.setText(String.valueOf(resultado));

        } else if (view.getId() == R.id.btn_minus) {

            numeroUm = Integer.parseInt(binding.edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(binding.edtSecondNumber.getText().toString());

            int resultado = numeroUm - numeroDois;

            binding.txtResult.setText(String.valueOf(resultado));

        } else if (view.getId() == R.id.btn_division) {

            numeroUm = Integer.parseInt(binding.edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(binding.edtSecondNumber.getText().toString());

            if (numeroDois != 0) {
                int resultado = numeroUm / numeroDois;
                binding.txtResult.setText(String.valueOf(resultado));

            } else {
                Toast.makeText(this, "Não é possível dividir por 0.", Toast.LENGTH_SHORT).show();
            }

        } else if (view.getId() == R.id.btn_times) {

            numeroUm = Integer.parseInt(binding.edtFirstNumber.getText().toString());
            numeroDois = Integer.parseInt(binding.edtSecondNumber.getText().toString());

            int resultado = numeroUm * numeroDois;

            binding.txtResult.setText(String.valueOf(resultado));
        }
    }
}