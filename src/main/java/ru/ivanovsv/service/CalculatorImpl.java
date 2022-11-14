package ru.ivanovsv.service;

import java.util.ArrayList;
import java.util.List;

import ru.ivanovsv.domain.Result;

public class CalculatorImpl implements Calculator {

    @Override
    public Result divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor must not be equal to 0");
        }
        int[] digits = digits(dividend);
        int[] intAfterDivision = new int[digits.length];
        List<Result.Step> steps = new ArrayList<>();
        int remain = 0;
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];
            if (remain != 0) {
                digit += remain * 10;
            }
            int res = digit / divisor;
            intAfterDivision[i] = res;
            remain = digit % divisor;

            steps.add(new Result.Step(res, digit, res * divisor, i));
        }
        return new Result(dividend, divisor, number(intAfterDivision), remain, steps);
    }

    private int[] digits(int number) {
        int length = length(number);
        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        reverseDigits(digits);
        return digits;
    }

    private int number(int[] digits) {
        int number = 0;
        for (int value : digits) {
            number = number * 10 + value;
        }
        return number;
    }

    private int length(int num) {
        return num < 10 ? 1 : (int) (Math.log10(num) + 1);
    }

    private void reverseDigits(int[] digits) {
        for (int i = 0; i < digits.length / 2; i++) {
            int temp = digits[i];
            digits[i] = digits[digits.length - i - 1];
            digits[digits.length - i - 1] = temp;
        }
    }
}
