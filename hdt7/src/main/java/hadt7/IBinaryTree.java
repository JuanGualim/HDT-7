package hadt7;

/**
 * Interfaz que define las operaciones básicas para un árbol binario.
 * 
 * @param <K> el tipo de las claves en el árbol, que deben ser comparables
 * @param <V> el tipo de los valores almacenados en el árbol
 */
public interface IBinaryTree<K extends Comparable<K>, V> {

    /**
     * Devuelve el número de nodos en el árbol.
     * 
     * @return el número de nodos en el árbol
     */
    int count();

    /**
     * Verifica si el árbol está vacío.
     * 
     * @return true si el árbol está vacío, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Inserta un nuevo nodo en el árbol con la clave y el valor especificados.
     * 
     * @param key   la clave del nodo a insertar
     * @param value el valor asociado al nodo
     */
    void insert(K key, V value);

    /**
     * Busca un nodo en el árbol con la clave especificada.
     * 
     * @param keyToFind la clave del nodo a buscar
     * @return el valor asociado al nodo si se encuentra, null en caso contrario
     */
    V search(K keyToFind);

    /**
     * Elimina un nodo del árbol con la clave especificada.
     * 
     * @param keyToRemove la clave del nodo a eliminar
     * @return el valor asociado al nodo eliminado, o null si no se encuentra
     */
    V remove(K keyToRemove);

    /**
     * Realiza un recorrido InOrder del árbol y aplica el método de recorrido
     * especificado.
     * 
     * @param traversalMethod el método de recorrido a aplicar
     */
    void InOrder(Itraversal<K, V> traversalMethod);

    /**
     * Realiza un recorrido Reverse InOrder del árbol y aplica el método de recorrido
     * especificado.
     * 
     * @param traversalMethod el método de recorrido a aplicar
     */
    void ReverseInOrder(Itraversal<K, V> traversalMethod);
}