package com.kenaidev.calculatorapp.db;


import androidx.room.Database;

import androidx.room.RoomDatabase;

@Database(entities = {Calculation.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CalculationDao calculationDao();

}

