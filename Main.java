import java.util.Scanner;

public class Main {

    // Class Node represents a node in the binary tree
    class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    // Class BinaryTree represents the binary tree structure
    class BinaryTree {
        Node root;

        // marker to track if a delete operation was successful
        boolean deleteSuccess;

        // Constructor initializes the binary tree with no nodes
        public BinaryTree() {
            root = null;

        }

        // Method to create initial binary search tree with values 1 to 7
        public void createInitialTree() {
            root = new Node(4);
            root.leftChild = new Node(2);
            root.rightChild = new Node(6);
            root.leftChild.leftChild = new Node(1);
            root.leftChild.rightChild = new Node(3);
            root.rightChild.leftChild = new Node(5);
            root.rightChild.rightChild = new Node(7);

            System.out.println("Binary Search Tree created with values: 1, 2, 3, 4, 5, 6, 7");
        }

        // Method to insert a new value into the binary search tree
        public void insert(int value) {
            root = insertRec(root, value);
        }

        // Recursive helper method to insert a new value from root
        public Node insertRec(Node root, int value) {
            // If the tree is empty, create a new node
            if (root == null) {
                return new Node(value);
            }

            // If the value is less than the root's data, insert it in the left subtree
            // If the value is greater than the root's data, insert it in the right subtree
            if (value < root.data) {
                root.leftChild = insertRec(root.leftChild, value);
            } else if (value > root.data) {
                root.rightChild = insertRec(root.rightChild, value);
            }
            return root;
        }

         // Method to delete a value from the binary search tree
         public void delete(int value) {
            deleteSuccess = false; // Reset the flag
            root = deleteRec(root, value);
            if (deleteSuccess) {
                System.out.println("Value " + value + " deleted from the binary search tree.");
            } else {
                System.out.println("Value " + value + " not found in the binary search tree.");
            }
        }

        // Recursive helper method for removing a node
        public Node deleteRec(Node root, int value) {
            // If the tree is empty, return null
            if (root == null) {
                return root;
            }

            // Traverse tree to find the node to delete
            if (value < root.data) {
                root.leftChild = deleteRec(root.leftChild, value);
            } else if (value > root.data) {
                root.rightChild = deleteRec(root.rightChild, value);
            } else {
                // Found the node to delete
                deleteSuccess = true;
                
                // Node with only one child or no child
                if (root.leftChild == null) {
                    return root.rightChild;
                } else if (root.rightChild == null) {
                    return root.leftChild;
                }

                // Node with two children: get the inorder successor (smallest in the right subtree)
                root.data = minValue(root.rightChild);

                // Delete the inorder successor
                root.rightChild = deleteRec(root.rightChild, root.data);
            }
            return root;
        }

        // method to find the minimum value in a subtree
        public int minValue(Node node) {
            while (node.leftChild != null) {
                node = node.leftChild;
            }
            return node.data;
        }

        // method for InOrder traversal
        public void inOrder() {
            System.out.print("InOrder Traversal: ");
            if (root == null) {
                System.out.println("Tree is empty.");
            } else {
                inOrderRec(root);
                System.out.println();
            }
        }

        // recursive method for InOrder traversal
        public void inOrderRec(Node node) {
            if (node != null) {
                inOrderRec(node.leftChild);
                System.out.print(node.data + " ");
                inOrderRec(node.rightChild);
            }
        }

        // method for PreOrder traversal
        public void preOrder() {
            System.out.print("PreOrder Traversal: ");
            if (root == null) {
                System.out.println("Tree is empty.");
            } else {
                preOrderRec(root);
                System.out.println();
            }
        }

        // recursive method for PreOrder traversal
        public void preOrderRec(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preOrderRec(node.leftChild);
                preOrderRec(node.rightChild);
            }
        }

        // method for PostOrder traversal
        public void postOrder() {
            System.out.print("PostOrder Traversal: ");
            if (root == null) {
                System.out.println("Tree is empty.");
            } else {
                postOrderRec(root);
                System.out.println();
            }
        }

        // recursive method for PostOrder traversal
        public void postOrderRec(Node node) {
            if (node != null) {
                postOrderRec(node.leftChild);
                postOrderRec(node.rightChild);
                System.out.print(node.data + " ");
            }
        }

    }
    
    // command line interface for user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        BinaryTree tree = main.new BinaryTree();

        // menu options
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a binary search tree");
            System.out.println("2. Add a node");
            System.out.println("3. Delete a node");
            System.out.println("4. InOrder Traversal");
            System.out.println("5. PreOrder Traversal");
            System.out.println("6. PostOrder Traversal");
            System.out.println("7. Exit");

            // call method based on user choice
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    tree.createInitialTree();
                    break;
                case 2:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    tree.insert(insertValue);
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    tree.delete(deleteValue);
                    break;
                case 4:
                    tree.inOrder();
                    break;
                case 5:
                    tree.preOrder();
                    break;
                case 6:
                    tree.postOrder();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}