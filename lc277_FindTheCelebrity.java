/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        
        ==================
        if (knows (a, b))
        a knows b, a is not candidate, b can be a candidate
        
        loop n from 0, 
        candidate = 0;
        know(candidate, i);
        
        **/
        
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                //i can be candidate
                candidate = i;
            }
        }
        
        for (int i = 0; i < n ; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate)))
                return -1;
        }
        return candidate;
        
    }
}