import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        //입실시간을 기준으로 PQ 선언
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr1[1] - arr2[1];
                
                return arr1[0] - arr2[0];
            }
        });
        
        
        //HHMM 숫자 형태로 PQ에 삽입
        for(int i=0; i<book_time.length; i++){
            String[] tmp = book_time[i];
            
            String[] split1 = tmp[0].split(":");
            String[] split2 = tmp[1].split(":");
            
            //퇴실시간 + 청소 10분 고려해서 PQ에 삽입
            int start = Integer.parseInt(split1[0] + split1[1]);
            int end = Integer.parseInt(split2[0] + split2[1]) + 10;
            
            //ex) 15:67 -> 16:07
            if(end % 100 >= 60){
                end += 100;
                end -= 60;
            }
            
            pq.offer(new int[]{start,end});
        }
        
        
        //퇴실시간 + 10 >= next 입실 시간
        ArrayList<Stack<int[]>> list = new ArrayList<>();
        while(!pq.isEmpty()){
            
            int[] time = pq.poll();
            boolean flag = false;
            
            for(int i=0; i<list.size(); i++){
                Stack<int[]> stack = list.get(i);
                
                if(stack.peek()[1] <= time[0]){
                    stack.push(time);
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                list.add(new Stack<>());
                Stack<int[]> stack = list.get(list.size()-1);
                stack.push(time);
            }
        }
        
        answer = list.size();
        
        return answer;
    }
}
