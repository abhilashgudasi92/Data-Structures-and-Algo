package LinkedList;
import java.lang.Math;
import LinkedList.FlattenList.Node;

public class AddTwoNumList {
	static Node head1, head2;
	 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Adds contents of two linked lists and return the head node of resultant list */
    Node addTwoLists(Node first, Node second) {
        Node res = null; // res is head node of the resultant list
        Node temp = null;
        int carry = 0;
        
        if(first == null){
        	return second;
        }
        
        else if(second == null){
        	return first;
        }
        
        int size1 = getsize(head1);
        int size2 = getsize(head2);
        
        if(size1 == size2){
        	res = addSameSize(first,second,carry);
        }
        
        else{
        	int diff = Math.abs(size1 - size2);
        	
        	if (size1 < size2)
                swapPointer(first,second);
        	
        	temp = first;  
        	while(diff != 0){
        		temp = temp.next;
        		diff = diff - 1;
            }
        	res = addSameSize(temp,second,carry);
        	
        	// get addition of remaining first list and carry
            addCarryToRemaining(head1, temp, carry, res);
        }
        if (carry > 0)
            push(res, carry);
        return res;
    }
    
    Node addSameSize(Node head1, Node head2, int carry){
    	if(head1 == null)
    		return null;
    	Node result = null;
    	int sum;
    	
    	result.next = addSameSize(head1.next,head2.next,carry);
    	sum = head1.data + head2.data + carry;
    	
    	carry = sum/10;
    	sum = sum%10;
    	
    	result.data = sum;
    	
    	return result;
    }
    
    void addCarryToRemaining(Node head1, Node cur, int carry, Node result)
    {
        int sum;
     
        // If diff. number of nodes are not traversed, add carry
        if (head1 != cur)
        {
            addCarryToRemaining(head1.next, cur, carry, result);
     
            sum = head1.data + carry;
            carry = sum/10;
            sum %= 10;
     
            // add this node to the front of the result
            push(result, sum);
        }
    }
    
    Node push(Node head_ref, int data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head_ref;
 
        /* 4. Move the head to point to new Node */
        head_ref = new_node;
 
        /*5. return to link it back */
        return head_ref;
    }
    
    static int getsize(Node a){
    	int size =0;
    	while(a != null){
    		a = a.next;
    		size++;
    	}
    	return size;
    }
    
    void swapPointer(Node a,Node b){
    	Node temp = a;
    	a = b;
    	b= temp;
    }
    
    /* Utility function to print a linked list */
 
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
 
    public static void main(String[] args) {
    	AddTwoNumList list = new AddTwoNumList();
 
        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);
 
        // creating second list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);
 
        // add the two lists and see the result
        Node rs = list.addTwoLists(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }
}
