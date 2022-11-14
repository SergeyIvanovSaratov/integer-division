package ru.ivanovsv.formatter.suppliers;

import ru.ivanovsv.formatter.FormatterNames;
import ru.ivanovsv.formatter.formatters.Formatter;
import ru.ivanovsv.formatter.formatters.GermanyFormatter;

public class GermanySupplier implements FormatterSupplier {

    @Override
    public FormatterNames getName() {
        return FormatterNames.GERMANY;
    }

    @Override
    public Formatter get() {
        return new GermanyFormatter();
    }
}
