import java.util.*;

class Solution {
    static String[] arr;
    
    public String[] solution(String[] record) {
        String[] answer = {};
        arr = new String[record.length];
        Map<String, User> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            
            switch (str[0]) {
                case "Enter":
                    User user = map.getOrDefault(str[1], new User(i, str[2]));
                                        
                    if (user.nickname.equals(str[2])) {
                        user.enterLog.add(i);
                        
                        map.put(str[1], user);
                        arr[i] = getEnterMessage(str[2]);
                    } else {
                        user.enterLog.add(i);
                        user.nickname = str[2];
                        
                        map.put(str[1], user);
                        updateMessage(user);
                    }
                    
                    break;
                case "Leave":
                    User leaveUser = map.get(str[1]);
                    leaveUser.leaveLog.add(i);
                    map.put(str[1], leaveUser);
                    
                    arr[i] = getLeaveMessage(leaveUser.nickname);
                    
                    break;
                case "Change":
                    User changeUser = map.get(str[1]);
                    changeUser.nickname = str[2];
                    map.put(str[1], changeUser);
                    
                    updateMessage(changeUser);
                    
                    break;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                list.add(arr[i]);
            }
        }
        
        answer = list.toArray(new String[list.size()]);
        
        return answer;
    }
    
    public String getEnterMessage(String nickname) {
        return nickname + "님이 들어왔습니다.";
    }
    
    public String getLeaveMessage(String nickname) {
        return nickname + "님이 나갔습니다.";
    }
    
    public void updateMessage(User user) {
        for (int j = 0; j < user.enterLog.size(); j++) {
            arr[user.enterLog.get(j)] = getEnterMessage(user.nickname);
        }
                        
        for (int j = 0; j < user.leaveLog.size(); j++) {
            arr[user.leaveLog.get(j)] = getLeaveMessage(user.nickname);
        }
    }
}

class User {
    List<Integer> enterLog;
    List<Integer> leaveLog;
    String nickname;
    
    User(int index, String nickname) {
        enterLog = new ArrayList<>();
        leaveLog = new ArrayList<>();
        this.nickname = nickname;
    }
}
