
class BSTNode {
    private BSTNode leftNode; 
    private BSTNode rightNode;
    private int data; 

   
    public BSTNode(int value) {
        this.data = value; 
        this.leftNode = null; 
        this.rightNode = null; 
    }


    public int getData() {
        return data;
    }

    public BSTNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BSTNode leftNode) {
        this.leftNode = leftNode;
    }

    public BSTNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BSTNode rightNode) {
        this.rightNode = rightNode;
    }
}


class BST {
    
    public void insert(BSTNode root, int value) {
    
        if (root == null) {
            root = new BSTNode(value);
        } else {
            
            if (value < root.getData()) {
               
                if (root.getLeftNode() == null) {
                    root.setLeftNode(new BSTNode(value));
                } else {
                   
                    insert(root.getLeftNode(), value);
                }
            } else {
               
                if (root.getRightNode() == null) {
                    root.setRightNode(new BSTNode(value));
                } else {
                    
                    insert(root.getRightNode(), value);
                }
            }
        }
    }

   
    public boolean findValueRecursively(BSTNode node, int value) {
        
        if (node == null) {
            return false;
        }

     
        if (value == node.getData()) {
            return true;
        } else if (value < node.getData()) {
           
            return findValueRecursively(node.getLeftNode(), value);
        } else {
            
            return findValueRecursively(node.getRightNode(), value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        BST bst = new BST();

      
        BSTNode bstNode = new BSTNode(4);

        
        bst.insert(bstNode, 2); // Insert value 2
        bst.insert(bstNode, 5); // Insert value 5
        bst.insert(bstNode, 6); // Insert value 6
        bst.insert(bstNode, 1); // Insert value 1
        bst.insert(bstNode, 3); // Insert value 3
        bst.insert(bstNode, 7); // Insert value 7

      
        if (bst.findValueRecursively(bstNode, 7)) {
            System.out.println("Element is found!"); 
        } else {
            System.out.println("Element is not found!"); 
        }
    }
}

