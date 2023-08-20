
public class LinkedListDeque<T> {

    private class Node {

        public Node prev;
        public T item;
        public Node next;

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
    }

    /**
     * Store the sentinel note of the queue.
     */
    private Node sentinel;

    /**
     * Store the size of the queue.
     */
    private int size = 0;

    /**
     * The constructor of an empty queue.
     */
    public LinkedListDeque() {
        sentinel = new Node(sentinel, null, sentinel);
        sentinel.next = sentinel;
    }

    /**
     * The constructor of the queue.
     * @param i The item of the first Node.
     */
    public LinkedListDeque(T i) {
        sentinel = new Node(sentinel, null, sentinel);
        sentinel.next = new Node(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;
        size += 1;
    }

    /**
     * Add item to the first of the queue.
     * @param i The item need to add.
     */
    public void addFirst(T i) {
        sentinel.next = new Node(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /**
     * Add item to the last of the queue.
     * @param i The item need to add.
     */
    public void addLast(T i) {
        sentinel.prev = new Node(sentinel.prev, i, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
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
        if (index == 0) {
            return sentinel.item;
        }
        sentinel = sentinel.next;
        return get(index - 1);
    }

    /**
     * Get the item of the request position using recursive.
     * @param index The index of the position.
     * @return The item of the position of the index.
     */
    public T getRecursive(int index) {
        Node n = sentinel;
        while (index - 1 > 0) {
            n = n.next;
            index --;
        }
        return n.item;
    }
}
