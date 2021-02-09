package org.example.graph;

import java.util.*;

public class BFS {

    private static String recorrido = "";
    public static <T> void Imprimir_recorrido(Node<T> Meta){
        Impression(Meta);
    }
    private static <T> void Impression(Node<T> nodo){
        if(nodo.getFather() == null){
            recorrido = "Inicio " + nodo.toString() + recorrido;
        }
        else {
            recorrido = "-" + nodo.toString() + recorrido;
            Impression(nodo.getFather());
        }
    }

    public static<T> Optional<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> queque = new ArrayDeque<>();
        queque.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

            while (!queque.isEmpty()){//1- Verificar si puedo continuar
                currentNode = queque.remove();
               //System.out.println("Visitando el nodo " + currentNode.getValue());

                //2-Se verifica si esta en la meta
                if(currentNode.getValue().equals(value))
                {
                    Imprimir_recorrido(currentNode);
                    System.out.println(recorrido+" Fin");
                    return Optional.of(currentNode);
                }
                else {
                    closed.add(currentNode);//3-Espacio explorado
                    queque.addAll(currentNode.getNeighbors());//4-Sucesora
                    queque.removeAll(closed);
                    for (var item:queque) {
                        //Para cada item en la frontera
                        if(currentNode.getNeighbors().contains(item)) {//Verifico si es el nodo actaul es vecino de item
                            item.setFather(currentNode);
                            //System.out.println("hijo: " + item + " padre: " + currentNode);
                        }
                    }
                }
            }
            return  Optional.empty();

    }
}
