import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //String 정렬 -> 사전순으로 정렬
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            String a = phone_book[i];
            String b = phone_book[i+1];
            
            if(b.startsWith(a))
                return false;
        }
        
        return answer;
    }
}
