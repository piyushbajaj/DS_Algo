package BinaryTree;

/**
 * Created by piyush.bajaj on 07/02/17.
 */
public class BinarySubTreeImproved {
    static Node root;
    Passing p = new Passing();

    //Driver program to LinkedList.test above functions
    public static void main(String args[]) {
        BinarySubTreeImproved tree = new BinarySubTreeImproved();
        Node T = new Node('a');
        T.left = new Node('b');
        T.right = new Node('d');
        T.left.left = new Node('c');
        T.right.right = new Node('e');

        Node S = new Node('a');
        S.left = new Node('b');
        S.right = new Node('d');
        S.left.left = new Node('c');

        //System.out.println(tree.checkSubTree(T, S));

        if (tree.isSubtree(T, S)) {
            System.out.println("Yes , S is a subtree of T");
        } else {
            System.out.println("No, S is not a subtree of T");
        }
    }

    String strstr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength) {
            return null;
        }
        if (nLength == 0) {
            return haystack;
        }
        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                for (; j < nLength; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == nLength) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }

    // A utility function to store inorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
    void storeInorder(Node node, char arr[], Passing i) {
        if (node == null) {
            arr[i.i++] = '$';
            return;
        }
        storeInorder(node.left, arr, i);
        arr[i.i++] = node.data;
        storeInorder(node.right, arr, i);
    }

    // A utility function to store preorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
    void storePreOrder(Node node, char arr[], Passing i) {
        if (node == null) {
            arr[i.i++] = '$';
            return;
        }
        arr[i.i++] = node.data;
        storePreOrder(node.left, arr, i);
        storePreOrder(node.right, arr, i);
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Node T, Node S) {
        /* base cases */
        if (S == null) {
            return true;
        }
        if (T == null) {
            return false;
        }

        // Store Inorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        //String inT;
        //String inS;
        char inT[] = new char[100];
        char inS[] = new char[100];
        storeInorder(T, inT, p);
        //inT[p.m] = '\0';

        storeInorder(S, inS, p);
        inS[p.m] = '\0';
        String op1 = String.valueOf(inT);
        String op2 = String.valueOf(inS);

        // If inS[] is not a substring of preS[], return false
        if (strstr(op1, op2) != null) {
            return false;
        }

        // Store Preorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        p.m = 0;
        p.n = 0;
        char preT[] = new char[100];
        char preS[] = new char[100];
        String op3 = String.valueOf(preT);
        String op4 = String.valueOf(preS);
        storePreOrder(T, preT, p);
        storePreOrder(S, preS, p);
        preT[p.m] = '\0';
        preS[p.n] = '\0';

        // If inS[] is not a substring of preS[], return false
        // Else return true
        return (strstr(op3, op4) != null);
    }

    public boolean checkSubTree(Node N1, Node N2) {
        if (N1 == null && N2 == null) {
            return true;
        } else if (N1 == null && N2 != null) {
            return false;
        } else if (N1 != null && N2 == null) {
            return false;
        } else if (N1.data == N2.data) {
            return checkSubTree(N1.left, N2.left) && checkSubTree(N1.right, N2.right);
        } else {
            checkSubTree(N1.left, N2);
            checkSubTree(N1.right, N2);
        }
        return false;
    }

    // Java program to check if binary tree is subtree of another binary tree
    public static class Node {

        char data;
        Node left, right;

        Node(char item) {
            data = item;
            left = right = null;
        }
    }

    class Passing {

        int i;
        int m = 0;
        int n = 0;
    }


// This code is contributed by Mayank Jaiswal
}
