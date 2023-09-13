
public class ArrayDeque<T> {

    /**
     * Define the T Array.
     */
    private T [] array;

    /**
     * Define the length of the Array.
     */
    private int size;

    /**
     * Define the first index to store item.
     */
    private int nextFirst;

    /**
     * Define the last index to store item.
     */
    private int nextLast;

    /**
     * The constructor of the Array.
     */
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /**
     * Add item to the first of the Array, increase the Array when it is not bing enough.
     * @param item The item to add.
     */
    public void addFirst(T item) {
        if (size == array.length) {
            increaseArray(size * 2);
        }
        array[nextFirst] = item;
        size += 1;
        moveFirst();
    }

    /**
     * Add item to the last of the Array, increase the Array when it is not bing enough.
     * @param item The item to add.
     */
    public void addLast(T item) {
        if (size == array.length) {
            increaseArray(size * 2);
        }
        array[nextLast] = item;
        size += 1;
        moveLast();
    }

    /**
     * Determine whether the Array is empty.
     * @return The value whether the Array is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the size of the Array.
     * @return The size of the Array.
     */
    public int size() {
        return size;
    }

    /**
     * Print all the item of the Array.
     */
    public void printDeque() {
        for (T T : array) {
            System.out.print(T + " ");
        }
    }

    /**
     * Remove the first item of the Array.
     * @return The removed item.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (nextFirst == array.length - 1) {
            nextFirst = -1;
        }
        T temp = array[nextFirst + 1];
        array [nextFirst + 1] = null;
        nextFirst += 1;
        size -= 1;
        return temp;
    }

    /**
     * Remove the last item of the Array.
     * @return The removed item.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (nextLast == 0) {
            nextLast = array.length;
        }
        T temp = array[nextLast - 1];
        array [nextLast - 1] = null;
        nextLast -= 1;
        size -= 1;
        return temp;
    }

    /**
     * Get the item of the request position.
     * @param index The index of the position.
     * @return The item of the position of the index.
     */
    public T get(int index) {
        return array[index + nextFirst];
    }

    /**
     * Move the index of nextFirst when add item to first of Array.
     */
    private void moveFirst() {
        if (nextFirst == 0) {
            nextFirst = array.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    /**
     * Move the index of nextLast when add item to last of Array.
     */
    private void moveLast() {
        if (nextLast == (array.length - 1)) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    /**
     * Increase the size of the Array when the Array is not big enough.
     * @param length The size after increase.
     */
    private void increaseArray(int length) {
        T[] temp = (T[]) new Object[length];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
        nextFirst = array.length - 1;
        nextLast = size;
    }

    /**
     * Decrease the size of the Array when the Array is too long.
     * @param length The size after decrease.
     */
    private void decreaseArray(int length) {
        T[] temp = (T[]) new Object[length];
        System.arraycopy(array, nextFirst + 1, temp, 0, size);
        array = temp;
        nextFirst = array.length - 1;
        nextLast = size;
    }

    /*public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(1);
        A.addFirst(1);
        A.addFirst(1);
        A.addFirst(1);
        A.addFirst(1);
        A.addFirst(1);
        A.addFirst(1);
        A.addFirst(1);
        A.addFirst(1);
        A.removeFirst();
        A.removeLast();
    }*/
}
