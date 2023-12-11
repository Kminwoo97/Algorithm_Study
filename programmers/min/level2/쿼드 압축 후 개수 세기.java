class Solution {
    
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        //쿼드 압축 시작
        quad(arr, 0, 0, arr.length);
        
        
        return answer;
    }
    
    public void quad(int[][] arr, int x, int y, int size){
        //압축 가능하면  쿼드 압축 수 증가
        if(zip(arr, x, y, size, arr[x][y])){
            answer[arr[x][y]] += 1;
            return;
        }
        
        //압축 불가능하면 영역 쪼개기
        quad(arr, x, y, size / 2);
        quad(arr, x, y + size / 2, size / 2);
        quad(arr, x + size / 2, y, size / 2);
        quad(arr, x + size / 2, y + size / 2 , size / 2);
    }
    
    public boolean zip(int[][] arr, int x, int y, int size, int val){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(val != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
