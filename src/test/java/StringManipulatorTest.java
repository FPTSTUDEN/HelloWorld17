import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import e8_1.StringManipulator;


public class StringManipulatorTest {
    private StringManipulator stringManipulator;

    @BeforeEach
    void setUp() {
        stringManipulator = new StringManipulator();
    }

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", stringManipulator.concatenate("Hello", "World"));
    }

    @Test
    void testFindLength() {
        assertEquals(5, stringManipulator.findLength("Hello"));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", stringManipulator.convertToUpperCase("hello"));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("hello", stringManipulator.convertToLowerCase("HELLO"));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(stringManipulator.containsSubstring("Hello World", "World"));
        assertFalse(stringManipulator.containsSubstring("Hello World", "Universe"));
    }
}
