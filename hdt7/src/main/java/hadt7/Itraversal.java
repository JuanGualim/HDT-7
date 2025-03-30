package hadt7;

public interface Itraversal<K extends Comparable<K>, V> {
    void visitar(BinaryTreeNode<K, V> actualNode);
    
}
