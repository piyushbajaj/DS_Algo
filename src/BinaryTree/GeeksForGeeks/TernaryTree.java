package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 19/09/17.
 */
public class TernaryTree {
    Node root;

    TernaryTree() {
        root = null;
    }

    TernaryTree(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            new Node(data);
        }
    }

    static class Node {
        Node left, right, middle;
        int data;

        Node(int data) {
            this.data = data;
            this.left = this.right = this.middle = null;
        }
    }


}
