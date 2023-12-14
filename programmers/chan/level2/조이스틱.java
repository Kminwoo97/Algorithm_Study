import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(String name) {
        int answer = 0;
        List<Integer> indices = new ArrayList<>();
        
        for (int i = 0; i < name.length(); i++) {
            int count = getCount(name.charAt(i));
            
            if (count > 0) {
                indices.add(i);
                answer += count;
            }
        }
        
        boolean[] isVisited = new boolean[21];
        
        if (indices.size() > 0 && indices.get(0) == 0) {
            indices.remove(0);
        }
        
        for (int index : indices) {
            isVisited[index] = true;
        }
        
        int trueCount = indices.size();
        int right = 0;
        
        dfs(indices, isVisited, 0, indices.size() - 1, right, name.length(), trueCount, 0);
        return answer += min;
    }

    public void dfs(List<Integer> indices, boolean[] isVisited, int cur, int left, int right, int len, int trueCount, int sum) {
        if (min < sum) {
            return;
        }
        
        if (trueCount <= 0) {
            min = Math.min(min, sum);
            return;
        }
        
        // 왼쪽으로 이동
        int leftIndex = indices.get(left);
        
        if (isVisited[leftIndex] == true) {
            isVisited[leftIndex] = false;
            
            int nextLeft = (left + indices.size() - 1) % indices.size();
            int nextRight = (left + 1) % indices.size();
            int nextSum = sum + Math.min(len - leftIndex + cur, Math.abs(leftIndex - cur));
            
            dfs(indices, isVisited, leftIndex, nextLeft, nextRight, len, trueCount - 1, nextSum);
            isVisited[leftIndex] = true;
        }
    
        // 오른쪽으로 이동
        if (indices.get(right) == 0) right++;
        int rightIndex = indices.get(right);
        
        if (isVisited[rightIndex] == true) {
            isVisited[rightIndex] = false;
            
            int nextLeft = (right + indices.size() - 1) % indices.size();
            int nextRight = (right + 1) % indices.size();
            int nextSum = sum + Math.min(len - cur + rightIndex, Math.abs(rightIndex - cur));
            
            dfs(indices, isVisited, rightIndex, nextLeft, nextRight, len, trueCount - 1, nextSum);
            isVisited[rightIndex] = true;
        }
    }
    
    public int getCount(char target) {
        int upCount = target - 'A';
        int downCount = 26 - upCount;
        
        return Math.min(upCount, downCount);
    }
}
