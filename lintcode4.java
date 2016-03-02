/*
LintCode 4

Ugly Number Show result 
Ugly number is a number that only have factors 3, 5 and 7.

Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
*/
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        return help2(k);
    }
    
    private long help2(int k)
    {
    	long[] res = new long[k+1];
        res[0] = 1;
        int k3 = 0;
		int k5 = 0; 
		int k7 = 0;
		
        for (int i=1; i<=k; i++) {
            res[i] = Math.min(Math.min(res[k3]*3, res[k5]*5), res[k7]*7);
            if (res[i]/res[k3] == 3) k3++;
            if (res[i]/res[k5] == 5) k5++;
            if (res[i]/res[k7] == 7) k7++;
        }
        return res[k];
     }
     
     /*
    private class Ugly
    {
        public int base;
        public int count;
        public long value;
        
        public Ugly(int base, int count)
        {
            this.base = base;
            this.count = count;
            this.value = (long)base*(long)count;
        }
    }
    
    private class UglyComparator implements Comparator<Ugly>
    {
          @Override
            public int compare(Ugly one, Ugly other){
                if(one.value < other.value){
                    return -1;
                }else if(one.value - other.value > 0){
                    return 1;
                }else{
                    return 0;
                }
            }
    }
    private long help(int k)
    {
        Comparator<Ugly> myComparator = new UglyComparator();
        PriorityQueue<Ugly> pq = new PriorityQueue<Ugly>(myComparator);
        
        pq.add(new Ugly(3,1));
        pq.add(new Ugly(5,1));
        pq.add(new Ugly(7,1));
        
        long prev = 0;
        long result = 3;
        
        int index = 0;
        while(index < k){
            Ugly num = pq.poll();
            pq.offer(new Ugly(num.base, num.count+1));
            prev = result;
            result = num.value;
            
            while(!pq.isEmpty() && pq.poll().value == num.value){
                Ugly top = pq.poll();
                pq.poll();
                pq.offer(new ugly(top.base, top.count+1));
            }
            index++;
        }
        return prev;
    }*/
};
