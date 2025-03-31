package hadt7;

import java.util.ArrayList;

public class ListarElementos<K extends Comparable<K>, V> implements Itraversal<K, V> {
    public ArrayList<V> elementos = new ArrayList<>();

    @Override 
    public void visitar(BinaryTreeNode<K, V> actualNode) {
        elementos.add(actualNode.getValue());
    }

    public ArrayList<V> getElementos() {
        return elementos;
    }
}
