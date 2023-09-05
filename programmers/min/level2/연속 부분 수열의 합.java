import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = 0;
                for(int k=j; k<j+i; k++){
                    tmp += elements[k % n];
                }
                set.add(tmp);
            }
        }
        
        answer = set.size();
        return answer;
    }
}
