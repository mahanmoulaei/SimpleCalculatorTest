package com.example.simplecalculatortest;

import java.util.Random;

public class MathOperationGenerator {

    //Trigger This Function To Generate A Random Operation
    public static Operation GenerateOperation() {
        Operation operation = new Operation();
        return operation;
    }
}

class Operation {

    private int leftNumber;
    private int rightNumber;
    private Operator operator;
    private final Random randomGenerator = new Random();
    private static final int MIN_OPERATION_ELEMENT_VALUE = 1;
    private static final int MAX_OPERATION_ELEMENT_VALUE = 100;

    public Operation() {
        this.leftNumber = getRandomIntegerInRange(MIN_OPERATION_ELEMENT_VALUE, MAX_OPERATION_ELEMENT_VALUE);
        this.operator = Operator.values()[randomGenerator.nextInt(Operator.values().length)];
        this.rightNumber = getRandomIntegerInRange(MIN_OPERATION_ELEMENT_VALUE, MAX_OPERATION_ELEMENT_VALUE);
    }

    public int getLeftNumber() {
        return leftNumber;
    }

    public void setLeftNumber(int value) {
        this.leftNumber = value;
    }

    public int getRightNumber() {
        return rightNumber;
    }

    public void setRightNumber(int value) {
        this.rightNumber = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getOperatorDisplayValue() {
        return operator.getDisplayValue();
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    private int getRandomIntegerInRange(int min, int max) {
        return randomGenerator.nextInt(max - min + 1) + min;
    }

    @Override
    public String toString() {
        return getLeftNumber() + (operator == null ? "" : " " + getOperatorDisplayValue()) + " " + getRightNumber();
    }
}

enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLIER("*"), DIVIDER("/");
    private String displayValue;

    private Operator(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}

