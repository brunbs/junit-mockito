import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in Calculator Class")
public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method - this is executed first - must be static");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method - this is executed last - must be static");
    }

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Executing @BeforeEach method");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Executing @AfterEach method");
    }

    @DisplayName("Test 4/2 = 2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("Test 4/2 = 2");
        int result = calculator.integerDivision(4,2);
        assertEquals(2, result, "4 / 2 should result in 2");
    }

    @Disabled("TODO: not implemented yet")
    @DisplayName("Disabled Test")
    @Test
    void testIntegerDivision_DisabledTest() {
        fail("Not implemented yet");
    }

    @Test
    void testIntegerDivision_WhenDivisionByZero_ShouldThrowArithmeticException() {
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

    @DisplayName("Test integer subtraction [minuend, subtrahend, exceptedResult]")
    @ParameterizedTest
    @MethodSource("integerSubtractionInputParameters")
    void integerSubtraction_WhenTwoIntegerArguments_ShouldReturnSubtractionOfThem(int minuend, int subtrahend, int expectedResult) {
        //Act - invoke the testing methods
        int actualResult = calculator.integerSubtraction(minuend,subtrahend);

        //Assert - returns validations
        assertEquals(expectedResult, actualResult, () -> minuend + " - " + subtrahend + " did not produce " + expectedResult);
    }

    private static Stream<Arguments> integerSubtractionInputParameters() {
        return Stream.of(
                Arguments.of(10, 5, 5),
                Arguments.of(24, 1, 23),
                Arguments.of(12, 8, 4)
        );
    }

    @DisplayName("Test integer subtraction with CSV {minuend, subtrahend, exceptedResult}")
    @ParameterizedTest
    @CsvSource( {
            "33,1,32",
            "40, 21, 19",
            "8, 2, 6"
    } )
    void integerSubtraction_WhenTwoIntegerArgumentsUsingCSV_ShouldReturnSubtractionOfThem(int minuend, int subtrahend, int expectedResult) {
        //Act - invoke the testing methods
        int actualResult = calculator.integerSubtraction(minuend,subtrahend);

        //Assert - returns validations
        assertEquals(expectedResult, actualResult, () -> minuend + " - " + subtrahend + " did not produce " + expectedResult);
    }

}
