package com.mostafa.mohamed;

import java.util.ArrayList;

public class EquationSolution {

    private ArrayList<String> Numbers;
    private ArrayList<Character> Operations;

    public String Solution(String equation) {

        this.getNumbersArray(equation);
        double total = 0.0;

        for (int i = 0 ; i < this.Numbers.size() -1; i++) {
            if(i == 0) {
                total = this.calcTwoNumbers(
                        Double.parseDouble(this.Numbers.get(i)),
                        Double.parseDouble(this.Numbers.get(i+1)),
                        this.Operations.get(i)
                );
            } else {
                total = this.calcTwoNumbers(
                        total,
                        Double.parseDouble(this.Numbers.get(i+1)),
                        this.Operations.get(i)
                );
            }
        }

        return "The Result is : " +  total;
    }

    private void getNumbersArray(String equation) {
        char [] stringChar = equation.toCharArray();
        this.Numbers = new ArrayList<>();
        this.Operations = new ArrayList<>();

        boolean lastIsOperation = false;
        String doubleNumber = "";

        for (int i = 0 ; i < stringChar.length; i++) {
            if ( (i == 0) && (stringChar[i] == '-' || stringChar[i] == '+') ) {
                doubleNumber += stringChar[i];
            }
            if ( ( ( stringChar[i] != '-' && stringChar[i] != '+' )  || lastIsOperation ) ) {
                doubleNumber += stringChar[i];
                lastIsOperation = false;
            }
            if ( i > 0 && (stringChar[i] == '-' || stringChar[i] == '+')) {
                this.Numbers.add(doubleNumber);
                this.Operations.add(stringChar[i]);
                doubleNumber = "";
                lastIsOperation = true;
            }

            if ( i == (stringChar.length-1) ) {
                this.Numbers.add(doubleNumber);
            }

        }

    }

    private double calcTwoNumbers(double first, double second, char operation) {
        switch (operation) {
            case '+':
                return (first + second);
            case '-':
                return (first - second);
            default:
                return 0.0;
        }
    }
}