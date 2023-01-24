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
        int result = calculator.integerSubtraction(10,5);
        assertEquals(5, result, "10 - 5 should be 5");
    }

}
