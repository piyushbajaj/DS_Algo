package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 18/12/16.
 */
public class numOfFullNodes {
    Node root;

    public numOfFullNodes() {
        root = null;
    }

    public numOfFullNodes(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        numOfFullNodes BT = new numOfFullNodes(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println("Number of full nodes in the binary tree is: " + BT.countOfFullNodes(BT.root));
    }

    public int countOfFullNodes(Node key) {
        if (key == null) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(key);
        int count = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp != null) {
                if (temp.right != null && temp.left != null) {
                    count++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
            }
        }
        return count;

    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
