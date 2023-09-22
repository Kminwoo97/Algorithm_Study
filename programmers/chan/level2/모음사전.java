class Solution {
    static int count = 0;
    static int result = 0;
    static char[] ch = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        dfs(sb, word);
        
        return answer = result;
    }
    
    public void dfs(StringBuilder sb, String word) {
        if (sb.toString().equals(word)) {
            result = count;
        }
        
        for (int i = 0; i < 5; i++) {       
            if (sb.length() < 5) {
                StringBuilder sub = new StringBuilder(sb);
                sub.append(ch[i]);
                count++;
                
                dfs(sub, word);
            }
        }
    }
}
