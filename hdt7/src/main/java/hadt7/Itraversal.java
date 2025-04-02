package hadt7;

/**
 * Interfaz que define el método de recorrido para un árbol binario.
 * 
 * @param <K> el tipo de las claves en el árbol, que deben ser comparables
 * @param <V> el tipo de los valores almacenados en el árbol
 */
public interface Itraversal<K extends Comparable<K>, V> {

    /**
     * Método que se ejecuta al visitar un nodo durante un recorrido del árbol.
     * 
     * @param actualNode el nodo actual que se está visitando
     */
    void visitar(BinaryTreeNode<K, V> actualNode);
}