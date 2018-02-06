package com.hfad.calculator;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.hfad.calculator.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      binding.editText.setText(binding.editText.getText() + "0");
                                                  }
                                              }
        );

        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     binding.editText.setText(binding.editText.getText() + "1");
                                                 }
                                             }
        );

        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     binding.editText.setText(binding.editText.getText() + "2");
                                                 }
                                             }
        );

        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
                                                       binding.editText.setText(binding.editText.getText() + "3");
                                                   }
                                               }
        );

        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      binding.editText.setText(binding.editText.getText() + "4");
                                                  }
                                              }
        );

        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      binding.editText.setText(binding.editText.getText() + "5");
                                                  }
                                              }
        );

        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     binding.editText.setText(binding.editText.getText() + "6");
                                                 }
                                             }
        );

        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
                                                       binding.editText.setText(binding.editText.getText() + "7");
                                                   }
                                               }
        );

        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
                                                       binding.editText.setText(binding.editText.getText() + "8");
                                                   }
                                               }
        );

        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      binding.editText.setText(binding.editText.getText() + "9");
                                                  }
                                              }
        );
        binding.buttonAdd.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.infoTextView.setText(valueOne + "+");
                binding.editText.setText(null);
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.infoTextView.setText(valueOne + "-");
                binding.editText.setText(null);
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.infoTextView.setText(valueOne + "*");
                binding.editText.setText(null);
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.infoTextView.setText(valueOne + "/");
                binding.editText.setText(null);
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                computeCalculation();
                binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                        valueTwo + " = " + valueOne);
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });
    }


    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            } catch (Exception e) {
            }
        }
    }

 }

