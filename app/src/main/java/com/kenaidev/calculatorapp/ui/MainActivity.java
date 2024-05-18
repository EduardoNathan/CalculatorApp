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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnDivision.setOnClickListener(this);
        binding.btnTimes.setOnClickListener(this);

        binding.btnOpen.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);

        });
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_plus) {

            viewModel.handleOperation(
                    binding.edtFirstNumber.getText().toString(),
                    binding.edtSecondNumber.getText().toString(),
                    Operations.SUM
            );

        } else if (view.getId() == R.id.btn_minus) {

            viewModel.handleOperation(
                    binding.edtFirstNumber.getText().toString(),
                    binding.edtSecondNumber.getText().toString(),
                    Operations.SUBTRACTION
            );


        } else if (view.getId() == R.id.btn_division) {

            viewModel.handleOperation(
                    binding.edtFirstNumber.getText().toString(),
                    binding.edtSecondNumber.getText().toString(),
                    Operations.DIVISION
            );

        } else if (view.getId() == R.id.btn_times) {

            viewModel.handleOperation(
                    binding.edtFirstNumber.getText().toString(),
                    binding.edtSecondNumber.getText().toString(),
                    Operations.MULTIPLICATION
            );

        }
    }

    private void cleanFields() {
        binding.edtFirstNumber.setText("");
        binding.edtSecondNumber.setText("");
    }
}