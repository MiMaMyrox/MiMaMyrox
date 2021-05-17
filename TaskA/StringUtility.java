package edu.kit.informatik.TaskA;

/**
 * @author uxqcz
 * @version 1.0.0
 */

public final class StringUtility {
    private StringUtility() { }

    /**
     * the method reverses a given string and returns the result
     * @param word the String to be reversed
     * @return     the reversed String
     */

    static String reverse(String word) {
        char[] wordCh = word.toCharArray();
        int lastIndex = wordCh.length - 1;
        for (int i = 0; i < wordCh.length / 2; i++) {
            char temp = wordCh[i];
            wordCh[i] = wordCh[lastIndex - i];
            wordCh[lastIndex - i] = temp;
        }
        return new String(wordCh);
    }

    /**
     * checks if a given String is a palindrome
     * @param word  the String to be checked being a palindrome
     * @return      the boolean result of a given String
     */

    static boolean isPalindrome(String word) {
        String reversedWord = reverse(word);
        return word.equals(reversedWord);
    }

    /**
     *
     * @param word  the String to remove one character from
     * @param index the Integer indexes the character to be removed
     * @return      the String without the removed character
     */

    static String removeCharacter(String word, int index) {
        char[] wordCh = word.toCharArray();
        char[] resultCh = new char[wordCh.length - 1];
        //copy every char upto the index
        for (int i = 0; i < index; i++) {
            resultCh[i] = wordCh[i];
        }
        //copy every char after the index
        for (int i = index; i < resultCh.length; i++) {
            resultCh[i] = wordCh[i + 1];
        }
        return new String(resultCh);
    }

    /**
     * checks if 2 given Strings are anagrams of each other
     * @param word1 the first String to be compared
     * @param word2 the second String to be compared
     * @return      boolean result if the given strings are anagrams
     */
    static boolean isAnagram(String word1, String word2) {
        char[] sortedWord1 = sortCharAr(word1.toCharArray());
        char[] sortedWord2 = sortCharAr(word2.toCharArray());
        return sortedWord1.equals(sortedWord2);
    }

    /**
     * the method sorts an char array alphabetically via bubble sort
     * @param charAr    the char array to be sorted
     * @return          the sorted char array
     */
    static char[] sortCharAr(final char[] charAr) {
        char[] sortAr = charAr;
        //bubble sort
        for (int i = 0; i < sortAr.length; i++) {
            for (int j = 0; j < sortAr.length - i - 1; j++) {
                if (sortAr[j] > sortAr[j + 1]) {
                    char temp = sortAr[j];
                    sortAr[j] = sortAr[j + 1];
                    sortAr[j + 1] = temp;
                }
            }
        }
        return sortAr;
    }

    /**
     * capitalizes the given String
     * @param word  the String to be capitalized
     * @return      the capitalized String
     */
    static String capitalize(String word) {
        if (word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    /**
     * counts the number of times a given character is found
     * @param word      the word to be searched in
     * @param character the char to be counted
     * @return          number of occurrences of character
     */
    static int countCharacter(String word, char character) {
        int count = 0;
        char[] wordCh = word.toCharArray();
        for (char itChar:wordCh
             ) {
            if (itChar == character) {
                count++;
            }
        }
        return count;
    }
}
