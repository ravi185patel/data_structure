package practice.graph.dsu;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PathExistenceQueriesGraphI {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int val = 0;
        component[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                val++; // prefixSum ==== 1,2,3,
            }
            component[i] = val;
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = component[start] == component[end];

        }
        return ans;
    }

    public boolean[] pathExistenceQueries1(int n, int[] nums, int maxDiff, int[][] queries) {

        int qLength = queries.length;
        boolean ans[] = new boolean[qLength];
        Disjoint ds = new Disjoint(n);

//            Stack<Integer> stack = new Stack<>();
//            for(int i=0;i<n;i++){
//                while(!stack.isEmpty() && nums[i]-nums[stack.peek()] <= maxDiff){
//                    int index = stack.pop();
//                    ds.merge(index,i);
//                }
//                stack.push(i);
//            }
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                ds.merge(i - 1, i);
            }
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
        int index = 0;
        for (int[] query : queries) {
            if (ds.find(query[0]) == ds.find(query[1])) {
                ans[index] = ds.find(query[0]) == ds.find(query[1]);
            }
            index++;
        }

        return ans;
    }

    public static boolean[] pathExistenceQueriesDSU(int n,int[] nums,int maxDiff,int[][] queries) {
        int[] tags = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                tags[i] = tags[i - 1] + 1;
            } else {
                tags[i] = tags[i - 1];
            }
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            res[i] = tags[x] == tags[y];
        }
        return res;
    }
    public static boolean[] pathExistenceQueriesBS(
            int n,
            int[] nums,
            int maxDiff,
            int[][] queries
    ) {
        List<Integer> rights = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                rights.add(i - 1);
            }
        }
        rights.add(n - 1);

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            int idxX = lowerBound(rights, x);
            int idxY = lowerBound(rights, y);
            res[i] = idxX == idxY;
        }
        return res;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0,
        right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
