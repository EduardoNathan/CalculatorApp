package com.kenaidev.calculatorapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.kenaidev.calculatorapp.R;
import com.kenaidev.calculatorapp.databinding.ActivityHistoryBinding;

public class HistoryActivity extends AppCompatActivity {
    public ActivityHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


    }
}