package classes;

import java.util.Iterator;

import interfaces.Queue;

/** 
A partial implementation of the Queue using a singly linked list with references 
to the first and to the last node.
 **/

public class SLLQueue<E> implements Queue<E>, Iterable<E> {

	// inner class for nodes in singly linked lists
	private static class Node<E> {   
		private E element; 
		private Node<E> next; 
		public Node() { this(null,null); }
		public Node(E data) {this(data, null);}
		public Node(E data, Node<E> next) { this.element = data; this.next = next; }
		public E getElement() { return element;	}
		public void setElement(E data) { this.element = data; }
		public Node<E> getNext() { return next;}
		public void setNext(Node<E> next) { this.next = next; }
		public void clean() { element = null; next = null; }
	}    

	private Node<E> first, last;   // references to first and last node
	private int size; 

	public SLLQueue() {           // initializes instance as empty queue
		first = last = null; 
		size = 0; 
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) 
			return null;
		return first.getElement(); 
	}
	public E dequeue() {
		if (isEmpty()) 
			return null;        
		Node<E> nodeWithETR = first;
		E eTR = nodeWithETR.getElement();
		first = first.getNext();  
		nodeWithETR.clean();        
		size --;
		return eTR;
	}

	public void enqueue(E e) {
		if (size == 0) 
			first = last = new Node<>(e);  
		last.setNext(new Node<>(e));
		last = last.getNext();
		size++; 
	}
	
	public Iterator<E> iterator() {
		return new SortedListIterator();
	}

	private class SortedListIterator implements Iterator<E> {
		Node<E> current = first;

		public boolean hasNext() { 
			return current.getNext() != null; 
		}

		public E next() {
			if (!hasNext())
				return null;
			current = current.getNext();
			return current.getElement();
		}


		public void remove() {
			throw new UnsupportedOperationException("Removal logic not implemented."); }
	}
	


}
