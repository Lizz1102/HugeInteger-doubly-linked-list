package com.company;

public class Node {
    public int data;
    public Node prev, next;

    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}
