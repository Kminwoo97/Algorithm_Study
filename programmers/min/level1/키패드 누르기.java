import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        HashMap<String, Node> map = new HashMap<>();
        map.put("1", new Node(0,0));
        map.put("2", new Node(0,1));
        map.put("3", new Node(0,2));
        map.put("4", new Node(1,0));
        map.put("5", new Node(1,1));
        map.put("6", new Node(1,2));
        map.put("7", new Node(2,0));
        map.put("8", new Node(2,1));
        map.put("9", new Node(2,2));
        map.put("*", new Node(3,0));
        map.put("0", new Node(3,1));
        map.put("#", new Node(3,2));
        
        String left = "*";
        String right = "#";
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                left = String.valueOf(numbers[i]);
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                right = String.valueOf(numbers[i]);
            }else{
                Node pointLeft = map.get(String.valueOf(left));
                Node pointRight = map.get(String.valueOf(right));
                Node target = map.get(String.valueOf(numbers[i]));
                int distanceLeft = Math.abs(pointLeft.x - target.x) + Math.abs(pointLeft.y - target.y);
                int distanceRight = Math.abs(pointRight.x - target.x) + Math.abs(pointRight.y - target.y);
                
                if(distanceLeft < distanceRight){
                    left = String.valueOf(numbers[i]);
                    sb.append("L");
                }else if(distanceLeft > distanceRight){
                    right = String.valueOf(numbers[i]);
                    sb.append("R");
                }else{
                    if(hand.equals("left")){
                        left = String.valueOf(numbers[i]);
                        sb.append("L");
                    }else if(hand.equals("right")){
                        right = String.valueOf(numbers[i]);
                        sb.append("R");
                    }
                }
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}

class Node{
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
