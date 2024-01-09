import java.util.*;

class Solution {

    
    public long solution(String expression) {
        long answer = 0;
        
        //연산자 우선순위 총 6가지 조합
        char[][] pairs = {{'*','+','-'}, {'*','-','+'}, 
                          {'+','*','-'}, {'+','-','*'}, 
                          {'-','+','*'} ,{'-','*','+'}};
        
        //숫자만 뽑아내기
        String num_exp = expression;
        num_exp = num_exp.replaceAll("[^0-9]", " ");
        
        ArrayList<Long> nums = new ArrayList<>();
        String[] str_num = num_exp.split(" ");
        for(int i=0;i <str_num.length; i++){
            nums.add(Long.parseLong(str_num[i]));
        }
        
        //연산자만 뽑아내기
        ArrayList<Character> ops = new ArrayList<>();
        String str_ops = expression.replaceAll("[0-9]", " ").trim();
        for(int i=0; i<str_ops.length(); i++){
            if(str_ops.charAt(i) != ' '){
                ops.add(str_ops.charAt(i));
            }
        }
        
        
        //연산자 우선순위 6가지의 경우를 모두 고려해서 정답도출
        for(char[] pair : pairs){
            ArrayList<Long> copy_nums = new ArrayList<>(nums);
            ArrayList<Character> copy_ops = new ArrayList<>(ops);
            
            for(char op : pair){
                while(copy_ops.indexOf(op) != -1){
                    int i = copy_ops.indexOf(op);
                    
                    long a = copy_nums.get(i);
                    long b = copy_nums.get(i+1);
                    char operation = copy_ops.get(i);
                    
                    long result = 0L;
                    if(operation == '-')
                        result = a - b;
                    if(operation == '+')
                        result = a + b;
                    if(operation == '*')
                        result = a * b;
                    
                    copy_nums.remove(i);
                    copy_nums.remove(i);
                    copy_ops.remove(i);
                    
                    copy_nums.add(i, result);
                }
            }
            
            
            answer = Math.max(answer, Math.abs(copy_nums.get(0)));
        }
        
        
        return answer;
    }

}
