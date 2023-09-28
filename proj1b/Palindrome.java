
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        LinkedListDeque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            L.addLast(word.charAt(i));
        }
        return L;
    }
}
