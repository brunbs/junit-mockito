import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Math Operations in Calculator Class")
public class CalculatorTest {

    @DisplayName("Test 4/2 = 2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4,2);
        assertEquals(2, result, "4 / 2 should result in 2");
    }

    @DisplayName("Test 10-5 = 5")
    @Test
    void integerSubtraction_WhenTenMinusFive_ShouldReturnFive() {
        Calculator calculator = new Calculator();
        int minuend = 10;
        int subtrahend = 5;
        int expectedResult = 5;
        int result = calculator.integerSubtraction(minuend,subtrahend);
        assertEquals(expectedResult, result, () -> minuend + " - " + subtrahend + " did not produce " + expectedResult);
    }

}
