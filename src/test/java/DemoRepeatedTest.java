import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Executing @BeforeEach method");
        calculator = new Calculator();
    }

    @DisplayName("Division by zero")
    @RepeatedTest(value = 3, name = "{displayName}. Repetition #{currentRepetition} of {totalRepetitions}")
    void testIntegerDivision_WhenDivisionByZero_ShouldThrowArithmeticException(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition number: #" + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());

        //Arrange - variable inicialization and requirements
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        //Act - invoke the testing methods
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);
        }, "Division by 0 should have thrown Arithmetic Exception");

        //Assert - returns validations
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }

}
