import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        
        //입*출차 기록하기
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            
            String carNumber = record[1];
            String parkType = record[2];
            String[] parkTime = record[0].split(":");
            int minutesTime = Integer.parseInt(parkTime[0]) * 60 + Integer.parseInt(parkTime[1]);
            
            if(parkType.equals("IN")){
                inTime.put(carNumber, minutesTime);
            }else{
                totalTime.put(carNumber, 
                              totalTime.getOrDefault(carNumber, 0) + (minutesTime - inTime.get(carNumber)));
                inTime.remove(carNumber);
            }
        }
        
        //출차기록이 없으면 23:59분에 출차
        int minutesTime = 23*60 + 59;
        for(String key : inTime.keySet()){
            totalTime.put(key, totalTime.getOrDefault(key, 0) + (minutesTime - inTime.get(key)));
        }
        
        //차량번호 정렬
        ArrayList<String> carList = new ArrayList<>();
        for(String key : totalTime.keySet()){
            carList.add(key);
        }
        Collections.sort(carList);
        
        //요금계산
        answer = new int[carList.size()];
        for(int i=0; i<carList.size(); i++){
            int totalMinutes = totalTime.get(carList.get(i));
            int fee = fees[1];
            if(totalMinutes - fees[0] > 0){
                fee +=  (int)Math.ceil( (totalMinutes - fees[0]) / (double)fees[2]) * fees[3];
            }
            answer[i] = fee;
        }
        
        return answer;
    }
}
