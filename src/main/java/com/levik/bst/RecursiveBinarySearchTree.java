package com.levik.bst;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

    private static class Node<T> {
        final T element;
        Node<T> left;
        Node<T> right;

        private Node(T element) {
            this.element = element;
        }
    }

    private Node<T> root;
    private int size;

    public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
        RecursiveBinarySearchTree<T> tRecursiveBinarySearchTree = new RecursiveBinarySearchTree<>();

        Stream.of(elements).forEach(tRecursiveBinarySearchTree::insert);
        return tRecursiveBinarySearchTree;
    }

    @Override
    public boolean insert(T element) {
        if (Objects.isNull(root)) {
            root = new Node<>(element);
            size++;
            return true;
        }

        return insert(root, element);
    }

    private boolean insert(Node<T> current, T element) {
        if (element.compareTo(current.element) < 0) {
            if (Objects.isNull(current.left)) {
                current.left = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.left, element);
            }
        } else if (element.compareTo(current.element) > 0) {
            if (Objects.isNull(current.right)) {
                current.right = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.right, element);
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(T element) {
        if (Objects.isNull(root)) {
            return false;
        }

        return contains(root, element);
    }

    private boolean contains(Node<T> current, T element) {
        if (element.compareTo(current.element) < 0) {
            if (Objects.isNull(current.left)) {
                return false;
            } else {
                return contains(current.left, element);
            }
        } else if (element.compareTo(current.element) > 0) {
            if (Objects.isNull(current.right)) {
                return false;
            } else {
                return contains(current.right, element);
            }
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        return root!= null ? depth(root) - 1 : 0;
    }

    private int depth(Node<T> current) {
        if (Objects.isNull(current)) {
            return 0;
        }

        return 1 + Math.max(depth(current.left), depth(current.right));
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(Node<T> current, Consumer<T> consumer) {
        if (Objects.nonNull(current)) {
            inOrderTraversal(current.left, consumer);
            consumer.accept(current.element);
            inOrderTraversal(current.right, consumer);
        }
    }
}

