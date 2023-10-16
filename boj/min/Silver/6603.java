import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if(n == 0)
                break;

            int[] nums = new int[n];
            for(int i=0; i<n; i++)
                nums[i] = Integer.parseInt(st.nextToken());

            dfs(0, new ArrayList<>(), nums);
            System.out.println();
        }
    }

    public static void dfs(int start, ArrayList<Integer> list, int[] nums){
        if(list.size() == 6){
            for(int i=0; i<list.size(); i++)
                System.out.print(list.get(i)+" ");
            System.out.println();
            return;
        }

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);

            dfs(i+1, list, nums);

            list.remove(list.size() - 1);
        }
    }
}
