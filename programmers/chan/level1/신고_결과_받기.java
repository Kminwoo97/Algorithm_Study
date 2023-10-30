import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, User> users = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            users.put(id_list[i], new User(i, id_list[i]));
        }
        
        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            
            User reporter = users.get(str[0]);
            reporter.reportedUsers.add(str[1]);
            
            User reportedUser = users.get(str[1]);
            reportedUser.reporters.add(str[0]);

            users.put(str[0], reporter);
            users.put(str[1], reportedUser);
        }
        
        List<String> keys = new ArrayList<>(users.keySet());
        for (String key : keys) {
            User user = users.get(key);
            if (user.reporters.size() >= k) {
                for (String reporter : user.reporters) {
                    int reporterIdx = users.get(reporter).index;
                    answer[reporterIdx]++;
                }
            }
        }
        
        return answer;
    }
}

class User {
    int index;
    String id;
    Set<String> reportedUsers; // 내가 신고한 유저
    Set<String> reporters; // 나를 신고한 유저
    
    public User (int index, String id) {
        this.index = index;
        this.id = id;
        this.reportedUsers = new HashSet<>();
        this.reporters = new HashSet<>();
    }
}
