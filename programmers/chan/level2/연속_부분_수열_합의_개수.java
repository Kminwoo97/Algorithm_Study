import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet();
    public int solution(int[] elements) {
        int answer = 0;
        int[] arr = new int[elements.length * 2];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i % elements.length];
        }
        
        for (int i = 1; i <= elements.length; i++) {
            search(arr, i);
        }
        
        return answer = set.size();
    }
    
    public void search(int[] arr, int n) {
        for (int i = 0; i < arr.length / 2; i++) {
            Stack<Integer> stack = new Stack<>();
            
            recursive(arr, stack, i, n, arr[i]);
        }
    }
    
    public void recursive(int[] arr, Stack<Integer> stack, int start, int n, int sum) {
        stack.push(start);
        
        if (stack.size() == n) {
            while (!stack.isEmpty()) {
                set.add(sum);
                return;
            }
        }
        
        recursive(arr, stack, start + 1, n, sum + arr[start + 1]);
    }
}
