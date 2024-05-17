package com.kenaidev.calculatorapp.db;

import androidx.room.ColumnInfo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calculation")
public class Calculation {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "valor_a")
    public double valorA;

    @ColumnInfo(name = "valor_b")
    public double valorB;

    @ColumnInfo(name = "operacao")
    public String operacao;

    @ColumnInfo(name = "data_hora")
    public String dataHora;

}
