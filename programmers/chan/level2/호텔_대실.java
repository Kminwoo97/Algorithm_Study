import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<BookTime> list = new ArrayList<>();
        
        for (int i = 0; i < book_time.length; i++) {
            list.add(new BookTime(convertStringToTime(book_time[i][0]), convertStringToTime(book_time[i][1])));
        }

        Collections.sort(list, (e1, e2) -> e1.start - e2.start);

        // 종료시간 빠른 순서
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e1 - e2);
        
        for (int i = 0; i < list.size(); i++) {
            BookTime bt = list.get(i);
            // 종료시간보다 입실 시간이 느린 경우 방 하나
            while (!pq.isEmpty() && pq.peek() + 10 <= bt.start) {
                pq.poll();
            }
            
            pq.add(bt.end);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }

    public int convertStringToTime(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);
        
        return hour * 60 + min;
    }
}

class BookTime {
    int start;
    int end;
    
    public BookTime (int start, int end) {
        this.start = start;
        this.end = end;
    }
}
