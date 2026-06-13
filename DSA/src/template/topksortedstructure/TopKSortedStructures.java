package template.topksortedstructure;

import java.util.*;

public class TopKSortedStructures {

    // Helper class to store the state of the iterator in the heap
    private static class HeapNode {
        int value;
        int listIndex;    // Which list this element came from
        int elementIndex; // The index of this element inside its list

        public HeapNode(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static List<Integer> getTopK(List<List<Integer>> lists, int k) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if input is empty or k is invalid
        if (lists == null || lists.isEmpty() || k <= 0) {
            return result;
        }

        // Initialize Min-Heap based on the 'value' property of HeapNode
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.value, b.value)
        );

        // Step 1: Push the first element of each non-empty list into the heap
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null && !lists.get(i).isEmpty()) {
                minHeap.offer(new HeapNode(lists.get(i).get(0), i, 0));
            }
        }

        // Step 2: Extract the minimum element K times
        while (!minHeap.isEmpty() && result.size() < k) {
            HeapNode current = minHeap.poll();
            result.add(current.value);

            // Step 3: If the same list has a next element, push it into the heap
            int nextElementIdx = current.elementIndex + 1;
            if (nextElementIdx < lists.get(current.listIndex).size()) {
                int nextValue = lists.get(current.listIndex).get(nextElementIdx);
                minHeap.offer(new HeapNode(nextValue, current.listIndex, nextElementIdx));
            }
        }

        return result;
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
            Arrays.asList(1, 5, 9),
            Arrays.asList(2, 6, 8, 10),
            Arrays.asList(3, 7)
        );
        int k = 5;

        List<Integer> topK = getTopK(lists, k);
        System.out.println("Top " + k + " elements: " + topK);
        // Output: Top 5 elements: [1, 2, 3, 5, 6]
    }
}