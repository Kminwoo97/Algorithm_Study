import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            List<Character> list = new ArrayList<>();

            for (int j = 0; j < skill_trees[i].length(); j++) {
                for (int k = 0; k < skill.length(); k++) {
                    if (skill.charAt(k) == skill_trees[i].charAt(j)) {
                        list.add(skill_trees[i].charAt(j));
                    }
                }
            }

            boolean isMatched = true;

            for (int j = 0; j < list.size(); j++) {
                if (skill.charAt(j) != list.get(j)) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched == true) {
                answer++;
            }
        }

        return answer;
    }
}