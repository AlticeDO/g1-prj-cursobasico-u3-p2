package com.example.eduardorodriguez.calculadoracambiomoneda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import my_exception.MyException;
import my_exception.RequireFieldException;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private String[] arrToCurrency = {
            "Moneda Destino",
            "DOP - Dominican Peso",
            "USD - United States Dollar",
            "EUR - Euro"};

    private String[] arrFromCurrency = {
            "Moneda Origen",
            "DOP - Dominican Peso",
            "USD - United States Dollar",
            "EUR - Euro"};

    private EditText metAmount, metRate;
    private Spinner mstoCurrency, msfromCurrency;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMainActivityVariables(); //Initialize global variables with the components on the activity


    }

    private void initMainActivityVariables() {
        ArrayAdapter<String> adapterToCurrency, adapterFromCurrency;

        findViewById(R.id.btnCalculate).setOnClickListener(this);

        metAmount = (EditText)findViewById(R.id.etAmount);
        metRate = (EditText)findViewById(R.id.etRate);
        mstoCurrency = (Spinner)findViewById(R.id.sToCurrency);
        msfromCurrency = (Spinner)findViewById(R.id.sFromCurrency);
        tvResult = (TextView)findViewById(R.id.tvResult);

        adapterToCurrency = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrToCurrency);
        adapterFromCurrency = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrFromCurrency);

        adapterToCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFromCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mstoCurrency.setAdapter(adapterToCurrency);
        msfromCurrency.setAdapter(adapterFromCurrency);
    }

    @Override
    public void onClick(View view) {

        try {
            validate(); // Validates the requires field have value before do the operation.

            doOperation(); //Calculates the equivalent currency amount.
        }
        catch(MyException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void doOperation() {
        double rate, amount, result;

        rate = Double.parseDouble(metRate.getText().toString());
        amount = Double.parseDouble(metAmount.getText().toString());

        result = amount * rate;

        tvResult.setText(String.valueOf(result));
    }

    private void validate() throws RequireFieldException {

        if(metAmount.getText().toString().trim().length()==0)   {
            throw new RequireFieldException(metAmount.getHint().toString());
        }

        if(metRate.getText().toString().trim().length()==0) {
            throw new RequireFieldException(metRate.getHint().toString());
        }

        if(mstoCurrency.getSelectedItem().toString().equals("Moneda Destino")) {
            throw new RequireFieldException(mstoCurrency.getSelectedItem().toString());
        }

        if(msfromCurrency.getSelectedItem().toString().equals("Moneda Origen")) {
            throw new RequireFieldException(msfromCurrency.getSelectedItem().toString());
        }
    }
}
