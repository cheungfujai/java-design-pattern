package com.learningjava.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node <T> {
    public T value;
    public Node<T> left, right, parent;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    private void preOrderTraversal(Node<T> current, List<Node<T>> res){
        res.add(current);
        if(current.left != null) preOrderTraversal(current.left, res);
        if(current.right != null) preOrderTraversal(current.right, res);
    }

    public Iterator<Node<T>> preOrder() {
        List<Node<T>> res = new ArrayList<>();
        preOrderTraversal(this, res);
        return res.iterator();
    }
}
