package ru.ivanovsv.formatter.suppliers;

import ru.ivanovsv.formatter.formatters.ClassicFormatter;
import ru.ivanovsv.formatter.FormatterNames;
import ru.ivanovsv.formatter.formatters.Formatter;

public class ClassicSupplier implements FormatterSupplier {
    @Override
    public FormatterNames getName() {
        return FormatterNames.CLASSIC;
    }

    @Override
    public Formatter get() {
        return new ClassicFormatter();
    }
}
