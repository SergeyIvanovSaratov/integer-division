import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.ivanovsv.domain.Result;
import ru.ivanovsv.service.Calculator;
import ru.ivanovsv.service.CalculatorImpl;

class CalculatorTests {
    Calculator calculator = new CalculatorImpl();

    @Test
     void divideTest() {
        Result result = new Result(8420, 4, 2105, 0,
                Arrays.asList(new Result.Step(2, 8, 8, 0),
                        new Result.Step(1, 4, 4, 1),
                        new Result.Step(0, 2, 0, 2),
                        new Result.Step(5, 20, 20, 3)));



        Assertions.assertEquals(result, calculator.divide(8420, 4));
    }

    @Test
     void divideExceptionTest() {
        Throwable thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(8420, 0));
        Assertions.assertNotNull(thrown.getMessage());
    }

    @Test
     void divideNegativeDividendTest() {
        Result result = new Result(-8420, 9, -935, -5,
                Arrays.asList(new Result.Step(0, -8, 0, 0),
                        new Result.Step(-9, -84, -81, 1),
                        new Result.Step(-3, -32, -27, 2),
                        new Result.Step(-5, -50, -45, 3)));


        Assertions.assertEquals(result, calculator.divide(-8420, 9));
    }

    @Test
     void divideNegativeDivisorTest() {
        Result result = new Result(8420, -4, -2105, 0,
                Arrays.asList(new Result.Step(-2, 8, 8, 0),
                        new Result.Step(-1, 4, 4, 1),
                        new Result.Step(0, 2, 0, 2),
                        new Result.Step(-5, 20, 20, 3)));


        Assertions.assertEquals(result, calculator.divide(8420, -4));
    }

    @Test
     void divideNegativeBothTest() {
        Result result = new Result(-8420, -9, 935, -5,
                Arrays.asList(new Result.Step(0, -8, 0, 0),
                        new Result.Step(9, -84, -81, 1),
                        new Result.Step(3, -32, -27, 2),
                        new Result.Step(5, -50, -45, 3)));

        Assertions.assertEquals(result, calculator.divide(-8420, -9));
    }


}
