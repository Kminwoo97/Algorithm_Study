class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] point = new int[]{-1, -1};
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    point[0] = i;
                    point[1] = j;
                    
                    break;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            
            int[] movePoint = new int[2];
                
            if (route[0].equals("E")) {
                movePoint[0] = 0;
                movePoint[1] = 1;
            } else if (route[0].equals("W")) {
                movePoint[0] = 0;
                movePoint[1] = -1;
            } else if (route[0].equals("N")) {
                movePoint[0] = -1;
                movePoint[1] = 0;
            } else {
                movePoint[0] = 1;
                movePoint[1] = 0;
            }
                
            point = move(point, park, movePoint, Integer.parseInt(route[1]));
        }
        
        answer[0] = point[0];
        answer[1] = point[1];
        
        return answer;
    }
    
    public int[] move(int[] point, String[] park, int[] movePoint, int moveCount) {
        boolean canMove = true;
        int[] next = new int[]{point[0], point[1]};
        
        for (int i = 0; i < moveCount; i++) {
            next[0] += movePoint[0];
            next[1] += movePoint[1];
            
            if (next[0] < 0 || next[0] >= park.length ||
                next[1] < 0 || next[1] >= park[0].length() ||
                park[next[0]].charAt(next[1]) == 'X') {
                
                canMove = false;
                break;
            }
        }
        
        if (canMove) {
            point = next;
        }
        
        return point;
    }
}
