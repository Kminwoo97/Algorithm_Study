class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int[] preLeft = new int[]{3, 0};
        int[] preRight = new int[]{3, 2};
        int[] mid = new int[2];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                preLeft[0] = (numbers[i] - 1) / 3;
                preLeft[1] = (numbers[i] - 1) % 3;
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                preRight[0] = (numbers[i] - 1) / 3;
                preRight[1] = (numbers[i] - 1) % 3;
            } else {
                mid[0] = (numbers[i] - 1) / 3;
                mid[1] = (numbers[i] - 1) % 3;
                
                if (mid[1] == -1) {
                    mid[0] = 3;
                    mid[1] = 1;
                }
                
                int leftDistance = Math.abs(preLeft[0] - mid[0]) + Math.abs(preLeft[1] - mid[1]);
                int rightDistance = Math.abs(preRight[0] - mid[0]) + Math.abs(preRight[1] - mid[1]);
                
                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        preRight[0] = mid[0];
                        preRight[1] = mid[1];
                    } else {
                        sb.append("L");
                        preLeft[0] = mid[0];
                        preLeft[1] = mid[1];
                    }
                } else {
                    if (leftDistance > rightDistance) {
                        sb.append("R");
                        preRight[0] = mid[0];
                        preRight[1] = mid[1];
                    } else {
                        sb.append("L");
                        preLeft[0] = mid[0];
                        preLeft[1] = mid[1];
                    }
                }
            }
        }
        
        return answer = sb.toString();
    }
}
