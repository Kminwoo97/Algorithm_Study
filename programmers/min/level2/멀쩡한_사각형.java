class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        //y = 기울기 * X = (h * x) / w
        for(int i=1; i<w; i++){
            answer += ((long)h * (long)i) / w;
            
        }
        answer *= 2;
        
        return answer;
    }
}
