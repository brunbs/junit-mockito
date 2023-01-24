import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

    @DisplayName("Test 10-5 = 5")
    @Test
    void integerSubtraction_WhenTenMinusFive_ShouldReturnFive() {
        System.out.println("Test 10-5 = 5");
        //Arrange - variable inicialization and requirements
        int minuend = 10;
        int subtrahend = 5;
        int expectedResult = 5;

        //Act - invoke the testing methods
        int actualResult = calculator.integerSubtraction(minuend,subtrahend);

        //Assert - returns validations
        assertEquals(expectedResult, actualResult, () -> minuend + " - " + subtrahend + " did not produce " + expectedResult);
    }

}
