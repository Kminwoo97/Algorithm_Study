class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int x : ingredient){
            sb.append(x);
            
            if(sb.length() >= 4 && sb.substring(sb.length() - 4, sb.length()).equals("1231")){
                sb.delete(sb.length() - 4, sb.length());
                answer++;
            }
        }
        
        return answer;
    }
}
