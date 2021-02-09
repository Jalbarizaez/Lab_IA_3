package org.example;

import org.example.graph.BFS;
import org.example.graph.BFSVersion2;
import org.example.graph.DFS;
import org.example.graph.Node;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var zona1 = new Node<Integer>(1);
        var zona2 = new Node<Integer>(2);
        var zona4 = new Node<Integer>(4);
        var zona5 = new Node<Integer>(5);
        var zona9 = new Node<Integer>(9);
        var zona10 = new Node<Integer>(10);
        var zona12 = new Node<Integer>(12);
        var zona13 = new Node<Integer>(13);
        var zona14 = new Node<Integer>(14);
        var zona15 = new Node<Integer>(15);
        var zona16 = new Node<Integer>(16);
        var zona21 = new Node<Integer>(21);

        zona21.connect(zona12);
        zona12.connect(zona13);
        zona13.connect(zona14);
        zona13.connect(zona9);
        zona14.connect(zona10);
        zona10.connect(zona9);
        zona10.connect(zona15);
        zona10.connect(zona16);
        zona9.connect(zona4);
        zona9.connect(zona1);
        zona4.connect(zona5);
        zona4.connect(zona1);
        zona1.connect(zona5);
        zona1.connect(zona2);

        System.out.println("BFS");
       BFS.search(1,zona21);
        System.out.println("BFS_GS");
        BFSVersion2.search(1,zona21);
        System.out.println("DFS");
       DFS.search(1,zona21);

    }
}
