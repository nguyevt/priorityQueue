public class TestScripts {
	
	public static void main(String[] args) {
		
		// Test by changing test to: BinaryHeap(), ThreeHeap(), MyPQ()
		PriorityQueue test = new ThreeHeap();
		
		// Test should return true for empty PQ
		System.out.println("Is Empty?: " + test.isEmpty());
		
		// Insert 1, 3, 9, 7, 5, 4, 5, 2, 8, 6
		System.out.println("Insert 1, 3, 9, 7, 5, 4, 5, 2, 8, 6, 0");
		test.insert(1.0);
		test.insert(3.0);
		test.insert(9.0);
		test.insert(7.0);
		test.insert(5.0);
		test.insert(4.0);
		test.insert(5.0);
		test.insert(2.0);
		test.insert(8.0);
		test.insert(6.0);
		test.insert(0.0);
		
		// Should print size = 10
		System.out.println("size = " + test.size());
		
		// findMin should return 1.0
		System.out.println("findMin = " + test.findMin());
		
		// Should return 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9
		while (test.size() > 1) {
			System.out.print(test.deleteMin() + ", ");
		}
		System.out.print(test.deleteMin());
		System.out.println();
		
		// Insert (4) 5's and (4) 6's
		for (double i = 6.0; i >= 5.0; i--) {
			for (int j = 1; j <= 4; j++) {
				test.insert(i);
			}
		}
		
		// Size should = 8
		System.out.println("size = " + test.size());
		
		// Test for isEmpty()
		System.out.println("Is Empty?: " + test.isEmpty());
		
		// Should return 6, 6, 6, 6, 5, 5, 5, 5
		System.out.print(test.deleteMin());
		for (int i = test.size(); i > 0; i--) {
			System.out.print(", " + test.deleteMin());
		}
		System.out.println();
		
		
		// Should return an EmptyPQException()
		test.deleteMin();
		test.findMin();
		
	}
}
