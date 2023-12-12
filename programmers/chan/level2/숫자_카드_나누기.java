import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        List<Integer> listA = getCommonDivisors(arrayA[0]);
        int gcdA = getGCD(listA, arrayA);
        
        List<Integer> listB = getCommonDivisors(arrayB[0]);
        int gcdB = getGCD(listB, arrayB);
        
        if (!isMatched(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }
        
        if (!isMatched(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    
    public List<Integer> getCommonDivisors(int first) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(first); i++) {
            if (first % i == 0) {
                if (i != first / i) {
                    int div = first / i;
                    list.add(div);
                }
                
                list.add(i);
            }
        }
        
        return list;
    }
    
    public int getGCD(List<Integer> list, int[] arr) {
        int max = 0;
        
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            boolean flag = true;
            
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % value != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                max = Math.max(max, value);
            }
        }
        
        return max;
    }
    
    public boolean isMatched(int[] arr, int gcd) {
        boolean isMatched = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % gcd == 0) {
                isMatched = true;
                break;
            }
        }
        
        return isMatched;
    }
}
