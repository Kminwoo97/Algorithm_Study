import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int col = moves[i] - 1;
            for(int j=0; j<board.length; j++){
                int x = board[j][col];
                if(x != 0){
                    if(stack.isEmpty()){
                        stack.push(x);
                    }else{
                        if(stack.peek() == x){
                            stack.pop();
                            answer += 2;
                        }else{
                            stack.push(x);
                        }
                    }
                    board[j][col] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
