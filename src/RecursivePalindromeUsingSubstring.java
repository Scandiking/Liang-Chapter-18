public class RecursivePalindromeUsingSubstring {
    // Method that checks whether it is a palindrome or not
    public static boolean isPalindrome(String s) {
        // if the palindrome has 1 or less characters, it is a palindrome ("a" is a palindrome, "ab" is not")
        if (s.length() <= 1) return true;
        // Checks whether the first and last characters are different, if they are; the string is not a palindrome
        else if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;
        // If the first and last char DO match, check the substring (excluding first and last chars)
        else return isPalindrome(s.substring(1, s.length() - 1));
    }

    // Examples
    public static void main(String[] args) {
        System.out.println("Is moon a palindrome? " + isPalindrome("moon"));
        System.out.println("Is noon a palindrome? " + isPalindrome("noon"));
        System.out.println("Is a a palindrome? " + isPalindrome("a"));
        System.out.println("Is aba a palindrome? " + isPalindrome("aba"));
        System.out.println("Is ab a palindrome? " + isPalindrome("abc"));
    }
}
