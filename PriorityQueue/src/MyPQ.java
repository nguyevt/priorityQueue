// Vincent Nguyen, CSE 373, WIN2014
// Assignment #3, 02/07/14
//
// This program's behavior is to provide a priority queue
// implementation using a linkedlist. It implements the 
// PriorityQueue interface and contains the common behaviors 
// of a priority queue such as: isEmpty(), size(), findMin(), 
// insert(), makeEmpty(), and deleteMin().

public class MyPQ implements PriorityQueue {
	
	private MyPQNode front;
	private int size;
	
	// Constructs a new MyPQ
	public MyPQ() {
		this.front = null;
		this.size = 0;
	}
	
	// Returns true if MyPQ is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns the number of elements stored in the MyPQ
	public int size() {
		return this.size;
	}
	
	// Throws EmptyPQException if empty, otherwise returns the 
	// value with the highest priority stored in the MyPQ.
	public double findMin() {
		if (isEmpty()) {
			throw new EmptyPQException();
		}
		return front.value;
	}
	
	// Caller provides a double value, which is added to the priority
	// queue
	public void insert(double x) {
		if (isEmpty()) {
			front = new MyPQNode(x, front);
		} else {
			MyPQNode current = front;
			if (front.value >= x) {
				front = new MyPQNode(x, front);
			} else {
				while (current.next != null && current.next.value <= x) {
					current = current.next;
				}
				current.next = new MyPQNode(x, current.next);
			}
		}
		size++;
	}
	
	// Throws EmptyPQException if MyPQ is empty, otherwise removes and returns
	// the value with the highest priority stored in the MyPQ.
	public double deleteMin() {
		if (isEmpty()) {
			throw new EmptyPQException();
		}
		double temp = front.value;
		front = front.next;
		size--;
		return temp;
	}
	
	// Removes all values from the MyPQ
	public void makeEmpty() {
		front = null;
		size = 0;
	}

}
