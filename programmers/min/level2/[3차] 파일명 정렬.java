import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        ArrayList<File> fileList = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            //head, number-tail 로 분리해서 File 리스트에 저장한다.
            String head = files[i].split("[0-9]")[0].toLowerCase();
            String numberTail = files[i].substring(head.length());
            fileList.add(new File(i, head, numberTail));
        }
        Collections.sort(fileList);
        
        for(int i=0; i<fileList.size(); i++){
            answer[i] = files[fileList.get(i).index];
        }
        
        return answer;
    }
}

class File implements Comparable<File>{
    int index;
    String head;
    String numberTail;
    
    public File(int i, String head, String numberTail){
        this.index = i;
        this.head = head;
        this.numberTail = numberTail;
    }
    
    public int compareTo(File o){
        //head비교
        if(head.compareTo(o.head) == 0){
            //number비교
            return Integer.parseInt(extractNumber(numberTail)) - Integer.parseInt(extractNumber(o.numberTail));
        }else{
            return head.compareTo(o.head);
        }
    }
    
    public String extractNumber(String x){
        StringBuilder sb = new StringBuilder();
        for(Character c : x.toCharArray()){
            //number는 숫자이면서 최대 5개 글자이다.
            if(Character.isDigit(c) && sb.length() <= 5){
                sb.append(c);
            }else{
                return sb.toString();
            }
        }
        
        return sb.toString();
    }
}
