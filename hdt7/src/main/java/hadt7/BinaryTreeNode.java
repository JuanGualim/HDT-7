package hadt7;

public class BinaryTreeNode <K extends Comparable<K>, V>{
    private K key;
    private V value;
    private BinaryTreeNode<K, V> leftChild;
    private BinaryTreeNode<K, V> rightChild;
    private BinaryTreeNode<K, V> parent;
    private boolean isRightChild;
    
    public BinaryTreeNode(K key, V value, BinaryTreeNode<K, V> parent, boolean isrightChild) {
        setKey(key);
        setValue(value);
        setParent(parent);
        setLeftChild(null);
        setRightChild(null);
        setIsRightChild(isrightChild);
    }
    
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
    
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    public BinaryTreeNode<K, V> getLeftChild() {
        return leftChild;
    }
    
    public BinaryTreeNode<K, V> getRightChild() {
        return rightChild;
    }
    
    public void setLeftChild(BinaryTreeNode<K, V> leftChild) {
        this.leftChild = leftChild;
    }
    
    public void setRightChild(BinaryTreeNode<K, V> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<K, V> getParent() {
        return parent;
    }
    public void setParent(BinaryTreeNode<K, V> parent) {
        this.parent = parent;
    }

    public boolean isRightChild() {
        return isRightChild;
    }

    public void setIsRightChild(boolean isRightChild) {
        this.isRightChild = isRightChild;
    }
}
