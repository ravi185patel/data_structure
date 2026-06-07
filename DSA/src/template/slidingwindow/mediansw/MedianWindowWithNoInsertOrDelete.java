package template.slidingwindow.mediansw;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianWindowWithNoInsertOrDelete {

        public PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        // left = maxHeap
        public PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        // right = minHeap

        public  void add(int num){
            if(leftHeap.isEmpty() || num <= leftHeap.peek()){
                leftHeap.offer(num);
            }else{
                rightHeap.offer(num);
            }
            balance();
        }

        public  void balance(){
            if(leftHeap.size() > rightHeap.size()+1){
                rightHeap.offer(leftHeap.poll());
            }
            if(leftHeap.size() < rightHeap.size()){
                leftHeap.offer(rightHeap.poll());
            }
        }

        public double findMedian(){
             if(leftHeap.size() > rightHeap.size()){
                 return leftHeap.peek();
             }
             return (leftHeap.peek()- rightHeap.peek())/2.0;
        }
}
