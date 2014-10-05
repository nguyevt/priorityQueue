// Vincent Nguyen, CSE 373, WIN2014
// Assignment #3, 02/07/14
//
// This program's behavior is to provide a priority queue
// implementation using a tree with branching factor of 2.
// It implements the PriorityQueue interface and contains the 
// common behaviors of a priority queue such as: isEmpty(),
// size(), findMin(), insert(), makeEmpty(), and deleteMin().

public class BinaryHeap implements PriorityQueue {

	private double[] heapArray;
	private int size;
	
	// Constructs a new BinaryHeap
	public BinaryHeap() {
		this.heapArray = new double[10];
		this.size = 0;
	}
	
	// Returns true if BinaryHeap is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns the number of elements in the BinaryHeap
	public int size() {
		return this.size;
	}
	
	// Throws an EmptyPQException if empty, otherwise
	// returns the value with the highest priority in the 
	// priority queue.
	public double findMin() {
		if (isEmpty()) {
			throw new EmptyPQException();
		} else {
			return heapArray[1];
		}
	}
	
	// Client provides a double value which gets added to the 
	// priority queue.
	public void insert(double x) {
		if (size == heapArray.length - 1) {
			resize();
		}
		size++;
		int index = bubbleUp(x, size);
		heapArray[index] = x;
	}
	
	// Helper method called when a new value is inserted into the 
	// priority queue and rearranges the values in the priority
	// queue, in compliance with rules that define a binary heap.
	private int bubbleUp(double x, int index) {
		while (index > 1 && x < heapArray[index / 2]) {
			heapArray[index] = heapArray[index / 2];
			index = index / 2;
		}
		return index;
	}
	
	// Helper method that doubles the size of the available storage
	// space, called when the priority queue needs additional space 
	// to store values. 
	private void resize() {
		double[] temp = new double[heapArray.length * 2];
		for (int i = 1; i < heapArray.length; i++) {
			temp[i] = heapArray[i];
		}
		heapArray = temp;
	}
	
	// Throws an EmptyPQException if empty, otherwise removes and 
	// returns the value with the highest priority in the priority queue.
	public double deleteMin() {
		if (isEmpty()) {
			throw new EmptyPQException();
		}
		double value = heapArray[1];
		int index = bubbleDown(1, heapArray[size]);
		heapArray[index] = heapArray[size];
		size--;
		return value;
	}
	
	// Helper method called when the minimum value is removed from
	// the priority queue. This method replaces the removed value and 
	// rearranges the values in the priority queue, in compliance with
	// rules that define a binary heap.
	private int bubbleDown(int index, double x) {
		while (index * 2 <= size) {
			int target;
			int left = index * 2; 
			int right = index * 2 + 1;
			if (right > size || heapArray[left] < heapArray[right]) {
				target = left;
			} else {
				target = right;
			}
			if (heapArray[target] < x) {
				heapArray[index] = heapArray[target];
				index = target;
			} else {
				break;
			}
		}
		return index;
	}
	
	// Removes all the values from the priority queue.
	public void makeEmpty() {
		size = 0;
	}
}
