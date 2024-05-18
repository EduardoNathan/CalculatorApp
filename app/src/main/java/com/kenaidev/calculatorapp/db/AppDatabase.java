package com.kenaidev.calculatorapp.db;

import android.content.Context;

import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Calculation.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CalculationDao calculationDao();

    private static AppDatabase mAppDatabase;

    public static AppDatabase getInstance(Context context) {
        if (mAppDatabase == null) {
            mAppDatabase = Room.databaseBuilder(context,
                            AppDatabase.class, "calculation-db.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return mAppDatabase;
    }
}

