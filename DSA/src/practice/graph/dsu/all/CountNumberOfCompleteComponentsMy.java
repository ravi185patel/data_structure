package practice.graph.dsu.all;

import java.util.*;

class CountNumberOfCompleteComponentsMy {
    public static void main(String[] args) {
        System.out.println(countCompleteComponents(5,new int[][]{
                {0,1},
                {0,2},
                {1,2},
                {3,4},
        }));

        System.out.println(countCompleteComponents(6,new int[][]{
                {0,1},
                {0,2},
                {1,2},
                {3,4},
                {3,5},
        }));

        System.out.println(countCompleteComponents(6,new int[][]{
                {0,1},
                {0,2},
                {1,2},
                {3,4},
                {3,5},
                {5,4}
        }));

        System.out.println(countCompleteComponents(5,new int[][]{
                {0,1},
                {0,2},
                {1,2},
                {2,3},
                {3,4},
                {4,2}
        }));
    }


    public static int countCompleteComponents(int n, int[][] edges) {
            Map<Integer,List<Integer>> map = getAdjList(n,edges);
            int inDegree[]=new int[n];
            for(int edge[]:edges){
                inDegree[edge[0]]++;
                inDegree[edge[1]]++;
            }
            System.out.println(Arrays.toString(inDegree));
            System.out.println(map);
            return helper(n,map,inDegree);
    }

    public static int helper(int n,Map<Integer,List<Integer>> map,int inDegree[]){

        boolean visited[]=new boolean[n];
        int noOfComponent=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(i,n,map,visited);
                if(isValid(i,n,map,visited,inDegree)){
                    noOfComponent++;
                }
            }
        }
        return noOfComponent;
    }

    public static void dfs(int index,int n,Map<Integer,List<Integer>> map,boolean visited[]){
        visited[index] = true;
        for(int nbNode:map.get(index)){
            if(visited[nbNode]==false){
                dfs(nbNode,n,map,visited);
            }
        }
    }

    public static boolean isValid(int index,int n,Map<Integer,List<Integer>> map,boolean visited[],int inDegree[]){
        // here the main problem as you visited each and every one but you are counting degree
//         only for parent 0 and child 1,2 not process further for 2's child.
        int degree=inDegree[index];
        for(int nbNode:map.get(index)){
            if(visited[nbNode]){
                degree+=inDegree[nbNode];
            }
        }
        int vertex = map.get(index).size()+1;
        System.out.println("Vertex: "+vertex+" <> Edges: "+degree);
        return (vertex*(vertex-1)) <= degree;
    }

    public static Map<Integer,List<Integer>> getAdjList(int n,int edges[][]){
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }

        for(int edge[]:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }
}
