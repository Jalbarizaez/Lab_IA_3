package org.example.graph;
import java.util.*;

public class Node<T> {

    private T value;
    private Set<Node<T>> neighbors;
    private Node<T> father;
    public int n_fathers;

    public Node(T value){
        this.value = value;
        this.neighbors = new HashSet<>();
        n_fathers = 0;
    }

    public T getValue(){

        return this.value;
    }
    public Node<T> getFather(){
        return this.father;
    }
    public void setFather(Node<T> nodo){
        this.father = nodo;
    }

    public Set<Node<T>> getNeighbors()
    {
        return Collections.unmodifiableSet(neighbors);
    }

   
    public void connect(Node<T> node){
        if(this == node) throw new IllegalArgumentException("Un nodo intenta referenciarse a si mismo");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    public String toString(){
        return this.value.toString();
    }
}
