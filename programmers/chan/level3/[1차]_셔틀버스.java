import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Queue<String> queue = new LinkedList<>();
        
        Arrays.sort(timetable);
        
        for (int i = 0; i < timetable.length; i++) {
            queue.offer(timetable[i]);
        }
        
        int tic = 0;
        
        
        while (tic < n) {
            int wait = 0;
            String lastTime = "";
            int[] shuttle = addTime(new int[]{9, 0}, t * tic);
            
            while (wait < m && !queue.isEmpty()) {
                String p = queue.peek();
                int[] arrivalTime = getTimeToInt(p);
                
                // 도착한 시간 p가 (09:00 + t * tic) 이전이라면
                int compare = compareTime(arrivalTime, shuttle);
                if (compare < 0) {
                    lastTime = queue.poll();
                    wait++;
                } else {
                    break;
                }
            }
            
            if (n - tic == 1) {
                if (wait < m) {
                    return getTimeToString(shuttle);
                } else {
                    int[] last = getTimeToInt(lastTime);
                    return getTimeToString(addTime(last, -1));
                }
            }
            
            tic++;
        }
        
        return answer;
    }
    
    public int[] getTimeToInt (String time) {
        int[] result = new int[2];
        String[] str = time.split(":");
        String hour = str[0];
        String min = str[1];
        
        if (hour.charAt(0) == '0') {
            if (hour.charAt(1) != '0') {
                result[0] = (int) (hour.charAt(1) - 48);
            } else {
                result[0] = 0;
            }
        } else {
            result[0] = Integer.parseInt(hour);
        }
        
        if (min.charAt(0) == '0') {
            result[1] = (int) (min.charAt(1) - 48);
        } else {
            result[1] = Integer.parseInt(min);
        }
        
        return result;
    }
    
    public int[] addTime(int[] time, int extraMin) {
        int addedMin = time[1] + extraMin;
        int quot = addedMin / 60;
        int remain = addedMin % 60;
        
        if (addedMin < 0) {
            quot = -1;
            remain = 59;
        }
        
        int addedTime = time[0] + quot;
        
        if (addedTime < 0) {
            addedTime = 0;    
        }
        
        time[0] = addedTime % 24;
        time[1] = remain;
        
        return time;
    }
    
    public int compareTime (int[] time1, int[] time2) {
        int t1 = time1[0] * 60 + time1[1];
        int t2 = time2[0] * 60 + time2[1];
        
        if (t1 > t2) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public String getTimeToString (int[] time) {
        StringBuilder sb = new StringBuilder();
        
        if (time[0] >= 10) {
            sb.append(time[0]);
        } else {
            sb.append("0" + time[0]);
        }
        
        sb.append(":");
        
        if (time[1] >= 10) {
            sb.append(time[1]);
        } else {
            sb.append("0" + time[1]);
        }
        
        return sb.toString();
    }
}
