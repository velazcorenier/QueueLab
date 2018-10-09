package classes;

import java.util.Arrays;

import interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
	
	private final static int INITCAP = 4; 
	private E[] elements; 
	private int first, size; 
	public ArrayQueue() { 
		elements = (E[]) new Object[INITCAP]; 
		first = 0; 
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
		return elements[first]; 
	}

	public E dequeue() {
		if (isEmpty()) 
			return null;
		E etr = elements[first]; 
		/* ... adjust whatever needs to be adjusted ...
		 * Check if number of available positions in the array exceed 3/4
		 * of its total length. If so, and if the current capacity is not
		 * less than 2*INITCAP, shrink the internal array to 1/2 of its
		 * current length (the capacity of the queue). 
		 */
		if (elements.length >= 2*INITCAP && size < elements.length/4)
			changeCapacity(elements.length/2); 
		elements[first] = null;
		first = (first + 1) % elements.length;
		size--;
		return etr; 
	}

	public void enqueue(E e) {
		if (size == elements.length)   // check capacity, double it if needed
			changeCapacity(2*size); 
		int avail = (first + size) % elements.length;
		elements[avail] = e;
		size++;
		}

	private void changeCapacity(int newCapacity) { 
		// PRE: newCapacity >= size
		//... finish the implementation of this method ..
		E[] newArray = (E[]) new Object[newCapacity];
		for(int i = 0; i <= size() - 1 ; i++) {
			int avail = (first + i) % elements.length;
			newArray[i] = elements[avail];
			elements[avail] = null;
		}
		first = 0;
		elements = newArray;
	}
	
	public String toString() {
		return "The elements in the queue are: " + Arrays.toString(this.elements);
	}
}
