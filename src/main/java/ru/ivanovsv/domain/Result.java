package ru.ivanovsv.domain;

import java.util.Collection;
import java.util.Objects;

public class Result {

    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int reminder;
    private final Collection<Step> steps;

    public Result(int dividend, int divisor, int quotient, int reminder, Collection<Step> steps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.reminder = reminder;
        this.steps = steps;
    }

    public final int getDividend() {
        return dividend;
    }

    public final int getDivisor() {
        return divisor;
    }

    public final int getQuotient() {
        return quotient;
    }

    public final int getReminder() {
        return reminder;
    }

    public final Collection<Step> getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Result))
            return false;
        Result result = (Result) o;
        return dividend == result.dividend && divisor == result.divisor && quotient == result.quotient && reminder == result.reminder && Objects
                .equals(steps, result.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, quotient, reminder, steps);
    }

    public static class Step {
        private final int resultDev;
        private final int numerator;
        private final int denominator;
        private final int stepNo;

        public Step(int resultDev, int numerator, int denominator, int stepNo) {
            this.resultDev = resultDev;
            this.numerator = numerator;
            this.denominator = denominator;
            this.stepNo = stepNo;
        }

        public final int getResultDev() {
            return resultDev;
        }

        public final int getNumerator() {
            return numerator;
        }

        public final int getDenominator() {
            return denominator;
        }

        public final int getStepNo() {
            return stepNo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Step))
                return false;
            Step step = (Step) o;
            return resultDev == step.resultDev && numerator == step.numerator && denominator == step.denominator && stepNo == step.stepNo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(resultDev, numerator, denominator, stepNo);
        }
    }
}
