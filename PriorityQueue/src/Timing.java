import java.util.*;
// INSERT
public class Timing {
    public static final int NUM_TIMINGS = 5;
    public static final double N = 50000.0;
    public static void main(String[] args) {
    	Random r = new Random();
    	for(int timing = 0; timing < NUM_TIMINGS; ++timing) {
        	PriorityQueue test = new ThreeHeap();
        	for (double i = 0; i < N; i++) {
        		test.insert(r.nextDouble() * N);
        	}
            long startTime = System.nanoTime();
            // ... The code being timed ...
            test.insert(r.nextDouble() * N);
            // ... End code being timed ...
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println(elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
    }
}


// DELETEMIN
/* public class Timing {
    public static final int NUM_TIMINGS = 5;
    public static final double N = 50000.0;
    public static void main(String[] args) {
    	Random r = new Random();
    	for(int timing = 0; timing < NUM_TIMINGS; ++timing) {
        	PriorityQueue test = new MyPQ();
        	for (double i = 0; i < N; i++) {
        		test.insert(r.nextDouble() * N);
        	}
            long startTime = System.nanoTime();
            // ... The code being timed ...
            test.deleteMin();
            // ... End code being timed ...
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println(elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
    }
}
*/