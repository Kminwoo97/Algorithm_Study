import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, List<Song>> map = new HashMap<>();
        Map<String, Genre> genreMap = new HashMap<>();
        List<Song> list = new ArrayList<>();
        
        // 1. 장르별로 얼마나 재생됐는지 줄세우기
        for (int i = 0; i < genres.length; i++) {
            List<Song> songs = map.getOrDefault(genres[i], new ArrayList<>());
            Genre genre = genreMap.getOrDefault(genres[i], new Genre(genres[i], 0, 0));
            
            songs.add(new Song(i, genres[i], plays[i]));
            genre.playSum += plays[i];
            genre.songCount++;
            
            map.put(genres[i], songs);
            genreMap.put(genres[i], genre);
        }
        
        List<String> keys = new ArrayList<>(map.keySet());
        
        keys = keys.stream()
            .sorted((key1, key2) -> genreMap.get(key2).playSum - genreMap.get(key1).playSum)
            .peek(key -> { 
                // 2. 장르 내에서 재생횟수에 따라 내림차순 정렬 및 같은경우 번호 낮은 순으로 정렬
                List<Song> songs = map.get(key);
                
                songs = songs.stream()
                .sorted((e1, e2) -> {
                    if (e2.play == e1.play) {
                        return e1.num - e2.num;
                    } else {
                        return e2.play - e1.play;
                    }
                })
                .collect(Collectors.toList());
                
                map.put(key, songs);
            })
            .collect(Collectors.toList());
        
        List<Integer> answerList = new ArrayList<>();
        
        // 3. 1개 혹은 2개 추출
        for (String key : keys) {
            Genre genre = genreMap.get(key);
            List<Song> songs = map.get(key);
            
            if (genre.songCount < 2) {
                answerList.add(songs.get(0).num);
            } else {
                answerList.add(songs.get(0).num);
                answerList.add(songs.get(1).num);
            }
        }
        
        answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

class Song {
    int num;
    String genre;
    int play;
    
    Song (int num, String genre, int play) {
        this.num = num;
        this.genre = genre;
        this.play = play;
    }
}

class Genre {
    String genre;
    int playSum;
    int songCount;
    
    Genre (String genre, int playSum, int songCount) {
        this.genre = genre;
        this.playSum = playSum;
        this.songCount = songCount;
    }
}
