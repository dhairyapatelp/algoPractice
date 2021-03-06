package DisjointSetDataStructure;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetDataStructure {
    Map<Long, Node> map = new HashMap<>();

    class Node{
        long data;
        Node parent;
        int rank;
    }

    public static void main(String[] args){
        DisjointSetDataStructure ds = new DisjointSetDataStructure();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
    public Node makeSet(long data){
        Node node =  new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
        return node;
    }
    public Node findSet(Node node){
        if(node.parent == node) return node;
        Node newParent = findSet(node.parent);
        node.parent = newParent;

        return newParent;
    }

    public Long findSet(long data){
        Node node = findSet(map.get(data));
        return node.data;
    }
    public boolean union(long node1, long node2){
        Node p1 = findSet(map.get(node1));
        Node p2 = findSet(map.get(node2));

        if(p1.data == p2.data) return false;

        if(p1.rank>=p2.rank){
            p1.rank = (p1.rank == p2.rank)? p1.rank+1: p1.rank;
            p2.parent = p1;
        }
        else{
            p1.parent = p2;
        }
        return true;
    }
}
