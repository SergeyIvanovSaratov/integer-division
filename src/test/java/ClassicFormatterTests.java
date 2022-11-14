import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.ivanovsv.domain.Result;
import ru.ivanovsv.formatter.FormatterFactory;
import ru.ivanovsv.formatter.FormatterNames;
import ru.ivanovsv.formatter.formatters.Formatter;

class ClassicFormatterTests {

    Formatter formatter = FormatterFactory.getInstance().get(FormatterNames.CLASSIC);

    @Test
     void divideClassicTest() {
        Result result = new Result(8420, 4, 2105, 0,
                Arrays.asList(new Result.Step(2, 8, 8, 0),
                        new Result.Step(1, 4, 4, 1),
                        new Result.Step(0, 2, 0, 2),
                        new Result.Step(5, 20, 20, 3)));

        Assertions.assertEquals(
                        " 8420|4\n"
                              + "-8   |2105\n"
                              + "  4\n"
                              + " -4\n"
                              + "   20\n"
                              + "  -20\n"
                              + "    0", formatter.format(result));
    }

    @Test
     void divideClassic2Test() {
        Result result = new Result(8420, 9, 935, 5,
                Arrays.asList(new Result.Step(0, 8, 0, 0),
                        new Result.Step(9, 84, 81, 1),
                        new Result.Step(3, 32, 27, 2),
                        new Result.Step(5, 50, 45, 3)));

        Assertions.assertEquals(
                " 8420|9\n"
                        + "-81  |935\n"
                        + "  32\n"
                        + " -27\n"
                        + "   50\n"
                        + "  -45\n"
                        + "    5", formatter.format(result));
    }

    @Test
     void divideClassicNegativeDividendTest() {
        Result result = new Result(-8420, 9, -935, -5,
                Arrays.asList(new Result.Step(0, -8, 0, 0),
                        new Result.Step(-9, -84, -81, 1),
                        new Result.Step(-3, -32, -27, 2),
                        new Result.Step(-5, -50, -45, 3)));

        Assertions.assertEquals(
                    "-8420|9\n"
                          + " 81  |-935\n"
                          + " -32\n"
                          + "  27\n"
                          + "  -50\n"
                          + "   45\n"
                          + "    5", formatter.format(result));
    }

    @Test
     void divideClassicNegativeDivisorTest() {
        Result result = new Result(8420, -4, -2105, 0,
                Arrays.asList(new Result.Step(-2, 8, 8, 0),
                        new Result.Step(-1, 4, 4, 1),
                        new Result.Step(0, 2, 0, 2),
                        new Result.Step(-5, 20, 20, 3)));

        Assertions.assertEquals(
                  " 8420|-4\n"
                        + "-8   |-2105\n"
                        + "  4\n"
                        + " -4\n"
                        + "   20\n"
                        + "  -20\n"
                        + "    0", formatter.format(result));
    }

    @Test
     void divideClassicNegativeBothTest() {
        Result result = new Result(-8420, -9, 935, -5,
                Arrays.asList(new Result.Step(0, -8, 0, 0),
                        new Result.Step(9, -84, -81, 1),
                        new Result.Step(3, -32, -27, 2),
                        new Result.Step(5, -50, -45, 3)));

        Assertions.assertEquals(
                  "-8420|-9\n"
                        + " 81  |935\n"
                        + " -32\n"
                        + "  27\n"
                        + "  -50\n"
                        + "   45\n"
                        + "    5", formatter.format(result));
    }


}
