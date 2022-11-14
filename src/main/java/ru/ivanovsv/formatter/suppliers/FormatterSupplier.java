package ru.ivanovsv.formatter.suppliers;

import java.util.function.Supplier;

import ru.ivanovsv.formatter.FormatterNames;
import ru.ivanovsv.formatter.formatters.Formatter;

public interface FormatterSupplier extends Supplier<Formatter> {
    FormatterNames getName();
}
