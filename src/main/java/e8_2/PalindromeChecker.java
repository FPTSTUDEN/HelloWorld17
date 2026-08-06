package e8_2;

public class PalindromeChecker {
    public boolean isPalindrome(String text) {
        // Remove non-alphanumeric characters and convert to lowercase
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Regex: ^ means start of string, $ means end of string, [^a-zA-Z0-9] means any character that is not a letter or digit, + means one or more occurrences, and replaceAll replaces all matches with an empty string. toLowerCase converts the string to lowercase.
        
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
