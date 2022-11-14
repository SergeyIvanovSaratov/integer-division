package ru.ivanovsv.formatter.formatters;

import ru.ivanovsv.domain.Result;

public class GermanyFormatter implements Formatter {

    @Override
    public String format(Result result) {
        StringBuilder sb = new StringBuilder();
        sb.append(buildHeader(result));
        boolean isFirst = true;
        int leftMargin = 0;
        for (Result.Step step : result.getSteps()) {
            if (step.getResultDev() != 0) {
                if (!isFirst) {
                    repeatSpaces(1 + step.getStepNo() - leftMargin, sb);
                    sb.append(Math.abs(step.getNumerator()) + "\n");
                }
                repeatSpaces(1 + step.getStepNo() - leftMargin, sb);
                sb.append(Math.abs(step.getDenominator()) + "\n");
                isFirst = false;
            } else {
                leftMargin++;
            }
        }
        repeatSpaces(result.getSteps().size() - (result.getReminder() < 0 ? 1 : 0), sb);
        sb.append(result.getReminder());

        return sb.toString();
    }

    private String buildHeader(Result result) {
        return (result.getDividend() < 0 ? "" : " ") + result.getDividend() + " ÷ " + result
                .getDivisor() + " => " + result.getQuotient() + "\n";
    }

    private void repeatSpaces(int count, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}
