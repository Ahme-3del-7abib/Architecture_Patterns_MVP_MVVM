package com.example.moviesnerds.ui;

import com.example.moviesnerds.model.NumberModel;

public class Presenter {

    NumberViewInterface numberViewInterface;

    public Presenter(NumberViewInterface numberViewInterface) {
        this.numberViewInterface = numberViewInterface;
    }

    private NumberModel setNumbers() {
        return new NumberModel(4, 2);
    }

    private String DivNumbers() {

        NumberModel numbers = setNumbers();
        int res = numbers.getFirstNum() / numbers.getSecondNum();
        return String.valueOf(res);
    }

    public void getDivResults() {
        numberViewInterface.getResult(DivNumbers());
    }
}
