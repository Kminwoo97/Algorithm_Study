import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> giftIndex = new HashMap<>(); // 선물지수
        Map<String, Map<String, Integer>> giftHistory = new HashMap<>(); // 선물기록
        Map<String, Integer> nextMonthGift = new HashMap<>(); // 다음달 받을 선물
        
        // 이번 달에 친구들끼리 선물 주고받은 갯수 카운트
        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            giftIndex.put(gift[0], giftIndex.getOrDefault(gift[0], 0) + 1);
            giftIndex.put(gift[1], giftIndex.getOrDefault(gift[1], 0) - 1);
            
            Map<String, Integer> givenValue = giftHistory.getOrDefault(gift[0], new HashMap<>());
            Map<String, Integer> receivedValue = giftHistory.getOrDefault(gift[1], new HashMap<>());
            
            givenValue.put(gift[1], givenValue.getOrDefault(gift[1], 0) + 1);
            receivedValue.put(gift[0], receivedValue.getOrDefault(gift[0], 0) - 1);
            
            giftHistory.put(gift[0], givenValue);
            giftHistory.put(gift[1], receivedValue);
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                
                int giver = giftIndex.getOrDefault(friends[i], 0);
                int receiver = giftIndex.getOrDefault(friends[j], 0);
                Map<String, Integer> history = giftHistory.getOrDefault(friends[i], new HashMap<>());

                // 선물 주고받은 기록 있는 경우
                if (history.containsKey(friends[j])) {
                    int log = history.get(friends[j]);
                    
                    // 주고받은 선물 수 같은 경우
                    if (log == 0) {
                        // 선물지수가 더 큰 사람에게 선물 하나 줌
                        answer = Math.max(answer, giveToBigger(nextMonthGift, giver, receiver, friends[i], friends[j]));
                    } else if (log > 0) {
                        // 많이 준 사람에게 선물
                        int nextValue = nextMonthGift.getOrDefault(friends[i], 0);
                        nextMonthGift.put(friends[i], nextValue + 1);
                        
                        answer = Math.max(answer, nextValue + 1);
                    } else {
                        int nextValue = nextMonthGift.getOrDefault(friends[j], 0);
                        nextMonthGift.put(friends[j], nextValue + 1);

                        answer = Math.max(answer, nextValue + 1);
                    }
                } else {
                    answer = Math.max(answer, giveToBigger(nextMonthGift, giver, receiver, friends[i], friends[j]));
                }
            }
        }
        
        return answer;
    }
    
    public int giveToBigger(Map<String, Integer> map, int giver, int receiver, String giverName, String receiverName) {
        int result = 0;
        
        // 선물지수가 같지 않은 경우
        if (giver != receiver) {
            // 선물지수 작은 사람이 큰 사람한테 선물.
            if (giver > receiver) {
                int nextValue = map.getOrDefault(giverName, 0);
                map.put(giverName, nextValue + 1);
                result = nextValue + 1;
            } else {
                int nextValue = map.getOrDefault(receiverName, 0);
                map.put(receiverName, nextValue + 1);
                result = nextValue + 1;
            }
        }
        
        return result;
    }
}
