package com.kenaidev.calculatorapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CalculationDao{
    @Query("SELECT * FROM calculation")
    List<Calculation> getAllCalculations();

    @Insert
    void insert(Calculation calculation);
}