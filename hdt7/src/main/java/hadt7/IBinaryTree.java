package hadt7;

public interface IBinaryTree<K extends Comparable<K>, V> {
   int count ();
   boolean isEmpty ();
   void insert (K key, V value);
    V search (K keyToFind);
    V remove (K keyToRemove);
    void InOrder (Itraversal<K, V> traversalMethod);
    void ReverseInOrder (Itraversal<K, V> traversalMethod);
}
