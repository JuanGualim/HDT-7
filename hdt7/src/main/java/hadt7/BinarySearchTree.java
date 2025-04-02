package hadt7; 

/**
 * Clase BinarySearchTree que implementa la interfaz {@link IBinaryTree}.
 * 
 * @param <K> el tipo de claves en el árbol, que debe ser comparable
 * @param <V> el tipo de valores en el árbol
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements IBinaryTree<K, V> {
    private BinaryTreeNode<K, V> root; // Nodo raíz del árbol
    private int count; // Número de nodos en el árbol

    /**
     * Constructor de la clase BinarySearchTree.
     * Inicializa el árbol vacío.
     */
    public BinarySearchTree() {
        count = 0;
        root = null;
    }

    /**
     * Devuelve el número de nodos en el árbol.
     * 
     * @return el número de nodos en el árbol
     */
    @Override
    public int count() {
        return count;
    }

    /**
     * Verifica si el árbol está vacío.
     * 
     * @return true si el árbol está vacío, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Inserta un nuevo nodo en el árbol con la clave y el valor especificados.
     * 
     * @param key   la clave del nodo a insertar
     * @param value el valor asociado al nodo
     */
    @Override
    public void insert(K key, V value) {
        BinaryTreeNode<K, V> newNode = new BinaryTreeNode<>(key, value, null, false);

        if (isEmpty()) {
            root = newNode;
            count++;
        } else {
            internalInsert(root, newNode);
        }
    }

    /**
     * Método interno para insertar un nodo en el árbol.
     * 
     * @param parent  el nodo actual en el que se está evaluando la inserción
     * @param newNode el nuevo nodo a insertar
     */
    private void internalInsert(BinaryTreeNode<K, V> parent, BinaryTreeNode<K, V> newNode) {
        int result = parent.getKey().compareTo(newNode.getKey());
        if (result > 0) {
            if (parent.getLeftChild() == null) {
                newNode.setIsRightChild(false);
                newNode.setParent(parent);
                parent.setLeftChild(newNode);
                count++;
            } else {
                internalInsert(parent.getLeftChild(), newNode);
            }
        } else if (result < 0) {
            if (parent.getRightChild() == null) {
                newNode.setIsRightChild(true);
                newNode.setParent(parent);
                parent.setRightChild(newNode);
                count++;
            } else {
                internalInsert(parent.getRightChild(), newNode);
            }
        } else {
            // Si la clave ya existe, no se realiza ninguna acción
            return;
        }
    }

    /**
     * Busca un nodo en el árbol con la clave especificada.
     * 
     * @param keyToFind la clave del nodo a buscar
     * @return el valor asociado al nodo si se encuentra, null en caso contrario
     */
    @Override
    public V search(K keyToFind) {
        if (isEmpty()) {
            return null;
        } else {
            return internalSearch(root, keyToFind);
        }
    }

    /**
     * Método interno para buscar un nodo en el árbol.
     * 
     * @param parent    el nodo actual en el que se está evaluando la búsqueda
     * @param keyToFind la clave del nodo a buscar
     * @return el valor asociado al nodo si se encuentra, null en caso contrario
     */
    private V internalSearch(BinaryTreeNode<K, V> parent, K keyToFind) {
        if (parent != null) {
            int result = parent.getKey().compareTo(keyToFind);
            if (result > 0) {
                return internalSearch(parent.getLeftChild(), keyToFind);
            } else if (result < 0) {
                return internalSearch(parent.getRightChild(), keyToFind);
            } else {
                return parent.getValue();
            }
        } else {
            return null;
        }
    }

    /**
     * Elimina un nodo del árbol con la clave especificada.
     * 
     * @param key la clave del nodo a eliminar
     * @return el valor asociado al nodo eliminado
     * @throws UnsupportedOperationException si la operación no está implementada
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Realiza un recorrido InOrder del árbol y aplica el método de recorrido
     * especificado.
     * 
     * @param traversalMethod el método de recorrido a aplicar
     */
    @Override
    public void InOrder(Itraversal<K, V> traversalMethod) {
        if (isEmpty()) {
            return;
        } else {
            internalInOrder(traversalMethod, root);
        }
    }

    /**
     * Método interno para realizar un recorrido InOrder del árbol.
     * 
     * @param traversalMethod el método de recorrido a aplicar
     * @param actualNode      el nodo actual en el recorrido
     */
    private void internalInOrder(Itraversal<K, V> traversalMethod, BinaryTreeNode<K, V> actualNode) {
        if (actualNode.getLeftChild() != null) {
            internalInOrder(traversalMethod, actualNode.getLeftChild());
        }
        traversalMethod.visitar(actualNode);

        if (actualNode.getRightChild() != null) {
            internalInOrder(traversalMethod, actualNode.getRightChild());
        }
    }

    /**
     * Realiza un recorrido Reverse InOrder del árbol y aplica el método de recorrido
     * especificado.
     * 
     * @param traversalMethod el método de recorrido a aplicar
     */
    @Override
    public void ReverseInOrder(Itraversal<K, V> traversalMethod) {
        if (isEmpty()) {
            return;
        } else {
            internalReverseInOrder(traversalMethod, root);
        }
    }

    /**
     * Método interno para realizar un recorrido Reverse InOrder del árbol.
     * 
     * @param traversalMethod el método de recorrido a aplicar
     * @param actualNode      el nodo actual en el recorrido
     */
    private void internalReverseInOrder(Itraversal<K, V> traversalMethod, BinaryTreeNode<K, V> actualNode) {
        if (actualNode.getRightChild() != null) {
            internalReverseInOrder(traversalMethod, actualNode.getRightChild());
        }
        traversalMethod.visitar(actualNode);

        if (actualNode.getLeftChild() != null) {
            internalReverseInOrder(traversalMethod, actualNode.getLeftChild());
        }
    }
}