
public class LinkedListDeque<T> {

    private class Node {

        private Node prev;
        private T item;
        private Node next;

        /**
         * Constructor of the Node Class.
         * @param p The previous Node of this Node.
         * @param i The value of the item.
         * @param n The next Node of this Node.
         */
        private Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }

        private Node(Node p, Node n) {
            prev = p;
            next = n;
        }
    }

    /**
     * Store the sentinel note of the queue.
     */
    private Node sentinel;

    /**
     * Store the size of the queue.
     */
    private int size;

    /**
     * The constructor of an empty queue.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Add item to the first of the queue.
     * @param i The item need to add.
     */
    public void addFirst(T i) {
        Node newNode = new Node(sentinel, i, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /**
     * Add item to the last of the queue.
     * @param i The item need to add.
     */
    public void addLast(T i) {
        Node newNode = new Node(sentinel.prev, i, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /**
     * Determine whether the queue is empty.
     * @return The value of the queue.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of the queue.
     * @return The size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Print the queue.
     */
    public void printDeque() {
        Node n = sentinel.next;
        while (n.next != sentinel.next) {
            System.out.print(n.item + " ");
            n = n.next;
        }
    }

    /**
     * Remove the first item of the queue.
     * @return The removed item.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node n = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return n.item;
    }

    /**
     * Remove the last item of the queue.
     * @return The removed item.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node n = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return n.item;
    }

    /**
     * Get the item of the request position.
     * @param index The index of the position.
     * @return The item of the position of the index.
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node n = sentinel;
        while (index >= 0) {
            n = n.next;
            index -= 1;
        }
        return n.item;
    }

    /**
     * Get the item of the request position using recursive.
     * @param index The index of the position.
     * @return The item of the position of the index.
     */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

    private T getRecursiveHelp(Node node, int index) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursiveHelp(node.next, index - 1);
        }
    }
}
