class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        
        //문자열 s를 쪼개보기
        for(int i=1; i<=s.length(); i++){
            StringBuilder sb = new StringBuilder();
            
            String tmp = s.substring(0, i);
            int cnt = 1;
            int start = i;
            while(start + i < s.length()){
                String x = s.substring(start, start + i);
                if(x.equals(tmp)){
                    cnt++;
                }else{
                    if(cnt == 1)
                        sb.append(tmp);
                    else
                        sb.append(cnt+tmp);
                    tmp = x;
                    cnt = 1;
                }
                start = start + i;
            }
            
            //마지막 처리
            String x = s.substring(start);
            if(x.equals(tmp)){
                sb.append(++cnt + tmp);
            }else{
                if(cnt != 1)
                    sb.append(cnt+tmp);   
                else
                    sb.append(tmp);
                sb.append(x);
            }
            
            answer = Math.min(answer, sb.toString().length());
        }
        
        return answer;
    }
}
