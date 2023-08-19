class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int month = 1;
        int totalDay = b - 1;
        
        while (month < a) {
            if (month == 2) {
                totalDay += 29;
                month++;
                continue;
            }
            
            if (month < 8) {
                if (month % 2 == 0) {
                    totalDay += 30;
                } else {
                    totalDay += 31;
                }
            } else {
                if (month % 2 == 0) {
                    totalDay += 31;
                } else {
                    totalDay += 30;
                }
            }
            
            month++;
        }
        
        int remain = totalDay % 7;
        
        answer = getDayName(remain);
            
        return answer;
    }
    
    public String getDayName(int n) {
        switch (n) {
            case 0:
                return "FRI";
            case 1:
                return "SAT";
            case 2:
                return "SUN";
            case 3:
                return "MON";
            case 4:
                return "TUE";
            case 5:
                return "WED";
            default:
                return "THU";
        }
    }
}