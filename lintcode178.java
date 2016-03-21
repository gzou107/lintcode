/*
Graph Valid Tree Show result 

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Have you met this question in a real interview? Yes
 Notice

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Tags
Related Problems
 Notes
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
*/


public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        return help(n, edges);
    }
    
    private boolean help(int n, int[][]edges)
    {
        if(n < 0) return false;
        
        UF  uf = new UF(n);
        
        for(int i = 0; i < edges.length; i++){
            
            if(uf.union(edges[i][0], edges[i][1])){
                return false;
            }
        }
        
        return uf.size() == n-1;
    }
    private class UF
    {
        private int []id;
        //public int []size;
        private int size;
        
        public UF(int n)
        {
            id = new int[n];
            for(int i = 0; i < n; i++)
            {
                id[i] = i;
            }
            size = 0;
        }
        
        public int find(int i){
            while(i != id[i])
            {
                id[i] = id[id[i]];
                i = id[i];
            }
            
            return i;
        }
        
        public boolean union(int i, int j){
            
            int ip = find(i);
            int jp = find(j);
            
            if(ip == jp){
                return true;
            }
            
            id[ip] = jp;
            size++;
            return false;
        }
        
        public int size()
        {
            return size;
        }
    }
}