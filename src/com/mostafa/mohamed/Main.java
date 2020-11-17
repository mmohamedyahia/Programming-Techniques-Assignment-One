package com.mostafa.mohamed;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EquationSolution solutionObj = new EquationSolution();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Equation : ");
        String equation = input.next();

        try {
            String output = solutionObj.Solution(equation);
            System.out.println(output);
        } catch (Exception e){
            System.out.println("Not Valid Equation !!!");
        }

    }
}
