class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] word = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};

        for (int i = 0; i < word.length; i++) {
            s = s.replaceAll(word[i], i + "");
        }

        return answer = Integer.parseInt(s);
    }
}