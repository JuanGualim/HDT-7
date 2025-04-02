package hadt7;

import java.util.ArrayList;

/**
 * Clase que implementa la interfaz {@link Itraversal} para recorrer un árbol binario
 * y almacenar los valores de los nodos visitados en una lista.
 * 
 * @param <K> el tipo de las claves en el árbol, que deben ser comparables
 * @param <V> el tipo de los valores almacenados en el árbol
 */
public class ListarElementos<K extends Comparable<K>, V> implements Itraversal<K, V> {
    /**
     * Lista que almacena los valores de los nodos visitados durante el recorrido.
     */
    public ArrayList<V> elementos = new ArrayList<>();

    /**
     * Método que se ejecuta al visitar un nodo durante un recorrido del árbol.
     * Agrega el valor del nodo visitado a la lista {@code elementos}.
     * 
     * @param actualNode el nodo actual que se está visitando
     */
    @Override 
    public void visitar(BinaryTreeNode<K, V> actualNode) {
        elementos.add(actualNode.getValue());
    }

    /**
     * Devuelve la lista de valores de los nodos visitados.
     * 
     * @return una lista con los valores de los nodos visitados
     */
    public ArrayList<V> getElementos() {
        return elementos;
    }
}