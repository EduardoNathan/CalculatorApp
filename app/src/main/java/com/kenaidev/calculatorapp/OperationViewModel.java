package com.kenaidev.calculatorapp;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kenaidev.calculatorapp.model.Calculate;

public class OperationViewModel extends ViewModel {

    MutableLiveData<Double> resultLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    private Calculate calculate = new Calculate();

    public void handleOperation(String txtNumeroUm, String txtNumeroDois, Operations operation) {

        if (txtNumeroUm.isEmpty() || txtNumeroDois.isEmpty()) {
            errorLiveData.postValue(new Throwable("Preencha os campos."));
            return;
        }

        double resultOperation;
        int numeroUm = Integer.parseInt(txtNumeroUm);
        int numeroDois = Integer.parseInt(txtNumeroDois);

        switch (operation) {
            case ADICAO:
                resultOperation = calculate.soma(numeroUm, numeroDois);
                resultLiveData.postValue(resultOperation);
                break;
            case SUBTRACAO:
                resultOperation = calculate.subtracao(numeroUm, numeroDois);
                resultLiveData.postValue(resultOperation);
                break;
            case DIVISAO:
                if (numeroDois != 0) {
                    resultOperation = calculate.divisao(numeroUm, numeroDois);
                    resultLiveData.postValue(resultOperation);
                } else {

                    errorLiveData.postValue(new Throwable("Não é possível dividir por 0."));
                }

                break;
            case MULTIPLICACAO:
                resultOperation = calculate.multiplicacao(numeroUm, numeroDois);
                resultLiveData.postValue(resultOperation);
                break;
        }
    }

}
