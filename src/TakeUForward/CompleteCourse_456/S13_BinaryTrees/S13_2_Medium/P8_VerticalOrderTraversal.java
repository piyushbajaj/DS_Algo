package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 30 Sep, 2022
 * <p>
 * striver: <a href="https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/">...</a>
 * lc: <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/0">...</a>
 */
public class P8_VerticalOrderTraversal {

    public static void main(String[] args) {
        P8_VerticalOrderTraversal p8_verticalOrderTraversal = new P8_VerticalOrderTraversal();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p8_verticalOrderTraversal.verticalOrderTraversal(root));

        System.out.println(p8_verticalOrderTraversal.verticalOrderTraversal_better(root));

        System.out.println(p8_verticalOrderTraversal.verticalOrderTraversal_improve(root));
    }

    /**
     * The problem in this is everytime
     * arraylist needs to be sorted, hence it won't work out for every use case.
     *
     * @param curr
     * @return
     */
    public List<List<Integer>> verticalOrderTraversal(TreeNode curr) {

        List<List<Integer>> result = new ArrayList<>();

        // To store distance and corresponding to that is the
        Map<Integer, List<Integer>> verticalOrderMap = new TreeMap<>();

        verticalOrderTraversal_util(curr, verticalOrderMap, 0);

        for (Map.Entry<Integer, List<Integer>> arr : verticalOrderMap.entrySet()) {
            result.add(arr.getValue());
        }

        return result;

    }

    public void verticalOrderTraversal_util(TreeNode curr, Map<Integer, List<Integer>> verticalOrderMap, int distance) {
        if (curr != null) {
            if (verticalOrderMap.containsKey(distance)) {
                List<Integer> arr = verticalOrderMap.get(distance);
                arr.add(curr.data);
                Collections.sort(arr);
                verticalOrderMap.put(distance, arr);
            } else {
                verticalOrderMap.put(distance, new ArrayList<>(Collections.singletonList(curr.data)));
            }
            verticalOrderTraversal_util(curr.left, verticalOrderMap, distance - 1);
            verticalOrderTraversal_util(curr.right, verticalOrderMap, distance + 1);
        }
    }

    /**
     * Approach:
     * 1. We need to keep storing each node's value, distance and level -> will create custom class tuple
     * 2. Will store this in queue with LEVEL ORDER TRAVERSAL approach
     * 3. In each iteration we are adding to verticalOrderTreeMap
     * 4. Will check if there is distance exists, if it doesn't then will add new TreeMap
     * 5. Will check if there is distance exists and level exists, if it doesn't then will add new level
     * 6. Will add the given distance, level and current node to the verticalOrderTreeMap
     * 7. Then add the left node in the queue, and add the right node in the queue
     * TC: O(N*logN*logN*logN)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public List<List<Integer>> verticalOrderTraversal_better(TreeNode curr) {
        List<List<Integer>> result = new ArrayList<>();

        // Distance -> Level -> Node Value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticalOrderTreeMap = new TreeMap<>();

        Queue<Tuple> tupleQueue = new LinkedList<>();
        tupleQueue.offer(new Tuple(curr, 0, 0));
        while (!tupleQueue.isEmpty()) {
            Tuple currTuple = tupleQueue.remove();
            TreeNode currNode = currTuple.key;
            int distance = currTuple.distance;
            int level = currTuple.level;

            if (!verticalOrderTreeMap.containsKey(distance)) {
                verticalOrderTreeMap.put(distance, new TreeMap<>());
            }

            if (!verticalOrderTreeMap.get(distance).containsKey(level)) {
                verticalOrderTreeMap.get(distance).put(level, new PriorityQueue<>());
            }

            verticalOrderTreeMap.get(distance).get(level).offer(currNode.data);

            if (currNode.left != null) {
                tupleQueue.offer(new Tuple(currNode.left, distance - 1, level + 1));
            }

            if (currNode.right != null) {
                tupleQueue.offer(new Tuple(currNode.right, distance + 1, level + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> levelQueueTreeMap : verticalOrderTreeMap.values()) {
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : levelQueueTreeMap.values()) {
                while (!nodes.isEmpty()) {
                    // result.get(result.size() - 1) -> This will just make sure that we are adding everything under
                    // result 1st index
                    result.get(result.size() - 1).add(nodes.poll());
                }
            }
        }

        return result;

    }

    public List<List<Integer>> verticalOrderTraversal_improve(TreeNode curr) {
        List<List<Integer>> result = new ArrayList<>();
        if (curr == null) {
            return result;
        }

        Queue<Pair> pairQueue = new LinkedList<>();
        // Distance along with nodes
        Map<Integer, ArrayList<TreeNode>> hashMap = new HashMap<>();

        pairQueue.offer(new Pair(curr, 0));
        int minDistance = 0, maxDistance = 0;

        while (!pairQueue.isEmpty()) {
            Pair tempPair = pairQueue.remove();
            TreeNode node = tempPair.node;
            int distance = tempPair.distance;

            if (!hashMap.containsKey(distance)) {
                hashMap.put(distance, new ArrayList<>());
            }
            hashMap.get(distance).add(node);

            if (node.left != null) {
                pairQueue.add(new Pair(node.left, distance - 1));
            }

            if (node.right != null) {
                pairQueue.add(new Pair(node.right, distance + 1));
            }

            minDistance = Math.min(minDistance, distance);
            maxDistance = Math.max(maxDistance, distance);
        }

        for (int i = minDistance; i <= maxDistance; i++) {
            List<Integer> subResult = new ArrayList<>();
            ArrayList<TreeNode> nodeArrayList = hashMap.get(i);
            for (TreeNode node : nodeArrayList) {
                subResult.add(node.data);
            }
            result.add(subResult);
        }

        return result;
    }

    static class Tuple {
        TreeNode key;
        int distance, level;

        Tuple(TreeNode key, int distance, int level) {
            this.key = key;
            this.distance = distance;
            this.level = level;
        }
    }

    /**
     * G4G version: <a href="https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/0">...</a>
     */
    static class Pair {
        TreeNode node;
        int distance;

        Pair(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
