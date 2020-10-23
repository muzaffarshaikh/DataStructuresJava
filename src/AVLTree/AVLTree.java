package AVLTree;

import java.util.Scanner;

class Node {

    int key, height;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
        height = 1;
    }
}

class AVLTree {

    Node root;

    int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    Node rightRotateAVLTree(Node y) {

        Node x = y.left;
        Node b = x.right;
        x.right = y;
        y.left = b;
        int rhy = Math.max(height(y.left), height(y.right));
        int rhx = Math.max(height(x.left), height(x.right));
        y.height = rhy + 1;
        x.height = rhx + 1;
        return x;
    }

    Node leftRotateAVLTree(Node x) {
        Node y = x.right;
        Node b = y.left;
        y.left = x;
        x.right = b;
        int lhy = Math.max(height(y.left), height(y.right));
        int lhx = Math.max(height(x.left), height(x.right));
        y.height = lhy + 1;
        x.height = lhx + 1;
        return y;
    }

    int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            int height = Math.max(left, right) + 1;
            return height;

        }
    }

    int getBalanceFactor(Node node) {

        if (node == null) {
            return 0;
        }
        int balanceFactor = height(node.left) - height(node.right);
        return balanceFactor;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }
//    Node insertRec(Node root, int key) { 
//        if (root == null) { 
//            root = new Node(key); 
//            return root; 
//        } 
//        if (key < root.key) {
//            root.left = insertRec(root.left, key); 
//        }
//        else if (key > root.key) {
//            root.right = insertRec(root.right, key); 
//        }
//        return root; 
//    }

    Node insertRec(Node node, int key) {
        if (node == null) {
            return (new Node(key));
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left),
                height(node.right));
        int balance = getBalanceFactor(node);

        if (balance > 1 && balance < -1 && key < node.left.key) {
            return rightRotateAVLTree(node);
        }

        // Right Right Case 
        if (balance < -1 && balance > 1 && key > node.right.key) {
            return leftRotateAVLTree(node);
        }

        // Left Right Case 
        if (balance > 1 && balance < -1 && key > node.left.key) {
            node.left = leftRotateAVLTree(node.left);
            return rightRotateAVLTree(node);
        }

        // Right Left Case 
        if (balance < -1 && balance > 1 && key < node.right.key) {
            node.right = rightRotateAVLTree(node.right);
            return leftRotateAVLTree(node);
        }

        return node;
    }

    void inorder() {
        inorderTraversal(root);
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.key);
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int n, data;

        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter the number of queries you want to perform.");
        int number = 100;
        for (int i = 0; i < number; i++) {
            System.out.println("||||| AVLTree Operations |||||");
            System.out.println("       1. Insert Data.");
            System.out.println("       2. Delete Data.");
            System.out.println("       3. Tree Height.");
            System.out.println("       4. Balance Factor.");
            System.out.println("       5. Print Inorder.");
            System.out.println("       6. EXIT");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("How many elements do you want to enter?");
                    n = sc.nextInt();
                    System.out.println("Enter the values : ");
                    for (int j = 0; j < n; j++) {
                        data = sc.nextInt();
                        tree.insert(data);
                    }
                    break;

                case 2:

                case 3:
                    System.out.println("Height of tree is : " + tree.getHeight(tree.root));
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Balance factor of root is : " + tree.getBalanceFactor(tree.root));
                    System.out.println("");
                    break;

                case 5:
                    tree.inorder();
                    break;

                case 6:
                    return;
            }
        }
    }
}
