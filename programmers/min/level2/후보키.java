import java.util.*;

class Solution {
    
    int row, col;
    boolean[] visited;
    ArrayList<String> list = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        row = relation.length;
        col = relation[0].length;
        
        //1. nCr로 경우의 수를 뽑느다.
        for(int i=1; i<=col; i++){
            visited = new boolean[col];
            combi(0, i);
        }
        
        //2. nCr 중에 유일성을 확인한다.
        ArrayList<String> unique = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(IsUnique(relation, list.get(i))){
                unique.add(list.get(i));
            }
        }
        
        //3. 최소성을 확인한다.
        ArrayList<String> minimum = new ArrayList<>(unique);
        for(int i=0; i<unique.size(); i++){
            
            String start = unique.get(i); 
            
            for(int j=0; j<unique.size(); j++){
                String target = unique.get(j);
                
                if(start.equals(target))
                    continue;
                
                //비교하기(target의 길이는 언제나 start의 길이보다 작거나 같다)
                int cnt = 0;
                for(char c : start.toCharArray()){
                    if(target.contains(String.valueOf(c))){
                        cnt++;
                    }
                }
                
                //start의 모든 컬럼이 target에 포함되어 있다면 최소성을 보장하지 못한다.
                if(cnt == start.length())
                    minimum.remove(target);
            }
        }
        
        answer = minimum.size();
        
        return answer;
    }
    
    public void combi(int start, int r){
        if(r == 0){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<col; i++){
                if(visited[i]){
                    sb.append(i);
                }
            }
            list.add(sb.toString());
            return;
        }
        
        for(int i=start; i<col; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(i, r-1);
                visited[i] = false;
            }
        }
    }
    
    public boolean IsUnique(String[][] relation, String x){
        HashSet<String> set = new HashSet<>();
        String[] idx = x.split("");
        
        for(String[] record : relation){
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<idx.length; i++){
                int j = Integer.parseInt(idx[i]);
                sb.append(record[j]);
            }
            
            if(set.contains(sb.toString()))
                return false;
            set.add(sb.toString());
        }     
        return true;
    }

}
