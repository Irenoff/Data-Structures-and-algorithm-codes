
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;



    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enQueue(int data) {
        stack1.push(data);
    }

    public int deQueue() {
        if (isEmpty())

            throw new IllegalStateException("Queue is empty");

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();


        
    }

    public boolean isEmpty() {
        
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");


        for (int i = 0; i < stack2.size(); i++) {

            result.append(stack2.get(i));

            if (i < stack2.size() - 1) result.append(", ");
        }

        for (int i = stack1.size() - 1; i >= 0; i--) {
            if (result.length() > 1) result.append(", ");

            result.append(stack1.get(i));
        }
        result.append("]");

        return result.toString();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue);  



        queue.deQueue();
        System.out.println(queue);  

        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue);  

        queue.deQueue();
        System.out.println(queue);  
    }
}
