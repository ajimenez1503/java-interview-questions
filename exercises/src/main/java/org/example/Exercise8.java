package org.example;

// A class to store a binary tree node
class Node {
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

public class Exercise8 {
    static public int findMaxSumPath(Node node) {
        if (node.left == null && node.right == null) {
            return node.data;
        } else if (node.left != null && node.right != null) {
            return node.data + Math.max(findMaxSumPath(node.left), findMaxSumPath(node.right));
        } else if (node.left != null) {
            return node.data + findMaxSumPath(node.left);
        } else {//if (node.right != null) {
            return node.data + findMaxSumPath(node.right);
        }
    }
}
