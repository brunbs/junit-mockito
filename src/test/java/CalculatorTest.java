import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void integerDivision() {
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4,2);
        assertEquals(2, result, "4 / 2 should result in 2");
    }

    @Test
    void integerSubtraction() {
        Calculator calculator = new Calculator();
        int minuend = 10;
        int subtrahend = 5;
        int expectedResult = 5;
        int result = calculator.integerSubtraction(minuend,subtrahend);
        assertEquals(expectedResult, result, () -> minuend + " - " + subtrahend + " did not produce " + expectedResult);
    }

}
