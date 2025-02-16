import java.util.NoSuchElementException;

public class BoundedStack {

    private int maxSize; 
    private int[] array; 
    private int tos;     

    public BoundedStack(int s) {
        maxSize = s; 
        array = new int[maxSize];
        tos = -1; 
    }
    public boolean isEmpty() {
        return tos == -1; 
    }

    public boolean isFull() {
        return tos == maxSize - 1; 
    }
   
    public void push(int j) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full.");
        } else {
            array[++tos] = j; 
        }
    }
   
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        } else {
            return array[tos--]; 
        }
    }

    
    public int peek() {
        if (tos == -1) {
            throw new NoSuchElementException("Stack is empty");
        } else {
            return array[tos];
        }
    }

   
    public void print() {
        System.out.print("Stack elements: []");
        for (int i = tos; i >= 0; i--) {
            System.out.print(array[i] + (i > 0 ? ", " : ""));
        }
        System.out.println("]");
    }

    
    public static void main(String[] args) {
        BoundedStack stack = new BoundedStack(5); 

        System.out.println("Pushing elements onto the stack...");
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);

        stack.print(); 

        System.out.println("\nPeeking top element: " + stack.peek());

        System.out.println("\nPopping elements...");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        stack.print(); 
    }
}
