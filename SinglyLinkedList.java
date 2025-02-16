public class SinglyLinkedList 
{
   
    public SinglyLinkedList() 
    {
        this.head = null;
    }

    
    static class Node 
    {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void insert(int data) 
    {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode; 
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; 
            }
            current.next = newNode; 
        }
    }

    public void display() 
    {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null"); 
    }


    public void delete(int value) 
    {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

       
        if (head.data == value) {
            head = head.next; 
            return;
        }

        
        Node current = head;
        Node previous = null;

        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        } else {
            System.out.println("Value not found in the list.");
        }
    }

    public boolean search(int value) 
    {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true; 
            }
            current = current.next;
        }
        return false; 
    }


    public static void main(String[] args) 
    {
        
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Singly Linked List:");
        list.display(); 
        System.out.println("Is 30 in the list? " + list.search(30)); 
        System.out.println("Is 100 in the list? " + list.search(100)); 

        
        System.out.println("Deleting 30 from the list.");
        list.delete(30);
        list.display(); 

        
        System.out.println("Deleting 100 from the list.");
        list.delete(100); 
        list.display();
    }
}
