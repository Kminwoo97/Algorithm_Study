import java.util.*;

class Solution {
    static Set<String> set = new HashSet<>();
    
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i <= d; i++) {
            find(i, k, d);
        }
        
        return answer = set.size();
    }
                
    public int[] find(int a, int k, int d) {
        int[] result = new int[2];
        
        double kExp = Math.pow(k, 2);
        double b = Math.sqrt(Math.pow(d, 2) / kExp - Math.pow(a, 2));
        int intB = (int) b;
        
        if (b == intB) {
            set.add(a + "," + intB);
            System.out.println(a + " " + intB);
        }
        
        return result;
    }
}
