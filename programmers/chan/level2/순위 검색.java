import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int[] infoScores = new int[info.length]; 
        
        // info를 코딩테스트 점수로 정렬
        Arrays.sort(info, (e1, e2) -> {
            int score1 = Integer.parseInt(e1.split(" ")[4]);
            int score2 = Integer.parseInt(e2.split(" ")[4]);
            
            return score1 - score2;
        });
        
        // info에서 점수 추출 
        for (int i = 0; i < info.length; i++) {
            infoScores[i] = Integer.parseInt(info[i].split(" ")[4]);
        }
        
        for (int i = 0; i < query.length; i++) {
            String[] str = query[i].split(" ");
            int score = Integer.parseInt(str[7]);
                
            // 이분탐색
            int start = 0;
            int end = info.length - 1;
            int mid = 0;
            
            while (start < end) {
                mid = (start + end + 1) / 2;
                
                if (infoScores[mid] >= score) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
            String language = str[0];
            String position = str[2];
            String experience = str[4];
            String food = str[6];
            int count = 0;
            
            for (int j = mid - 1; j < info.length; j++) {
                String[] infos = info[j].split(" ");
                boolean isMatched = true;
                
                if (infoScores[j] < score) {
                    continue;
                }
                
                if (language.equals("-")) {
                    if (position.equals("-")) {
                        if (experience.equals("-")) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else if (experience.equals(infos[2])) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (position.equals(infos[1])) {
                        if (experience.equals("-")) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else if (experience.equals(infos[2])) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else if (language.equals(infos[0])) {
                    if (position.equals("-")) {
                        if (experience.equals("-")) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else if (experience.equals(infos[2])) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (position.equals(infos[1])) {
                        if (experience.equals("-")) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else if (experience.equals(infos[2])) {
                            if (food.equals("-")) {
                                count++;
                            } else if (food.equals(infos[3])) {
                                count++;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}
