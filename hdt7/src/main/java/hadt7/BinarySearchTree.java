package hadt7;

public class BinarySearchTree<K extends Comparable<K>, V> implements IBinaryTree<K, V> {
    private BinaryTreeNode<K, V> root;
    private int count;

    public BinarySearchTree() {
        count = 0;
        root = null;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void insert(K key, V value) {
        BinaryTreeNode<K, V> newNode = new BinaryTreeNode<>(key, value, null, false);

        if (isEmpty()){
            root = newNode;
            count++;
        } else {
            internalInsert(root, newNode);
        }
    }

    private void internalInsert(BinaryTreeNode<K, V> parent, BinaryTreeNode<K, V> newNode){

        int result = parent.getKey().compareTo(newNode.getKey());
        if (result > 0){
            if(parent.getLeftChild() == null){
                newNode.setIsRightChild(false);
                newNode.setParent(parent);
                parent.setLeftChild(newNode);
                count++;
            } else{
                internalInsert(parent.getLeftChild(), newNode);
            }
        } else if(result < 0){
            if (parent.getRightChild() == null){
                newNode.setIsRightChild(true);
                newNode.setParent(parent);
                parent.setRightChild(newNode);
                count++;
            } else{
                internalInsert(parent.getRightChild(), newNode);
            }
        } else{
            return;
        }
    }

    @Override
    public V search(K keyToFind) {
        if (isEmpty()){
            return null;
        } else {
            return internalSearch(root, keyToFind);
        }
    }

    private V internalSearch(BinaryTreeNode<K, V> parent, K keyToFind){
        if (parent != null){
            int result = parent.getKey().compareTo(keyToFind);
            if (result > 0){
                return internalSearch(parent.getLeftChild(), keyToFind);
            } else if (result < 0){
                return internalSearch(parent.getRightChild(), keyToFind);
            } else {
                return parent.getValue();
            }
        } else {
            return null;
        }
    }

    @Override
    public V remove(K key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Inorder(Itraversal<K, V> traversalMethod) {
        if (isEmpty()){
            return;
        }else {
            internalInOrder(traversalMethod, root);
        }
    }

    private void internalInOrder(Itraversal<K, V> traversalMethod, BinaryTreeNode<K, V> actualNode){
        if(actualNode.getLeftChild() != null){
            internalInOrder(traversalMethod, actualNode.getLeftChild());
        }
        traversalMethod.visitar(actualNode);

        if(actualNode.getRightChild() != null){
            internalInOrder(traversalMethod, actualNode.getRightChild());
        }
    }

    @Override
    public void Postorder(Itraversal<K, V> traversalMethod) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Preorder(Itraversal<K, V> traversalMethod) {
        // TODO Auto-generated method stub
        
    }
}
