class Solution {
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++){
            String x = babbling[i];
            
            //같은 단어를 2번이상 번복하면 다음 단어를 본다.
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")){
                continue;
            }
            
            //""이 아닌 " "으로치환한다.
            //공백으로 치환하면 글자가 붙어서 새로운 글자가 탄생되는데 원하는대로 처리되지 않을 수 있다.
            x = x.replace("aya", " ");
            x = x.replace("ye", " ");
            x = x.replace("woo", " ");
            x = x.replace("ma", " ");
            
            x = x.replace(" ", "");
            
            if(x.equals(""))
                answer++;
        }
        
        return answer;
    }
}
