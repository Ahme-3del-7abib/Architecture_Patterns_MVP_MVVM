package com.example.moviesnerds.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviesnerds.R;
import com.example.moviesnerds.databinding.ActivityMainBinding;
import com.example.moviesnerds.model.NumberModel;


public class MainActivity extends AppCompatActivity implements NumberViewInterface {


    ActivityMainBinding binding;
    NumbersViewModel numbersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // mvc 4+2
        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getResults();
            }
        });

        // mvp  4/2
        final Presenter presenter = new Presenter(this);

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDivResults();
            }
        });

        // mvvm 4*2

        numbersViewModel = ViewModelProviders.of(MainActivity.this).get(NumbersViewModel.class);
        numbersViewModel.data.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.mulResultTextView.setText(s);
            }
        });

        binding.mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numbersViewModel.getMultiResults();
            }
        });
    }

    private NumberModel setNumbers() {
        return new NumberModel(4, 2);
    }

    private String AddNumbers() {

        NumberModel numbers = setNumbers();
        int res = numbers.getFirstNum() + numbers.getSecondNum();

        return String.valueOf(res);
    }

    private void getResults() {
        binding.plusResultTextView.setText(AddNumbers());
    }

    @Override
    public void getResult(String s) {
        binding.divResultTextView.setText(s);
    }
}