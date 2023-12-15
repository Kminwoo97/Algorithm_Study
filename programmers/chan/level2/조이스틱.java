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
        
        boolean[] isVisited = new boolean[20];
        
        if (indices.size() == 0) {
            return answer;
        }
        
        if (indices.get(0) == 0) {
            indices.remove(0);
        }
        
        for (int index : indices) {
            isVisited[index] = true;
        }
        
        // 왼쪽
        dfs(indices, isVisited, 0, indices.size() - 1, name.length(), 0);
        // 오른쪽
        dfs(indices, isVisited, 0, 0, name.length(), 0);
        return answer += min;
    }

    public void dfs(List<Integer> indices, boolean[] isVisited, int curIndex, int cur, int len, int sum) {
        if (min < sum) {
            return;
        }
        
        boolean flag = true;
        
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == true) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            min = Math.min(min, sum);
            return;
        }
        
        // 왼쪽으로 이동
        int next = (cur - 1 + indices.size()) % indices.size();
        int leftIndex = indices.get(next);
        
        int nextSum = sum + Math.min(len - leftIndex + curIndex, Math.abs(leftIndex - curIndex));
            
        if (isVisited[leftIndex] == true) {
            isVisited[leftIndex] = false;
            
            dfs(indices, isVisited, leftIndex, next, len, nextSum);
            isVisited[leftIndex] = true;
        }
    
        // 오른쪽으로 이동
        next = (cur + 1) % indices.size();
        int rightIndex = indices.get(next);
        
        nextSum = sum + Math.min(len - curIndex + rightIndex, Math.abs(rightIndex - curIndex));
        
        if (isVisited[rightIndex] == true) {
            isVisited[rightIndex] = false;
            
            dfs(indices, isVisited, rightIndex, next, len, nextSum);
            isVisited[rightIndex] = true;
        }
    }
    
    public int getCount(char target) {
        int upCount = target - 'A';
        int downCount = 26 - upCount;
        
        return Math.min(upCount, downCount);
    }
}
