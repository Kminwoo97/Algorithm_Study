class Solution {
    String[] list = new String[]{"A","E","I","O","U"};
    String target;
    int answer = 0;
    int cnt = 0;
    public int solution(String word) {
        target = word;
        
        dfs("");
        
        return answer;
    }
    
    public void dfs(String word){
        if(word.equals(target)){
            answer = cnt;
            return;
        }
        if(word.length() == 5){
            return;
        }
        
        for(int i=0; i<5; i++){
            cnt++;
            dfs(word + list[i]);
        }
    }
}
