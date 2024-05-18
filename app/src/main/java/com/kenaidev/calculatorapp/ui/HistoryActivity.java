package com.kenaidev.calculatorapp.ui;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.kenaidev.calculatorapp.databinding.ActivityHistoryBinding;
import com.kenaidev.calculatorapp.db.Calculation;
import com.kenaidev.calculatorapp.viewmodel.OperationViewModel;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private OperationViewModel viewModel;
    public ActivityHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(OperationViewModel.class);
        viewModel.allCalculationsLiveData.observe(this, new Observer<List<Calculation>>() {
            @Override
            public void onChanged(List<Calculation> calculations) {
                Adapter adapter = new Adapter(calculations);
                binding.rcvItem.setAdapter(adapter);
            }
        });

        viewModel.getList();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rcvItem.setLayoutManager(layoutManager);
        binding.rcvItem.setHasFixedSize(true);


    }
}