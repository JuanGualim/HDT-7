package hadt7;

public interface IBinaryTree<K extends Comparable<K>, V> {
   int count ();
   boolean isEmpty ();
   void insert (K key, V value);
    V search (K keyToFind);
    V remove (K keyToRemove);
    void InOrder (Itraversal<K, V> traversalMethod);
    void Preorder (Itraversal<K, V> traversalMethod);
    void Postorder (Itraversal<K, V> traversalMethod);
}
