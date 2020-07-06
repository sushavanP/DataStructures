package dataStructures.Trees.BinarySearchTrees;

public class preAndSucBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    };
    Node root;
    static Node pred;
    static Node succ;

    static void findPreAndSuccessor(Node root, int key) {
        if(root == null) return;

        while(root != null) {
            if(root.data == key) {

                if(root.right != null){
                    succ = root.right;
                    while(succ.left != null) {
                        succ = succ.left;
                    }
                }

                if(root.left != null) {
                    pred = root.left;
                    while(pred.right != null) {
                        pred = pred.right;
                    }
                }

                return;
            }

            else if(root.data < key) {
                pred = root;
                root = root.right;
            }

            else {
                succ = root;
                root = root.left;
            }
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(root.data > data) {
            root.left = insertRec(root.left, data);
        }

        else if(root.data < data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    /*static Node newNode(int item)
    {
        Node temp = new Node(item);
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }*/

    public static void main(String[] args) {
        preAndSucBST tree = new preAndSucBST();
        int key = 05;

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        findPreAndSuccessor(tree.root, key);
        if (pred != null)
            System.out.println("Predecessor is " +
                    pred.data);
        else
            System.out.println("-1");

        if (succ != null)
            System.out.println("Successor is " + succ.data);
        else
            System.out.println("-1");
    }
}

