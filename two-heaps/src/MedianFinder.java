import java.util.PriorityQueue;

class MedianFinder {
    // Max-Heap to store the smaller half of the numbers
    private PriorityQueue<Integer> left;
    // Min-Heap to store the larger half of the numbers
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        // Max-Heap (in Java, PriorityQueue is a Min-Heap by default, so we use a lambda to invert the order)
        left = new PriorityQueue<>((a, b) -> b - a);
        // Min-Heap
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add to max-heap (left)
        left.offer(num);
        // Balance the heaps
        right.offer(left.poll());

        // If the right heap has more elements, move the root to the left heap
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(6);
        obj.addNum(7);
        obj.addNum(9);
        obj.addNum(10);
        double median = obj.findMedian();
        System.out.println(median);
    }
}
