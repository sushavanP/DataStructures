package dataStructures.Trees.BinarySearchTrees;

public class searchAndInsert{
    static class Node{
        int data;
        Node left, right;

        Node(int key){
            data = key;
            left = right = null;
        }
    }
    Node root;

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insertRec(root.left, data);
        }else if(data > root.data){
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    void inOrder() {
        inOrderTraversal(root);
    }

    void inOrderTraversal(Node root) {
        if(root !=  null) {
            inOrderTraversal(root.left);
            System.out.print(root.data +" ");
            inOrderTraversal(root.right);
        }
    }

    public Node search(Node root, int data) {
        if(root == null || root.data == data)
            return root;

        if(root.data > data)
            return search(root.left, data);

        return search(root.right, data);
    }

    public static void main(String[] args){
        searchAndInsert tree = new searchAndInsert();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inOrder();

        System.out.println("\n" + tree.search(tree.root, 40));
    }
}






















