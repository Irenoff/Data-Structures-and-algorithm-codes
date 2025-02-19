

import java.util.NoSuchElementException;

public class ArrayCircularQueue {
    final int SIZE = 5; // Size of Circular Queue
    int front, rear;
    int items[] = new int[SIZE];

    ArrayCircularQueue() {
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    boolean isFull() {
        return (rear + 1) % SIZE == front; // Simplified full condition
    }

    // Check if the queue is empty
    boolean isEmpty() {
        return front == -1;
    }

    // Adding an element
    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) // Queue is empty
                front = 0;

            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println("Inserted: " + element);
        }
    }

    // Removing an element
    int deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        } else {
            int element = items[front];

            if (front == rear) { // Queue has only one element
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % SIZE;
            }
            return element;
        }
    }

    // Display the elements in the queue
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Items: [");
        int i = front;
        do {
            System.out.print(items[i]);
            if ((i + 1) % SIZE != (rear + 1) % SIZE) {
                System.out.print(", ");
            }
            i = (i + 1) % SIZE;
        } while (i != (rear + 1) % SIZE);

        System.out.println("]");

        System.out.print("Indexes: ");
        i = front;
        do {
            System.out.print(i);
            if ((i + 1) % SIZE != (rear + 1) % SIZE) {
                System.out.print(", ");
            }
            i = (i + 1) % SIZE;
        } while (i != (rear + 1) % SIZE);
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue();

        // Attempting to dequeue from an empty queue
        try {
            q.deQueue(); // This will throw exception
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        // Enqueuing elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // Trying to enqueue when the queue is full
        q.enQueue(6); // This will fail because the queue is full

        q.display();

        // Dequeuing an element
        int element = q.deQueue();
        if (element != -1) {
            System.out.println("Deleted Element is " + element);
        }

        q.display();

        // Enqueuing another element
        q.enQueue(7);
        q.display();

        // Trying to enqueue again when the queue is full
        q.enQueue(8); // This will fail again
    }
}
