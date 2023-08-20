import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        
        while (stack.size() > 1) {
            int p1 = stack.pop();
            int p2 = stack.pop();
            int lcm = getLCM(p1, p2);
            stack.push(lcm);
        }
        
        return answer = stack.pop();
    }
    
    public int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        
        return a * b / gcd;
    }
    
    public int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return getGCD(b, a % b);
    }
}