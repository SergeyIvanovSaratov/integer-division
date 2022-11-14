package ru.ivanovsv;

import ru.ivanovsv.domain.Result;
import ru.ivanovsv.formatter.FormatterFactory;
import ru.ivanovsv.formatter.FormatterNames;
import ru.ivanovsv.formatter.formatters.Formatter;
import ru.ivanovsv.service.Calculator;
import ru.ivanovsv.service.CalculatorImpl;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        Result result = calculator.divide(-8420, -9);
        Formatter formatter = FormatterFactory.getInstance().get(FormatterNames.CLASSIC);
        System.out.println(formatter.format(result));

    }

}
