
public class Palindrome {

    /**
     * Convert String to Deque.
     * @param word The String to be converted.
     * @return The Deque after convert.
     */
    public Deque<Character> wordToDeque(String word) {

        LinkedListDeque<Character> L = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            L.addLast(word.charAt(i));
        }

        return L;
    }

    /**
     * Test whether the word is a palindrome.
     * @param word The word need to be tested.
     * @return The value true or false.
     */
    public boolean isPalindrome(String word) {
        return isPalindromeHelp(wordToDeque(word));
    }

    /**
     * The help recursive method of isPalindrome.
     * @param word The Deque contain the letters.
     * @return the value true or false.
     */
    private boolean isPalindromeHelp(Deque<Character> word) {
        if (word.isEmpty() || word.size() == 1) {
            return true;
        }
        if (word.removeFirst() != word.removeLast()) {
            return false;
        }
        return isPalindromeHelp(word);
    }
}
