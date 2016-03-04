/*
lintcode 30:Insert Interval Show result 

Given a non-overlapping interval list which is sorted by start point.

Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
*/
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
      
        // write your code here
        return help(intervals, newInterval);
    }
    
    private ArrayList<Interval> help(ArrayList<Interval>intervals, Interval newInterval)
    {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        
        for(int i = 0; i < intervals.size(); i++)
        {
            if(intervals.get(i).end < newInterval.start){
                result.add(intervals.get(i));
            }else if(intervals.get(i).start > newInterval.end){
                result.add(newInterval);
                newInterval = intervals.get(i);
            }else{
                newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            }
        }
        
        result.add(newInterval);
        return result;
    }
}