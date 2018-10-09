package testers;

import classes.ArrayQueue;
import classes.SLLQueue;
import interfaces.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue1 = new ArrayQueue(); //comment this line if you want to use SLLQueue
		Queue<Integer> queue2 = new SLLQueue();  
		
		showArrayQueueTester(queue1);
		//showSSLQueueTester(queue2); delete this to run the SSLQueueTester
	}
	
	
	private static void showArrayQueueTester(Queue<Integer> queue) {
		System.out.println("The size of the queue is " + queue.size());
		System.out.println("Is the queue empty? " + queue.isEmpty());
		System.out.println("Adding the first ten positive integers to the queue implemented"
				+ " by a circular array: ");
		for(int i = 1; i <= 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);
		}
		System.out.println("The first element of the queue is " + queue.first());
		System.out.println("The size of the queue is " + queue.size());
		System.out.println("Is the queue empty? " + queue.isEmpty());
		System.out.println("Removing elements from the queue: ");
		while(!queue.isEmpty()) {
			queue.dequeue();
			System.out.println(queue);
		}
		
		System.out.println("Mixing enqueues and dequeues: ");
		
		System.out.println("Adding the first 5 positive integers to the queue implemented"
				+ " by a circular array; dequeuing two elements and then adding the"
				+ "consecutive integer until the queue gets empty: ");
		
		for(int i = 1; i <= 5; i++) {
			queue.enqueue(i);
			System.out.println(queue);
		}
		
		
		int nextInteger = 6;
		
		while(!queue.isEmpty()) {
			queue.dequeue();
			queue.dequeue();
			System.out.println("After dequeueing two times: \n" + queue);
			if(!(queue.size() ==  0)) {
				queue.enqueue(nextInteger);
				System.out.println("After queueing one time: \n" + queue);
			}
			nextInteger++;
		}
	}
	
	private static void showSSLQueueTester(Queue<Integer> queue) {
		System.out.println("The size of the queue is " + queue.size());
		System.out.println("Is the queue empty? " + queue.isEmpty());
		System.out.println("Adding the first ten positive integers to the queue implemented"
				+ " by a circular array: ");
		for(int i = 1; i <= 10; i++) {
			queue.enqueue(i);
			showSLL((SLLQueue<Integer>) queue);
			System.out.println();
		}
		System.out.println("The first element of the queue is " + queue.first());
		System.out.println("The size of the queue is " + queue.size());
		System.out.println("Is the queue empty? " + queue.isEmpty());
		System.out.println("Removing elements from the queue: ");
		while(!queue.isEmpty()) {
			queue.dequeue();
			showSLL((SLLQueue<Integer>) queue);
			System.out.println();
		}
		
		System.out.println("Mixing enqueues and dequeues: ");
		
		System.out.println("Adding the first 5 positive integers to the queue implemented"
				+ " by a circular array; dequeuing two elements and then adding the"
				+ "consecutive integer until the queue gets empty: ");
		
		for(int i = 1; i <= 5; i++) {
			queue.enqueue(i);
			showSLL((SLLQueue<Integer>) queue);
			System.out.println();
		}
		
		
		int nextInteger = 6;
		
		while(!queue.isEmpty()) {
			queue.dequeue();
			queue.dequeue();
			System.out.println("After dequeueing two times: ");
			showSLL((SLLQueue<Integer>) queue);
			System.out.println();
			if(!(queue.size() ==  0)) {
				queue.enqueue(nextInteger);
				System.out.println("After queueing one time: ");
				showSLL((SLLQueue<Integer>) queue);
				System.out.println();
			}
			nextInteger++;
		}
	}
	
	
	private static void showSLL(SLLQueue<Integer> queue) {
		for (Integer integer: queue) {
		    System.out.print(integer + " ");
		}
		

	}

}
