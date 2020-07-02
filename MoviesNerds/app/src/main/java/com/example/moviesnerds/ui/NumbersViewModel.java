package com.example.moviesnerds.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesnerds.model.NumberModel;

public class NumbersViewModel extends ViewModel {


    MutableLiveData<String> data = new MutableLiveData<>();

    private NumberModel setNumbers() {
        return new NumberModel(4, 2);
    }

    private String MultiNumbers() {

        NumberModel numbers = setNumbers();
        int res = numbers.getFirstNum() * numbers.getSecondNum();
        return String.valueOf(res);
    }

    public void getMultiResults() {
        data.setValue(MultiNumbers());
    }

}
