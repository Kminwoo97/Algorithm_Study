class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        
        //해당 문제의 핵심 -> s.substring()이 O(N)의 시간복잡도를 가진다.
        //따라서 시간초과가 발생한다. 인덱스를 직접 비교해서 코드를 작성했다.
        for(int i=s.length(); i>=0; i--){
            for(int j=0; j<s.length(); j++){
                
                if(i+j <= s.length()){    
                    if(IsPalindrom(s, j, i+j-1)){
                        return i;
                    }
                }
                
            }
        }

        return answer;
    }
    
    public boolean IsPalindrom(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
