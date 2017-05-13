package LinkedList;

public class RearrangeEvenOddPosiition {
	Node head;  // head of list
	 
    /* Linked list Node*/
    class Node
    {
        int x;
        Node next;
        Node(int x)
        {
            this.x = x;
            next = null;
        }
    }
 
    Node rearrangeEvenOdd(Node head){
    	
    	if(head == null)
    		return null;
    	
    	Node odd = head;
    	Node even = head.next;
    	Node evenfirst = head.next;
    	
    	while(true){
    		if(odd == null || even == null || even.next == null){
    			odd.next = evenfirst;			//Linking odd and even
    			break;
    		}
    		
    		odd.next = even.next;
    		odd = even.next;
    		
    		if(odd.next == null){
    			even.next = null;
    			odd.next = evenfirst;			//Linking odd and even
    			break;
    		}
    		
    		even.next = odd.next;
    		even = odd.next;
    	}
    	return head;
    }
 
    /*  Given a reference (pointer to pointer) to the head
        of a list and an int, push a new node on the front
        of the list. */
    void push(int x)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(x);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
 
    void printList(Node h)
    {
        Node temp = h;
        while (temp != null)
        {
            System.out.print(temp.x + "->");
            temp = temp.next;
        }
        System.out.println();
    }
 
 
    /* Drier program to test above functions */
    public static void main(String args[])
    {
    	RearrangeEvenOddPosiition llist = new RearrangeEvenOddPosiition();
 
        llist.push(40);
        llist.push(20);
        llist.push(10);
        llist.push(5);
        llist.push(100);
        llist.push(3);
        llist.push(1);
 
        System.out.println("Given list");
        llist.printList(llist.head);
 
        Node h = llist.rearrangeEvenOdd(llist.head);
        System.out.println("Modified Linked List is");
        llist.printList(h);
    }
}
