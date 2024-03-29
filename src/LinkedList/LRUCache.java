package LinkedList;//import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 14/03/17.
 * Algorithm for LRU Cache:
 * 1. Use HashMap to store key and LinkedList.Node of every element.
 * 2. Use doubly linked list to maintain head, tail and size of list.
 * 3. First will define the cache size means size of Doubly linked list, then in that will check if that element is present
 * in Hash or not, if present then will bring on top, if not will add.
 * 4. Now while adding, first will check the current size of cache if its already reached max. size, then will remove the last
 * element from the list.
 * 5. Now we can add as a header.
 */
public class LRUCache {

    private final int cacheSize;
    private DoublyLinkedList pageList;
    private HashMap<Integer, Node> pageMap;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoublyLinkedList(cacheSize);
        pageMap = new HashMap<Integer, Node>();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }

    public void accessPage(int pageNumber) {
        Node pageNode = null;
        if (pageMap.containsKey(pageNumber)) {
            // If page is present in the cache, move the page to the start of list
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        } else {
            // If the page is not present in the cache, add the page to the cache
            if (pageList.getCurrSize() == pageList.getSize()) {
                // If cache is full, we will remove the tail from the cache pageList
                // Remove it from map too
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }
}

class DoublyLinkedList {

    private final int size;
    private int currSize;
    private Node head;
    private Node tail;

    public DoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }

    public Node addPageToList(int pageNumber) {
        Node pageNode = new Node(pageNumber);
        if (head == null) {
            head = pageNode;
            tail = pageNode;
            currSize = 1;
            return pageNode;
        } else if (currSize < size) {
            currSize++;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
        return pageNode;
    }

    public void movePageToHead(Node pageNode) {
        if (pageNode == null || pageNode == head) {
            return;
        }

        if (pageNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        Node prev = pageNode.getPrev();
        Node next = pageNode.getNext();
        prev.setNext(next);

        if (next != null) {
            next.setPrev(prev);
        }

        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
    }

    public int getCurrSize() {
        return currSize;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }
}

class Node {

    private int pageNumber;
    private Node prev;
    private Node next;

    public Node(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int data) {
        this.pageNumber = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return pageNumber + "  ";
    }
}

