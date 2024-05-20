package com.kenaidev.calculatorapp.ui;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.kenaidev.calculatorapp.viewmodel.OperationViewModel;
import com.kenaidev.calculatorapp.model.Operations;
import com.kenaidev.calculatorapp.R;
import com.kenaidev.calculatorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private OperationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        viewModel = new ViewModelProvider(this).get(OperationViewModel.class);
        viewModel.resultLiveData.observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double result) {
                binding.txtResult.setText(String.valueOf(result));
                cleanFields();
                Toast.makeText(MainActivity.this, R.string.string_toast_success_stored,
                        Toast.LENGTH_SHORT).show();

            }
        });

        viewModel.errorLiveData.observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnOpen.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);

        });

        binding.btnPlus.setOnClickListener(v -> viewModel.handleOperation(
                binding.edtFirstNumber.getText().toString(),
                binding.edtSecondNumber.getText().toString(),
                Operations.SUM
        ));

        binding.btnMinus.setOnClickListener(v -> viewModel.handleOperation(
                binding.edtFirstNumber.getText().toString(),
                binding.edtSecondNumber.getText().toString(),
                Operations.SUB
        ));

        binding.btnDivision.setOnClickListener(v -> viewModel.handleOperation(
                binding.edtFirstNumber.getText().toString(),
                binding.edtSecondNumber.getText().toString(),
                Operations.DIV
        ));

        binding.btnTimes.setOnClickListener(v -> viewModel.handleOperation(
                binding.edtFirstNumber.getText().toString(),
                binding.edtSecondNumber.getText().toString(),
                Operations.MULTI
        ));

    }

    private void cleanFields() {
        binding.edtFirstNumber.setText("");
        binding.edtSecondNumber.setText("");
    }
}