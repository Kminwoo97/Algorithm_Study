class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        char x = array[0];
        sb.append(x);
        int cntA = 1;
        int cntB = 0;
        for(int i=1; i<array.length; i++){
            //3. 분리시키고 다시 x 지정
            if(cntA == 0 && cntB == 0){
                x = array[i];
                cntA = 1;
                sb.append(array[i]);
                continue;
            }
            
            //1. 카운팅
            if(x == array[i]){
                cntA++;
            }else{
                cntB++;
            }
            sb.append(array[i]);
            
            //2. 카운팅 횟수 같아지면 분리
            if(cntA == cntB){
                cntA = cntB = 0;
                sb.append("-");
            }
        }
        
        //정답도출
        String[] split = sb.toString().split("-");
        for(int i=0; i<split.length; i++){
            if(!split[i].isEmpty())
                answer++;
        }
        
        return answer;
    }
}
