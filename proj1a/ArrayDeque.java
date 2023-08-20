
public class ArrayDeque<Type> {

    /**
     * Define the T Array.
     */
    private Type [] Array;

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
     * Increase the size of the Array when the Array is not big enough.
     * @param length The size after increase.
     */
    private void increaseArray(int length) {
        Type[] temp = (Type[]) new Object[length];
        System.arraycopy(Array, nextFirst - 1, temp, 0, size);
        Array = temp;
    }

    /**
     * Decrease the size of the Array when the Array is too long.
     * @param length The size after decrease.
     */
    private void decreaseArray(int length) {
        Type[] temp = (Type[]) new Object[length];
        System.arraycopy(Array, nextFirst - 1, temp, 0, size);
    }

    /**
     * The constructor of the Array.
     */
    public ArrayDeque() {
        Array = (Type[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /**
     * Add item to the first of the Array.
     * @param item The item to add.
     */
    public void addFirst(Type item) {
        if (size == Array.length) {
            increaseArray(size * 2);
        }
        Array[nextFirst] = item;
        size += 1;
        if (nextFirst == 0) {
            nextFirst = size;
        } else {
            nextFirst -= 1;
        }
    }

    /**
     * Add item to the last of the Array.
     * @param item The item to add.
     */
    public void addLast(Type item) {
        if (size == Array.length) {
            increaseArray(size * 2);
        }
        Array[nextLast] = item;
        size += 1;
        if (nextLast == (size - 1)) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
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
        for (Type type : Array) {
            System.out.print(type + " ");
        }
    }

    /**
     * Remove the first item of the Array.
     * @return The removed item.
     */
    public Type removeFirst() {
        if (size < Array.length / 4) {
            decreaseArray(size / 2);
        }
        Type temp = Array[nextFirst + 1];
        Array [nextFirst + 1] = null;
        nextFirst += 1;
        return temp;
    }

    /**
     * Remove the last item of the Array.
     * @return The removed item.
     */
    public Type removeLast() {
        if (size < Array.length / 4) {
            decreaseArray(size / 2);
        }
        Type temp = Array[nextLast - 1];
        Array [nextFirst - 1] = null;
        nextFirst -= 1;
        return temp;
    }

    /**
     * Get the item of the request position.
     * @param index The index of the position.
     * @return The item of the position of the index.
     */
    public Type get(int index) {
        return Array[index + nextFirst];
    }
}
