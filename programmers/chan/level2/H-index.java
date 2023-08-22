import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(citations);
        
        for (int i = 0; i < len; i++) {
            int h = citations[i];
            int count = 0;
            
            for (int j = 0; j < len; j++) {
                if (citations[j] >= h) {
                    count++;
                }
            }
            
            if (count >= h) {
                list.add(h);
            } else {
                int value = 0;
                
                while (value < citations[i]) {
                    count = 0;
                    
                    for (int j = 0; j < len; j++) {
                        if (citations[j] >= value) {
                            count++;
                        }
                    }
                    
                    if (count >= value) {
                        list.add(value);
                    }
                    
                    value++;
                }
                
                break;
            }
        }
        
        answer = list.get(list.size() - 1);
        
        return answer;
    }
}
