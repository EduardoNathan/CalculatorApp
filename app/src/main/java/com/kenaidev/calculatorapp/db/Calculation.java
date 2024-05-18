package com.kenaidev.calculatorapp.db;

import androidx.room.ColumnInfo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calculation")
public class Calculation {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "value_a")
    public double valueA;

    @ColumnInfo(name = "value_b")
    public double valueB;

    @ColumnInfo(name = "operation")
    public String operation;

    @ColumnInfo(name = "result")
    public double result;

    @ColumnInfo(name = "date_hour")
    public String dateHour;

}
