import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> tmp_answer = new ArrayList<>();
        
        //1. dfs로 모든 경우의 수 카운팅
        for(int i=0; i<orders.length; i++){
            String[] order = orders[i].split("");
            Arrays.sort(order);
            boolean[] visited = new boolean[order.length];
            
            dfs(0, order,visited, new StringBuilder());
        }
        
        
        //2. 1명의 손님만 주문한 경우 제외하기
        ArrayList<String> removeKeyList = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 1)
                removeKeyList.add(key);
        }
        for(String key : removeKeyList)
            map.remove(key);
        
        //3.정답 구하기
        for(int i=0; i<course.length; i++){
            int menu_cnt = course[i];
            ArrayList<SetMenu> list = new ArrayList<>();
            
            for(String key : map.keySet()){
                if(key.length() == menu_cnt){
                    if(list.size() == 0){
                        list.add(new SetMenu(key, map.get(key)));
                    }else{
                        int cur_max_cnt = list.get(list.size()-1).cnt;
                        
                        if(cur_max_cnt < map.get(key)){
                            list.clear();
                            list.add(new SetMenu(key,map.get(key)));
                        }else if(cur_max_cnt == map.get(key)){
                            list.add(new SetMenu(key,map.get(key)));
                        }
                    }
                }
            }
            
            //정답에 추가
            for(SetMenu menu : list){
                tmp_answer.add(menu.name);
            }
        }
        
        
        String[] answer = tmp_answer.toArray(new String[tmp_answer.size()]);
        Arrays.sort(answer);
        

        return answer;
    }
    
    public void dfs(int idx, String[] order, boolean[] visited, StringBuilder sb){
        
        if(sb.toString().length() >= 2){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        
        for(int i=idx; i<order.length; i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(order[i]);
                dfs(i+1, order, visited, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}

class SetMenu{
    String name;
    int cnt;
    
    public SetMenu(String name, int cnt){
        this.name = name;
        this.cnt = cnt;
    }
}
