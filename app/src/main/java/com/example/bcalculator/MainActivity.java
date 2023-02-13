package com.example.bcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button ac,del,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bmul,bplus,bminus,bequals,bdot;
    TextView history,result;

    private String number  =  null;
    double firstNumber = 0;
    double lastNumber = 0;
    String status = null;
    boolean operator = false;
    DecimalFormat myFormat = new DecimalFormat("#######.#######");
    String hist,currentResult;
    boolean dot = true;
    boolean acControl = true;
    boolean equalControl= false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac =findViewById(R.id.btnac);
        del =findViewById(R.id.btndel);
        b1 =findViewById(R.id.btn1);
        b2 =findViewById(R.id.btn2);
        b3 =findViewById(R.id.btn3);
        b4 =findViewById(R.id.btn4);
        b5 =findViewById(R.id.btn5);
        b6 =findViewById(R.id.btn6);
        b7 =findViewById(R.id.btn7);
        b8 =findViewById(R.id.btn8);
        b9 =findViewById(R.id.btn9);
        b0 =findViewById(R.id.btn0);
        bdiv =findViewById(R.id.btndivide);
        bmul =findViewById(R.id.btnmultiply);
        bplus =findViewById(R.id.btnplus);
        bminus =findViewById(R.id.btnminus);
        bdot =findViewById(R.id.btndot);
        bequals =findViewById(R.id.btnequals);
        history =findViewById(R.id.txthistory);
        result =findViewById(R.id.txtresult);
        history.setMovementMethod(new ScrollingMovementMethod());


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");

            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");

            }
        });

        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"+");

                if(operator){
                    if(status == "multiplication")
                        multiply();
                    else if(status == "division")
                        divide();
                    else if(status == "subtraction")
                        minus();
                    else
                        plus();
                }

                status = "addition";
                operator = false;
                number = null;

            }
        });

        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"-");

                if(operator){
                    if(status == "multiplication")
                        multiply();
                    else if(status == "division")
                        divide();
                    else if(status == "addition")
                        plus();
                    else
                        minus();
                }

                status = "subtraction";
                operator = false;
                number = null;

            }
        });

        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"*");

                if(operator){
                    if(status == "division")
                        divide();
                    else if(status == "addition")
                        plus();
                    else if(status == "subtraction")
                        minus();
                    else
                        multiply();
                }
                status = "multiplication";
                operator= false;
                number = null;
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"/");

                if(operator){
                    if(status == "multiplication")
                        multiply();
                    else if(status == "addition")
                        plus();
                    else if(status == "subtraction")
                        minus();
                    else
                        divide();
                }
                operator = false;
                status = "division";
                number = null;

            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = null;
                status = null;
                result.setText("0");
                history.setText("");
                firstNumber = 0;
                lastNumber =0;
                dot = true;
                acControl = true;

            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(acControl){
                    result.setText("0");
                }
                else{
                    number = number.substring(0,number.length()-1);
                    if(number.length()==0){
                        del.setClickable(false);
                    }
                    else if(number.contains(".")){
                        dot = false;
                    }
                    else{
                        dot = true;
                    }
                    result.setText(number);
                }

            }
        });

        bequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hist = history.getText().toString();
                currentResult = result.getText().toString();
                history.setText(hist+currentResult+"\n");

                if(operator){
                    if(status == "addition")
                        plus();
                    else if(status == "subtraction")
                        minus();
                    else if(status == "multiplication")
                        multiply();
                    else if(status == "division")
                        divide();
                    else
                        firstNumber = Double.parseDouble(result.getText().toString());
                }
                operator = false;
                equalControl = true;
            }
        });

        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(dot){
                    if(number == null)
                        number = "0.";
                    else
                        number = number + ".";
                }
                result.setText(number);
                dot = false;


            }
        });



    }


    public void numberClick(String view){
        if(number == null){
            number = view;
        }
        else if(equalControl){
            firstNumber =0;
            lastNumber =0;
            number = view;
        }
        else
            number = number+view;
        result.setText(number);
        operator = true;
        acControl = false;
        del.setClickable(true);
        equalControl = false;
    }

    public void plus(){
        lastNumber = Double.parseDouble(result.getText().toString());
        firstNumber = firstNumber+lastNumber;
        result.setText(myFormat.format(firstNumber));
        dot = true;
    }

    public void minus(){
        if(firstNumber==0){
            firstNumber = Double.parseDouble(result.getText().toString());
        }
        else{
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        result.setText(myFormat.format(firstNumber));
        dot =  true;
    }

    public void multiply(){
        if(firstNumber == 0){
            firstNumber =1;
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber*lastNumber;
        }
        else{
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber*lastNumber;
        }

        result.setText(myFormat.format(firstNumber));
        dot = true;
    }

    public void divide(){
        double num = Double.parseDouble(result.getText().toString());
            if(firstNumber == 0){
                lastNumber = Double.parseDouble(result.getText().toString());
                firstNumber = lastNumber/1;
            }
            else{
                lastNumber = Double.parseDouble(result.getText().toString());
                firstNumber = firstNumber/lastNumber;
            }
            result.setText(myFormat.format(firstNumber));
            dot = true;
            return;


    }


}