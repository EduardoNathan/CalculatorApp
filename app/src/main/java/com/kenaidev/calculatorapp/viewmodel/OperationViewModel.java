package com.kenaidev.calculatorapp.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kenaidev.calculatorapp.db.AppDatabase;
import com.kenaidev.calculatorapp.db.Calculation;
import com.kenaidev.calculatorapp.db.CalculationDao;
import com.kenaidev.calculatorapp.model.Operations;
import com.kenaidev.calculatorapp.model.Calculate;
import com.kenaidev.calculatorapp.ui.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OperationViewModel extends AndroidViewModel {

    public MutableLiveData<Double> resultLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Calculation>> allCalculationsLiveData = new MutableLiveData<>();

    private Context context;

    private final Calculate calculate = new Calculate();

    public OperationViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void handleOperation(String txtFirstNumber, String txtSecondNumber, Operations operation) {

        if (txtFirstNumber.isEmpty() || txtSecondNumber.isEmpty()) {
            errorLiveData.postValue(new Throwable("Preencha os campos."));
            return;
        }

        double resultOperation = 0;
        int firstNumber = Integer.parseInt(txtFirstNumber);
        int secondNumber = Integer.parseInt(txtSecondNumber);

        switch (operation) {
            case SUM:
                resultOperation = calculate.sum(firstNumber, secondNumber);
                resultLiveData.postValue(resultOperation);
                break;
            case SUB:
                resultOperation = calculate.subtraction(firstNumber, secondNumber);
                resultLiveData.postValue(resultOperation);
                break;
            case DIV:
                if (secondNumber != 0) {
                    resultOperation = calculate.division(firstNumber, secondNumber);
                    resultLiveData.postValue(resultOperation);
                } else {

                    errorLiveData.postValue(new Throwable("Não é possível dividir por 0."));
                }

                break;
            case MULTI:
                resultOperation = calculate.multiplication(firstNumber, secondNumber);
                resultLiveData.postValue(resultOperation);
                break;
        }
        saveCalculation(firstNumber, secondNumber, operation, resultOperation);
    }

    private String getDateHour() {

        return new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(new Date());
    }

    private void saveCalculation(int firstNumber, int secondNumber, Operations operation, double result) {

        Calculation calculation = new Calculation();
        calculation.valueA = firstNumber;
        calculation.valueB = secondNumber;
        calculation.operation = operation.name();
        calculation.dateHour = getDateHour();
        calculation.result = result;

        CalculationDao calculationDao = AppDatabase.getInstance(context).calculationDao();
        calculationDao.insert(calculation);
    }

    public void getList() {
        CalculationDao calculationDao = AppDatabase.getInstance(context).calculationDao();
        List<Calculation> listAllCalculations = calculationDao.getAllCalculations();
        allCalculationsLiveData.postValue(listAllCalculations);
    }

}
