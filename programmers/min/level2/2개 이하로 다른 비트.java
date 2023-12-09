class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            
            //짝수인 경우는 2진수의 1의 자리가 '0' 이므로 +1 한 숫자가 가장 작은 수
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
            }else{
                //홀수 인 경우는 2진수의 1의 자리 부터 탐색해서 처음 등장하는 '0' -> '1' 전환
                String str_num = Long.toBinaryString(numbers[i]);
                for(int j=str_num.length()-1; j>=0; j--){
                    if(str_num.charAt(j) == '0'){
                        long plus = (long)Math.pow(2, str_num.length() - 1 - j);
                        answer[i] = numbers[i] + plus;
                        
                        //해당 위치부터 '1' 을 찾아서 '0'으로 전환한다.
                        for(int k=j+1; k<str_num.length(); k++){
                            if(str_num.charAt(k) == '1'){
                                long minus = (long)Math.pow(2, str_num.length() - 1 - k);
                                answer[i] -= minus;
                                break;
                            }
                        }
                        
                        break;
                    }
                    
                }
                
                
                if(answer[i] == 0){
                    //7(111) 같은 숫자라면 맨 좌측에 '1'을 추가 시킨다.+ 좌측에서 2번째 숫자는 뺀다.
                    //111 -> 1111 -> 1011
                    answer[i] = numbers[i] + (long)Math.pow(2, str_num.length());
                    answer[i] -= (long)Math.pow(2, str_num.length() - 1);
                }
            }
        }
        return answer;
    }
}
