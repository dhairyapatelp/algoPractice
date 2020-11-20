import java.util.*;

class LRUCache{
	Map<Integer, Node> map;
	int cap;
	Node head;
	Node tail;

	private class Node{
		int val;
		int key;
		Node next;
		Node prev;
	}
	public static void main(String[] args){
		LRUCache obj = new LRUCache(2);
		obj.put(1,1);
		obj.put(2,2);
		obj.get(1);
		obj.put(3,3);
		obj.get(2);
		obj.put(4,4);
		obj.get(1);
		obj.get(3);
		obj.get(4);
	}

	public LRUCache(int capacity) {
    	cap = capacity;
    	map = new HashMap<>();

    	head = new Node();
    	tail = new Node();
    	head.next = tail;
    	tail.prev = head;
    }
    
    public int get(int key) {
    	Node node = map.get(key);
    	int result = -1;
    	if(node != null){
    		result = node.val;
    		removeNode(node);
    		addNode(node);
    	}

    	return result;
    }
    
    public void put(int key, int value) {
    	Node node = map.get(key);
    	if(node != null){
    		node.val = value;
    		removeNode(node);
    		addNode(node);
    	}
    	else{
    		if(map.size() == cap){
    			removeNode(tail.prev);
    			map.remove(tail.prev.key);
    		}
    		Node newNode = new Node();
    		newNode.key = key;
    		newNode.val = value;
    		map.put(key, newNode);
    		addNode(newNode);
    	}

    }

    public void removeNode(Node node){
    	Node node_next = node.next;
    	Node node_prev = node.prev;

    	node_next.prev = node.prev;
    	node.prev.next = node.next;	
    }

    public void addNode(Node node){
		Node headNext = head.next;
		node.next = headNext;
		node.prev = head;
		head.next = node;
		headNext.prev = node;
    }
}