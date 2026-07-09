package practice.graph.dsu;


import java.util.Stack;

class Disjoint{

        int parent[];
        int weight[];

        int length;
        public Disjoint(int n){
            this.length =n;
            parent=new int[n];
            weight=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int pX){
            if(pX == parent[pX]){
                return pX;
            }
            return parent[pX]=find(parent[pX]);
        }

        public void merge(int x,int y){
            int pX = find(x);
            int pY = find(y);
            if(pX == pY){
                return;
            }
            if(weight[pX] <= weight[pY] ){
                parent[pY]=pX;
                weight[pX]+=weight[pY];
            }else{
                parent[pX]=pY;
                weight[pY]+=weight[pX];
            }
        }
    }

    public class PathExistenceQueriesGraphI {
        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
            int[] component=new int[n];
            int val=0;
            component[0]=0;
            for(int i=1;i<n;i++){
                if(nums[i]-nums[i-1] > maxDiff){
                    val++; // prefixSum ==== 1,2,3,
                }
                component[i]=val;
            }
            boolean[] ans = new boolean[queries.length];
            for(int i=0;i<queries.length;i++){
                int start = queries[i][0];
                int end = queries[i][1];
                ans[i]= component[start]==component[end];

            }
            return ans;
        }
        public boolean[] pathExistenceQueries1(int n, int[] nums, int maxDiff, int[][] queries) {

            int qLength = queries.length;
            boolean ans[]=new boolean[qLength];
            Disjoint ds = new Disjoint(n);

            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<n;i++){
                while(!stack.isEmpty() && nums[i]-nums[stack.peek()] <= maxDiff){
                    int index = stack.pop();
                    ds.merge(index,i);
                }
                stack.push(i);
            }
            // for(int i=0;i<n;i++){
            //     for(int j=i+1;j<n;j++){
            //         if(nums[j]-nums[i] <= maxDiff){
            //             ds.merge(i,j);
            //         }else{
            //             break;
            //         }
            //     }
            // }
            int index=0;
            for(int[] query:queries){
                if(ds.find(query[0]) == ds.find(query[1])){
                    ans[index]=true;
                }
                index++;
            }

            return ans;
        }
    }
