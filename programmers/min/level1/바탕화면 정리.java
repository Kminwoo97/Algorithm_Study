class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i<wallpaper.length; i++){
            String[] row = wallpaper[i].split("");
            for(int j=0; j<row.length; j++){
                if(row[j].equals("#")){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    
                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);
                }
            }
        }
        
        answer = new int[]{minX, minY, maxX, maxY};
        
        return answer;
    }
}
