package ru.ivanovsv.formatter;

import java.util.HashMap;
import java.util.Map;

import ru.ivanovsv.formatter.suppliers.ClassicSupplier;
import ru.ivanovsv.formatter.formatters.Formatter;
import ru.ivanovsv.formatter.suppliers.FormatterSupplier;
import ru.ivanovsv.formatter.suppliers.GermanySupplier;

public class FormatterFactory {

    private final Map<FormatterNames, FormatterSupplier> suppliers;

    private static FormatterFactory instance = new FormatterFactory();

    private FormatterFactory() {
        suppliers = new HashMap<>();
        register(new ClassicSupplier());
        register(new GermanySupplier());
    }

    public void register(FormatterSupplier supplier) {
        suppliers.put(supplier.getName(), supplier);
    }

    public Formatter get(FormatterNames name) {
        if (suppliers.containsKey(name)) {
            return suppliers.get(name).get();
        }
        throw new IllegalArgumentException("Formatter with name '" + name + "' not registered!");
    }

    public static FormatterFactory getInstance() {
        return instance;
    }

}
