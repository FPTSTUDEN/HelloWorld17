package e8_2;

public class PalindromeChecker {
    public boolean isPalindrome(String text) {
        // Remove non-alphanumeric characters and convert to lowercase
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Regex: [^] means "not" and a-zA-Z0-9 means all alphanumeric characters. So [^a-zA-Z0-9] means "not alphanumeric". The replaceAll method replaces all non-alphanumeric characters with an empty string, effectively removing them from the text. The toLowerCase method converts the text to lowercase to ensure that the palindrome check is case-insensitive.
        
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
