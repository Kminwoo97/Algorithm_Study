import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Song> titles = new ArrayList<>();
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");
            
            // 시간 변환
            int playbackTime = getPlaybackTime(str[0].split(":"), str[1].split(":"));
            
            // C, C# 구분
            String replacedNotes = getReplacedNote(str[3]);
            
            // 변환된 시간과 str[3]길이 비교해서 더 짧으면 자르고, 더 길면 이어붙이기
            String musicSheet = "";
                
            if (replacedNotes.length() >= playbackTime) {
                musicSheet = replacedNotes.substring(0, playbackTime);
            } else {
                int repeatCnt = playbackTime / replacedNotes.length();
                int remain = playbackTime % replacedNotes.length();
                
                musicSheet = replacedNotes.repeat(repeatCnt) + replacedNotes.substring(0, remain);
            }
            
            // 조건 일치하면 곡 제목을 list에 저장
            if (musicSheet.contains(getReplacedNote(m))) {
                titles.add(new Song(i, str[2], playbackTime));
            }
        }
        
        if (titles.size() == 0) {
            answer = "(None)";
        } else {
            Collections.sort(titles, (e1, e2) -> {
                if (e1.playbackTime == e2.playbackTime) {
                    return e1.index - e2.index;
                } 
                
                return e2.playbackTime - e1.playbackTime;
            });
            
            answer = titles.get(0).title;
        }
        
        return answer;
    }
    
    public int getPlaybackTime(String[] startTime, String[] endTime) {
        int startHours = Integer.parseInt(startTime[0]);
        int endHours = Integer.parseInt(endTime[0]);
        
        int startMin = Integer.parseInt(startTime[1]);
        int endMin = Integer.parseInt(endTime[1]);
        
        int hourDiff = endHours - startHours;
        int minDiff = endMin - startMin;
        
        return hourDiff * 60 + minDiff;
    }
    
    public String getReplacedNote(String str) {
        List<Character> sheet = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
            
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '#') {
                char pre = sheet.get(sheet.size() - 1);
                sheet.remove(sheet.size() - 1);
                     
                // #을 해당 문자의 소문자로 치환
                sheet.add((char) (pre + 32));
            } else {
                sheet.add(str.charAt(j));
            }
        }
            
        for (int j = 0; j < sheet.size(); j++) {
            sb.append(sheet.get(j));
        }
        
        return sb.toString();
    }
}

class Song {
    int index;
    String title;
    int playbackTime;
    
    public Song(int index, String title, int playbackTime) {
        this.index = index;
        this.title = title;
        this.playbackTime = playbackTime;
    }
}
