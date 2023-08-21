class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int index1 = 0;
        int index2 = 0;
        
        while (i < goal.length) {
            if (index1 < cards1.length && goal[i].equals(cards1[index1])) {
                index1++;
            } else if (index2 < cards2.length && goal[i].equals(cards2[index2])) {
                index2++;
            } else {
                return "No";
            }
            
            i++;
        }
        
        return "Yes";
    }
}
