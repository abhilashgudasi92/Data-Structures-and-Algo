package Leetcode;

import org.w3c.dom.ls.LSInput;

public class addTwoNumList {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int item){
			data = item;
			next = null;
		}
	}
	
	void push(int data){
		Node a = new Node(data);
		a.next = head;
		head = a;
	}
	
	void printList(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
	
		addTwoNumList list1 = new addTwoNumList();
		addTwoNumList list2 = new addTwoNumList();
		
		list1.push(1);
		list1.push(4);
		list1.push(6);
		
		list2.push(2);
		list2.push(6);
		list2.push(7);
		System.out.println("List1: ");
		list1.printList(list1.head);
		System.out.println("List2: ");
		list2.printList(list2.head);
		
		Node res = list1.addTwoList(list1.head,list2.head);
		System.out.println("Result: ");
		list1.printList(res);
	}

	public Node addTwoList(Node head1, Node head2) {
		int sum = 0;
		Node l1 = head1;
		Node l2 = head2;
		Node senti = new Node(0);
		Node d = senti;
		
		while(l1 != null || l2 != null){
			sum /= 10;
			if(l1 != null){
				sum += l1.data;
				l1 = l1.next;
			}
			
			if(l2 != null){
				sum += l2.data;
				l2 = l2.next;
			}
			d.next = new Node(sum%10);
			d = d.next;
		}
		if(sum / 10 == 1)
			d.next = new Node(1);
		
		return senti.next;
	}
}
