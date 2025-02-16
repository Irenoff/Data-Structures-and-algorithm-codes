class BST {
    static class Node {
        int value;
        Node left, right;
        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    
    public boolean search(int value) {
        Node current = root;

        while (current != null) {
            if (current.value == value) {
                return true;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false; 
    }

    public void inorder() {
        if (root == null) {
            return;
        }

        Node current = root;
        Node prev = null;
        Node stack[] = new Node[100];
        int top = -1;

        
        while (current != null || top != -1) {
           
            while (current != null) {
                stack[++top] = current;
                current = current.left;
            }

            
            current = stack[top--];
            System.out.print(current.value + " ");

            
            current = current.right;
        }
    }

   
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

       
        System.out.println("Search 40: " + tree.search(40)); 
        System.out.println("Search 100: " + tree.search(100)); 

       
        System.out.print("Inorder traversal: ");
        tree.inorder();  
    }
}
