package hadt7;

/**
 * Clase que representa un nodo en un árbol binario.
 * 
 * @param <K> el tipo de las claves en el nodo, que deben ser comparables
 * @param <V> el tipo de los valores almacenados en el nodo
 */
public class BinaryTreeNode<K extends Comparable<K>, V> {
    private K key; // Clave del nodo
    private V value; // Valor asociado al nodo
    private BinaryTreeNode<K, V> leftChild; // Hijo izquierdo del nodo
    private BinaryTreeNode<K, V> rightChild; // Hijo derecho del nodo
    private BinaryTreeNode<K, V> parent; // Nodo padre
    private boolean isRightChild; // Indica si el nodo es un hijo derecho

    /**
     * Constructor de la clase BinaryTreeNode.
     * 
     * @param key          la clave del nodo
     * @param value        el valor asociado al nodo
     * @param parent       el nodo padre
     * @param isrightChild true si el nodo es un hijo derecho, false en caso contrario
     */
    public BinaryTreeNode(K key, V value, BinaryTreeNode<K, V> parent, boolean isrightChild) {
        setKey(key);
        setValue(value);
        setParent(parent);
        setLeftChild(null);
        setRightChild(null);
        setIsRightChild(isrightChild);
    }

    /**
     * Devuelve la clave del nodo.
     * 
     * @return la clave del nodo
     */
    public K getKey() {
        return key;
    }

    /**
     * Establece la clave del nodo.
     * 
     * @param key la clave a establecer
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Devuelve el valor asociado al nodo.
     * 
     * @return el valor del nodo
     */
    public V getValue() {
        return value;
    }

    /**
     * Establece el valor asociado al nodo.
     * 
     * @param value el valor a establecer
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Devuelve el hijo izquierdo del nodo.
     * 
     * @return el hijo izquierdo del nodo
     */
    public BinaryTreeNode<K, V> getLeftChild() {
        return leftChild;
    }

    /**
     * Establece el hijo izquierdo del nodo.
     * 
     * @param leftChild el nodo a establecer como hijo izquierdo
     */
    public void setLeftChild(BinaryTreeNode<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Devuelve el hijo derecho del nodo.
     * 
     * @return el hijo derecho del nodo
     */
    public BinaryTreeNode<K, V> getRightChild() {
        return rightChild;
    }

    /**
     * Establece el hijo derecho del nodo.
     * 
     * @param rightChild el nodo a establecer como hijo derecho
     */
    public void setRightChild(BinaryTreeNode<K, V> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Devuelve el nodo padre.
     * 
     * @return el nodo padre
     */
    public BinaryTreeNode<K, V> getParent() {
        return parent;
    }

    /**
     * Establece el nodo padre.
     * 
     * @param parent el nodo a establecer como padre
     */
    public void setParent(BinaryTreeNode<K, V> parent) {
        this.parent = parent;
    }

    /**
     * Indica si el nodo es un hijo derecho.
     * 
     * @return true si el nodo es un hijo derecho, false en caso contrario
     */
    public boolean isRightChild() {
        return isRightChild;
    }

    /**
     * Establece si el nodo es un hijo derecho.
     * 
     * @param isRightChild true si el nodo es un hijo derecho, false en caso contrario
     */
    public void setIsRightChild(boolean isRightChild) {
        this.isRightChild = isRightChild;
    }
}