package practice.graph.dsu;

public class Disjoint{

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
            if (weight[pX] < weight[pY]) {
                parent[pX] = pY;
                weight[pY] += weight[pX];
            } else {
                parent[pY] = pX;
                weight[pX] += weight[pY];
            }
        }
    }
