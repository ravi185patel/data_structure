package template.slidingwindow.mediansw;

import java.util.TreeMap;

public class MedianWindowWithInsertOrDelete {

        public TreeMap<Integer, Integer> left = new TreeMap<>();
        public TreeMap<Integer, Integer> right = new TreeMap<>();

        public int leftSize = 0;
        public int rightSize = 0;

        public long leftSum = 0;
        public long rightSum = 0;

        public  void add(TreeMap<Integer,Integer> map,int val){
        map.put(val,map.getOrDefault(val,0)+1);
    }

        public  void remove(TreeMap<Integer,Integer> map,int val){
        int freq = map.get(val);

        if(freq == 1){
            map.remove(val);
        }else{
            map.put(val,freq-1);
        }
    }

        public void insert(int val){

        if(leftSize == 0 || val <= left.lastKey()){
            add(left,val);
            leftSize++;
            leftSum += val;
        }else{
            add(right,val);
            rightSize++;
            rightSum += val;
        }

        balance();
    }

        public void erase(int val){

        if(left.containsKey(val)){
            remove(left,val);
            leftSize--;
            leftSum -= val;
        }else{
            remove(right,val);
            rightSize--;
            rightSum -= val;
        }

        balance();
    }

        public  void balance(){

        while(leftSize > rightSize + 1){

            int move = left.lastKey();

            remove(left,move);
            leftSize--;
            leftSum -= move;

            add(right,move);
            rightSize++;
            rightSum += move;
        }

        while(leftSize < rightSize){

            int move = right.firstKey();

            remove(right,move);
            rightSize--;
            rightSum -= move;

            add(left,move);
            leftSize++;
            leftSum += move;
        }
    }

        public long cost(){

        long median = left.lastKey();

        long leftCost =
                median * leftSize - leftSum;

        long rightCost =
                rightSum - median * rightSize;

        return leftCost + rightCost;
    }
}
