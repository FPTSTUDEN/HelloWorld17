import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import e8_2.PalindromeChecker;

public class PalindromeCheckerTest {

    @Test
    void testSingleCharacter() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("a"));
    }

    @Test
    void testEmptyString() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome(""));
    }

    @Test
    void testSimplePalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("racecar"));
    }

    @Test
    void testNonPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();
        assertFalse(checker.isPalindrome("hello"));
    }

    @Test
    void testPalindromeWithSpaces() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testPalindromeWithPunctuation() {
        PalindromeChecker checker = new PalindromeChecker();
        assertTrue(checker.isPalindrome("Was it a car or a cat I saw?"));
    }
}
