import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {

    //1-ValueSource()
    @ParameterizedTest
    @ValueSource(strings = {"Java", "Js", "TS"})
    void testCase1(String args) {
        assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 10})
    void testCase2(int number) {
        assertEquals(0, number % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Js", "TS"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String args) {
        assertTrue(!args.isEmpty());
    }

    //2-MethodSource()
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg) {
        assertNotNull(arg);
    }

    //  The factory method should be static and return Stream, Iterable or array elements
    static String[] stringProvider() {
        return new String[]{"Java", "Js", "TS"};
    }

    //3-CsvSource
    @ParameterizedTest
    @CsvSource({"10,20,30", "50,60,110", "10,20,30"})
    void testCase5(int num1, int num2, int result) {
        assertEquals(result, Calculator.add(num1, num2));

    }

    //4-CsvFileSource
    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result) {
        assertEquals(result, Calculator.add(num1, num2));

    }
}
