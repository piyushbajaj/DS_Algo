package LLD.UditTutorial.LRU_Cache.policies;

import java.util.HashMap;
import java.util.Map;

import LLD.UditTutorial.LRU_Cache.algorithms.DoublyLinkedList;
import LLD.UditTutorial.LRU_Cache.algorithms.DoublyLinkedListNode;

/**
 * Project: DS_Algo
 * Package: LLD.UditTutorial.LRU_Cache.policies
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 2:16 pm
 * <p>
 * Eviction policy based on LRU algorithm.
 *
 * @param <Key> : Key type.
 */
public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if (first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }
}