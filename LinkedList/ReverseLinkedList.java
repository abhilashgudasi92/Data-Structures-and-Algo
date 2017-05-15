package LinkedList;
public class ReverseLinkedList {
	// Java program for reversing the linked list
	 
	    Node head;
	    
	    static class Node{
	    	int data;
	    	Node next;
	    	
	    	Node(int d){
	    		this.data = d;
	    		this.next = null;
	    	}
	    }
	 
	    /* Function to reverse the linked list */
	    Node reverse(Node node) {
	    	Node prev = null,next = null;
	    	Node current = node;
	    	while(current != null){
	    		next = current.next;
	    		current.next = prev;
	    		prev = current;
	    		current = next;
	    	}
	    	
	        node = prev;
	        return prev;
	    }
	 
	    // prints content of double linked list
	    void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	 
	    public static void main(String[] args) {
	    	ReverseLinkedList list = new ReverseLinkedList();
	        list.head = new Node(85);
	        list.head.next = new Node(15);
	        list.head.next.next = new Node(4);
	        list.head.next.next.next = new Node(20);
	         
	        System.out.println("Given Linked list");
	        list.printList(list.head);
	        list.head = list.reverse(list.head);
	        System.out.println("");
	        System.out.println("Reversed linked list ");
	        list.printList(list.head);
	    }
}
