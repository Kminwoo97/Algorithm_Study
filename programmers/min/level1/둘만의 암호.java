class Solution {
    public String solution(String s, String skip, int index) {
        //소문자 아스키 코드(97 ~ 122)
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            
            for(int j=0; j<index; j++){
                x += 1;
                
                if(x > 'z')
                    x -= 26;
                
                //skip에 포함되는거면 j를 증가시키지 않는다.
                //반복문의 j++ 과 j--가 만나면서 j는 증가하지 않는것처럼 동작한다.
                if(skip.contains(String.valueOf(x))){
                    j--;
                }
            }
            
            sb.append(x);
        }
        return sb.toString();
    }
}
