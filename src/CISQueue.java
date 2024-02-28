import java.util.Arrays;

public class CISQueue<T> {

    // Array property.
    private Object[] arr;

    // Size property.
    private int size;
    
    // Index pointer. Indicates the index of the most recently added element.
    private int pointer;

    // Constructor.
    public CISQueue(int size) {
        arr = new Object[size];
        this.size = 0;
        pointer = -1;
    }

    // Enqueue. This method adds a node to the end of the linked list.
    public void enqueue(T val) {
        arr[++pointer] = val;
        size++;
    }

    // Dequeue. This method removes a node from the beginning of the linked list.
    public T dequeue() {
        if (size == 0) return null;
        T pop = (T) arr[0];
        reshuffle();
        size--;
        pointer--;
        return pop;
    }

    // isEmpty. Returns a boolean indicating whether the linked list is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // size. Returns the size of the queue.
    public int size() {
        return size;
    }

    // reshuffle. Moves each element down one index. Called whenever we dequeue.
    public void reshuffle() {
        for (int i = 0; i < pointer; ++i) {
            arr[i] = arr[i+1];
        }
        arr[pointer] = null;
    }

    // toString. Returns a description of the queue in, for example, the following format:
    // CISQueue{queue=[7, 11], size=2, pointer=1}
    public String toString() {
        StringBuilder s = new StringBuilder("CISQueue{queue=[");
        for (int i = 0; i < arr.length; ++i) {
            s.append(arr[i]);
            if (i < arr.length - 1) s.append(", ");
        }
        s.append("], size=");
        s.append(size);
        s.append(", pointer=");
        s.append(pointer);
        s.append("}");
        return s.toString();
    }
}
