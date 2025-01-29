/*
Two words are anagrams of each other if they contain the same letters that are arranged in different orders.
Write a recursive method that can identify if two given words are anagrams of each other.
 */

import java.util.Scanner;

public class Section_18_1 {
    public static void main(String[] args) {
        Scanner scanscan = new Scanner(System.in);
        System.out.println("Anagram Checker"+"\n"+"---------------");
        System.out.println("Enter the first word: ");
        String word1 = scanscan.nextLine();
        System.out.println("Enter the second word: ");
        String word2 = scanscan.nextLine();

        // Calls the recursive method to check if the words are anagrams
        if (isAnagram(word1, word2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }

        // Closes the Scanner datastream
        scanscan.close();
    }

    // Recursive method to check if two words are anagrams
    public static boolean isAnagram(String str1, String str2) {
        // Base case: if both strings are empty, they are anagrams
        if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }

        // If lengths don't match, not an anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        // Take the first character of str1 and search for it in str2
        char ch = str1.charAt(0);
        // Find the position of this letter in str2
        int index = findIndex(str2, ch); // Find manually instead of using indexOf
        // If the letter is not found, the words are not anagrams
        if (index == -1) {
            return false;
        }

        // Create new strings without the found character and check recurisvely
        String newStr1 = str1.substring(1);
        // Remove the matching letter from str2
        String newStr2 = removeCharacter(str2, index);

        // Recursively check if the remaining letters form an anagram
        return isAnagram(newStr1, newStr2);
    }

    // Find the index of a character in a string manually
    public static int findIndex(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) { // If the char is found, return its position
                return i;
            }
        }
        return -1; // Return -1 if the char is not found
    }

    // Removes a character at a given index form a string manually
    public static String removeCharacter(String str, int index) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i != index) { // Skip the char at the given index
                result += str.charAt(i);
            }
        }
        return result; // Return the modified string
    }
}
