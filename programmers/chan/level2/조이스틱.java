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
        for (int index : indices) {
            isVisited[index] = true;
        }
        
        int trueCount = indices.size();
        
        if (indices.get(0) == 0) trueCount--;
        
        dfs(indices, isVisited, 0, indices.size() - 1, 0, name.length(), trueCount, 0);
               
        return answer += min;
    }

    public void dfs(List<Integer> indices, boolean[] isVisited, int cur, int left, int right, int len, int trueCount, int sum) {
        if (min < sum) {
            return;
        }
        
        if (trueCount == 0) {
            min = Math.min(min, sum);
            return;
        }
        
        // 왼쪽으로 이동
        int leftIndex = indices.get(left);
        
        if (isVisited[leftIndex] == true) {
            isVisited[leftIndex] = false;
            
            System.out.println(cur + " " + leftIndex + " " + Math.min(len - leftIndex + cur, Math.abs(leftIndex - cur)));
            dfs(indices, isVisited, leftIndex, (left + indices.size() - 1) % indices.size(), right, len, trueCount - 1, sum + Math.min(len - leftIndex + cur, leftIndex - cur));
            isVisited[leftIndex] = true;
        }
    
        // 오른쪽으로 이동
        int rightIndex = indices.get(right);
        
        if (isVisited[rightIndex] == true) {
            isVisited[rightIndex] = false;
            
            System.out.println("오른쪽이 = " + cur + " " + rightIndex + " " + Math.min(len - cur + rightIndex, Math.abs(rightIndex - cur)));
            dfs(indices, isVisited, rightIndex, left, (right + 1) % indices.size(), len, trueCount - 1, sum + Math.min(len - cur + rightIndex, Math.abs(rightIndex - cur)));
            isVisited[rightIndex] = true;
        }
    }
    
    public int getCount(char target) {
        int upCount = target - 'A';
        int downCount = 26 - upCount;
        
        return Math.min(upCount, downCount);
    }
}
