// Vincent Nguyen, CSE 373, WIN2014
// Assignment #3, 02/07/14
//
// This program's behavior is to provide MyPQNode intended
// to be used with the MyPQ class, implementing priority queue
// using a linkedlist.

public class MyPQNode {
	
	public double value;
	public MyPQNode next;
	
	// Client provides a double value and a MyPQNode
	// Creates a new MyPQNode using the provided parameters
	public MyPQNode(double value, MyPQNode next) {
		this.value = value;
		this.next = next;
	}
}
