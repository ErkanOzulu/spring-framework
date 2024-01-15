import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll() {
        System.out.println("BeforeAll is executed");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll is executed");
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("BeforeEach is executed");
    }

    @AfterEach()
    void tearDownEach() {
        System.out.println("AfterEach is executed");
    }


    @Test
    void testCase1() {
        // Assertion will pass
        assertEquals(4, Calculator.add(2, 2));
        // Assertion will fail
        assertEquals(3, Calculator.add(2, 2), "Addition test is failed");
    }

    @Test
    void testCase2() {
        boolean result = Calculator.add(2, 2) == 4;
        assertTrue(result);
        boolean result2 = Calculator.add(2, 2) == 5;
        assertFalse(result2);
    }

    @Test
    void testCase3() {
        // Assertion will pass
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}, "Array Equal Test");
        // Assertion will fail because order is different
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 3, 2}, "Array Equal Test");
        // Assertion will fail because length is different
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4}, "Array Equal Test");
    }

    @Test
    void testCase4() {
        // assertNotNull() method asserts that actual is NOT null.
        // Similarly, assertNull() method asserts that actual is null
        String nullString = null;
        String notNullString = "Cydeo";
        // Assertion will pass
        Assertions.assertNull(nullString);
        // Assertion will pass
        Assertions.assertNotNull(notNullString);
        // Assertion will fail
        Assertions.assertNull(notNullString);
        // Assertion will fail
        Assertions.assertNotNull(nullString);

    }

    @Test
    void testCase6() {
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();
        // Assertion will pass
        Assertions.assertSame(c1, c2); //asserts that expected and actual refer to exactly same object
        // Assertion will pass
        Assertions.assertNotSame(c1, c3);
        // Assertion will fail
        Assertions.assertSame(c1, c3);
        // Assertion will fail
        Assertions.assertNotSame(c1, c2);  //asserts that expected and actual DO NOT refer to the same object

    }

    @Test
    void add() {
        System.out.println("add");
        int actual = Calculator.add(2, 3);
        assertEquals(6,actual,"it is not matching with expected value.");
    }
    @Test
    void add2() {
        //If no exception is thrown, or if an exception of a different type is thrown,this method will fail
        System.out.println("add2");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.add2(2, 1));
    }


}