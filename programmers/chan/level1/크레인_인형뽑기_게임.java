import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Queue<Integer>[] queues = new LinkedList[board.length + 1];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= board.length; i++) {
            queues[i] = new LinkedList<>(); 
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    queues[j + 1].offer(board[i][j]);
                }
            }
        }
        
        for (int i = 0; i < moves.length; i++) {
            if (!queues[moves[i]].isEmpty()) {
                int p = queues[moves[i]].poll();
                
                if (stack.isEmpty()) {
                    stack.push(p);
                } else {
                    if (p == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(p);
                    }
                }
            }
        }
        
        return answer;
    }
}
