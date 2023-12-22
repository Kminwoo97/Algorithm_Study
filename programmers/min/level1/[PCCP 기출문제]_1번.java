class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int cur_time = attacks[0][0];
        int cur_health = health - attacks[0][1];
        if(cur_health <= 0)
            return -1;
        
        
        for(int i=1; i<attacks.length; i++){
            int[] attack = attacks[i];
            
            //1. 그 동안의 체력 회복
            int time = attack[0] - cur_time - 1;
            while(time > 0){
                if(time >= bandage[0]){
                    cur_health += (bandage[0] * bandage[1]) + bandage[2];
                    time -= bandage[0];
                }else{
                    cur_health += (time * bandage[1]);
                    time = 0;
                }
            }
            
            if(cur_health >= health)
                cur_health = health;
            
            //2. 공격 당함
            cur_time = attack[0];
            cur_health -= attack[1];
            
            if(cur_health <= 0)
                return -1;
        }
        
        answer = cur_health;
        
        return answer;
    }
}
