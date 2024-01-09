import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        

        //C#, D#, F#, G#, A# 들은 소문자 c,d,f,g,a 로 치환
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        
        
        ArrayList<String[]> answer_list = new ArrayList<>();
        for(int i=0; i<musicinfos.length; i++){
            String[] musicinfo = musicinfos[i].split(",");
            
            String[] start_time = musicinfo[0].split(":");
            String[] end_time = musicinfo[1].split(":");
            String title = musicinfo[2];
            String sheet_music = musicinfo[3];
            sheet_music = sheet_music.replaceAll("C#", "c");
            sheet_music = sheet_music.replaceAll("D#", "d");
            sheet_music = sheet_music.replaceAll("F#", "f");
            sheet_music = sheet_music.replaceAll("G#", "g");
            sheet_music = sheet_music.replaceAll("A#", "a");
            
            //재생되는 악보 길
            int play_time = ((Integer.parseInt(end_time[0]) * 60 + Integer.parseInt(end_time[1]))
                - (Integer.parseInt(start_time[0]) * 60 + Integer.parseInt(start_time[1])));
            
            //재생되는 악보 생성
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<play_time; j++){
                sb.append(sheet_music.charAt(j % sheet_music.length()));
            }
            
            //answer 후보로 추가하기
            if(sb.toString().contains(m)){
                String[] tmp = new String[3];
                tmp[0] = Integer.toString(i); //인덱스
                tmp[1] = title; //제목
                tmp[2] = Integer.toString(play_time); //재생시간
                
                answer_list.add(tmp);
            }
        }
        
        //재생시간을 기준으로 내림차순 정렬
        Collections.sort(answer_list, new Comparator<String[]>(){
            @Override
            public int compare(String[] a, String[] b){
                
                //재생시간 같으면 먼저 입력된 순서로 정렬
                if(a[2].equals(b[2])){
                    return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
                }
                
                return Integer.parseInt(b[2]) - Integer.parseInt(a[2]);
            }
        });
        
        if(answer_list.size() == 0){
            return "(None)";
        }
        
        answer = answer_list.get(0)[1];
        
        return answer;
    }
}
