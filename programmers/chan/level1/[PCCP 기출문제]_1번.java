class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int end = 0;
        int index = 0;
        int t = 1;
        int hp = health;
        
        while (t <= attacks[attacks.length - 1][0]) {
            
            if (t == attacks[index][0]) {
                hp -= attacks[index][1];
                end = t + bandage[0];
                
                if (hp <= 0) {
                    hp = -1;
                    break;
                }
                
                index++;
            } else {
                hp += bandage[1];

                if (t >= end) {
                    hp += bandage[2];
                }
                
                if (hp > health) {
                    hp = health;
                }
            }
            
            t++;
        }
        
        return answer = hp;
    }
}
