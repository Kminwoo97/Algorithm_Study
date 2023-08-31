import java.util.*;
import java.util.Map.*; // Entry 사용하기 위해서

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        //1. 장르별 재생횟수 카운트, 장르별 [인덱스, 재생횟수] 기록
        HashMap<String, Integer> genrePlay = new HashMap<>();
        HashMap<String, ArrayList<int[]>> genreSong = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            //장르별 재생횟수 카운트
            genrePlay.put(genre, genrePlay.getOrDefault(genre, 0) + play);
            
            //장르별 [인덱스, 재생횟수] 기록
            if(!genreSong.containsKey(genre)){
                genreSong.put(genre, new ArrayList<int[]>());
            }
            genreSong.get(genre).add(new int[]{i, play});
        }
        
        //2. 재생횟수(value)를 기준으로 장르(key) 내림차순 정렬
        List<Entry<String, Integer>> entryList = new ArrayList<>(genrePlay.entrySet());
        Collections.sort(entryList, new Comparator<Entry<String, Integer>>(){
            public int compare(Entry<String, Integer> o1, Entry<String,Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });
        
        //3. 장르별 [인덱스, 재생횟수] 를 재생횟수를 기준으로 내림차순 정렬 후 최대 2개만 answerList에 담기
        ArrayList<Integer> answerList = new ArrayList<>();
        for(Entry<String, Integer> entry : entryList){
            
            String genre = entry.getKey();
            
            ArrayList<int[]> songList= genreSong.get(genre);
            Collections.sort(songList, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return b[1] - a[1];
                }
            });
            
            int cnt = 0;
            for(int i=0; i<songList.size(); i++){
                int[] song = songList.get(i);
                answerList.add(song[0]);
                cnt++;
                
                if(cnt == 2)
                    break;
            }
        }
        
        //4. ArrayList -> Array
        answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}
