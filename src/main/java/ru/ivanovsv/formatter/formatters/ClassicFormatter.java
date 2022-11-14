package ru.ivanovsv.formatter.formatters;

import ru.ivanovsv.domain.Result;

public class ClassicFormatter implements Formatter {

    @Override
    public String format(Result result) {
        StringBuilder sb = new StringBuilder();
        sb.append(buildHeader(result));
        boolean isFirst = true;
        int leftMargin = 0;
        for (Result.Step step : result.getSteps()) {
            if (step.getResultDev() != 0) {
                if (isFirst) {
                    repeatSpaces(leftMargin - (String.valueOf(step.getDenominator()).length() - 1), sb);
                    sb.append((step.getDenominator() > 0 ? "-" : " ") + Math.abs(step.getDenominator()));
                    repeatSpaces(result.getSteps().size() - 1 - step.getStepNo(), sb);
                    sb.append("|" + result.getQuotient() + "\n");
                    isFirst = false;
                } else {
                    repeatSpaces(step.getStepNo() - (String.valueOf(Math.abs(step.getNumerator())).length() - 1), sb);
                    sb.append((step.getNumerator() > 0 ? " " : "-") + Math.abs(step.getNumerator()) + "\n");
                    repeatSpaces(step.getStepNo() - (String.valueOf(Math.abs(step.getDenominator())).length() - 1), sb);
                    sb.append((step.getDenominator() > 0 ? "-" : " ") + Math.abs(step.getDenominator()) + "\n");
                }
                leftMargin = 0;
            } else {
                leftMargin++;
            }
        }
        repeatSpaces(
                result.getSteps().size() + (result.getReminder() < 0 ? 1 : 0) - (String.valueOf(result.getReminder())
                        .length() - 1), sb);
        sb.append(Math.abs(result.getReminder()));

        return sb.toString();
    }

    private String buildHeader(Result result) {
        return (result.getDividend() < 0 ? "" : " ") + result.getDividend() + "|" + result.getDivisor() + "\n";
    }

    private void repeatSpaces(int count, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }

}