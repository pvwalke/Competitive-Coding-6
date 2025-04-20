
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We use HashMap to log the message and timestamp and then do calculations based on the constraints given
public class Logger {
    private final Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastPrinted = map.get(message);

        if (lastPrinted == null || timestamp - lastPrinted >= 10) {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }
}

// Time Complexity : O(k*n) -> k is the number of valid paths and we do this for n times
// Space Complexity : O(n) -> this is the visited array size which is n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Generated permutations by recursing and checked for valid paths only using backtracking
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1]; //1- based indexing
        //generateAndCountPermutations
        generateAndCountPermutations(1, n , visited);
        return count;
    }

    private void generateAndCountPermutations( int pos, int n, boolean[] visited){
// n = 3 -> [1,2,3]
        //base case
        if(pos > n){
            count ++;
            return;
        }

        //recurse and backtrack
        //visited[i] = [f,t,t,f] //pos = 3
        for(int i = 1; i<=n; i++){
            if(!visited[i] && (pos % i == 0 || i % pos == 0)){
                visited[i] = true;
                //visited[i] = [f,t,t,t]
                //action
                generateAndCountPermutations(pos+1, n, visited);
                visited[i] = false;
                //visited[i] = [f,t,f,f]
            }
        }
    }
}
