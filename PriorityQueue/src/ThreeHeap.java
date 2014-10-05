// Vincent Nguyen, CSE 373, WIN2014
// Assignment #3, 02/07/14
//
// This program's behavior is to provide a priority queue
// implementation using a tree with branching factor of 3.
// It implements the PriorityQueue interface and contains the 
// common behaviors of a priority queue such as: isEmpty(),
// size(), findMin(), insert(), makeEmpty(), and deleteMin().

public class ThreeHeap implements PriorityQueue {
	
	private double[] heapArray;
	private int size;
	
	// Constructs a new ThreeHeap
	public ThreeHeap() {
		this.heapArray = new double[10];
		this.size = 0;
	}
	
	// Returns true if ThreeHeap is empty, and false otherwise
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns the number of values stored in the ThreeHeap
	public int size() {
		return this.size;
	}
	
	// Throws an EmptyPQException if ThreeHeap is empty, otherwise
	// returns value with highest priority in the ThreeHeap.
	public double findMin() {
		if (isEmpty()) {
			throw new EmptyPQException();
		} else {
			return heapArray[1];
		}
	}
	
	// Caller provides a double value which gets added into the 
	// priority queue. 
	public void insert(double x) {
		if (size == heapArray.length - 1) {
			resize();
		}
		size++;
		int index = bubbleUp(x, size);
		heapArray[index] = x;
	}
	
	// Helper method called when a value is inserted into the priority
	// queue, which rearranges the nodes of the ThreeHeap in compliance 
	// with rules that define a ThreeHeap.
	private int bubbleUp(double x, int index) {
		while (index > 1 && x < heapArray[(index + 1) / 3]) {
			heapArray[index] = heapArray[(index + 1) / 3];
			index = (index + 1) / 3;
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
	// rules that define a ThreeHeap.
	private int bubbleDown(int index, double x) {
		while (index * 3 <= size) {
			int target;
			int left = index * 3 - 1;
			int middle = index * 3;
			int right = index * 3 + 1;
			if (middle > size) {
				target = left;
			} else if (right > size) {
				if (heapArray[left] < heapArray[middle]) {
					target = left;
				} else {
					target = middle;
				}
			} else {
				if (heapArray[left] <= heapArray[middle] && heapArray[left] <= heapArray[right]) {
					target = left;
				} else if (heapArray[middle] <= heapArray[left] && heapArray[middle] <= heapArray[right]) {
					target = middle;
				} else {
					target = right;
				}
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
	
	// Removes all the values from the ThreeHeap
	public void makeEmpty() {
		size = 0;
	}
}
