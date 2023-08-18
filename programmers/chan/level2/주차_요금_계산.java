import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, Car> map = new HashMap<>();
        List<String> keys = new ArrayList<>();

        // 1. records에서 차량 번호를 조회하여 Car에 저장한다.
        // 1 - 2. 출차인 경우 요금을 구해서 Car에 업데이트한다.
        // 2. 입차 내역만 있고 출차 내역이 없는 차량은 출차를 23:59로 설정한다.
        // 3. 출차시간 - 입차시간을 구한다.
        // 4. fees 기준에 맞춰서 요금을 구한다.

        for (int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" ");

            String hour = str[0];
            String carNumber = str[1];
            String accessLogs = str[2];

            Car car;

            if (map.containsKey(carNumber)) {
                car = map.get(carNumber);
            } else {
                car = new Car(carNumber);
                keys.add(car.num);
            }

            if (accessLogs.equals("IN")) {
                car.inTime = hour;
                car.outTime = "23:59";
            } else {
                car.outTime = hour;
                car.totalTime += getDiff(car.inTime, car.outTime);
            }

            map.put(carNumber, car);
        }

        answer = new int[map.size()];
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            Car car = map.get(keys.get(i));

            if (car.outTime.equals("23:59")) {
                car.totalTime += getDiff(car.inTime, car.outTime);
            }

            answer[i] = getFee(fees, car);
        }

        return answer;
    }

    public int getDiff(String in, String out) {
        String[] inStr = in.split(":");
        String[] outStr = out.split(":");

        int inHour = Integer.parseInt(inStr[0]);
        int inMin = Integer.parseInt(inStr[1]);
        int outHour = Integer.parseInt(outStr[0]);
        int outMin = Integer.parseInt(outStr[1]);

        return (outHour * 60 + outMin) - (inHour * 60 + inMin);
    }

    public int getFee(int[] fees, Car car) {
        int total = car.totalTime;
        int fee = fees[1];

        if (total > fees[0]) {
            total -= fees[0];
            fee += ((total - 1) / fees[2] + 1) * fees[3];
        }

        return fee;
    }
}

class Car {
    String num;
    String inTime;
    String outTime;
    int totalTime = 0;

    Car (String num) {
        this.num = num;
    }
}