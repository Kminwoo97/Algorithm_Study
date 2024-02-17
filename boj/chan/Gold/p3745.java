import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String next = "";

        while ((next = br.readLine()) != null) {
            int n = Integer.parseInt(next.trim());
            int[] arr = new int[n];
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list.add(arr[0]);

            for (int i = 1; i < n; i++) {
                if (list.get(list.size() - 1) >= arr[i]) {
                    int start = 0;
                    int end = list.size() - 1;
                    int mid = 0;

                    while (start <= end) {
                        mid = (start + end) / 2;
                        
                        if (list.get(mid) < arr[i]) {
                            start = mid + 1;
                            mid++;
                        } else if (list.get(mid) > arr[i]) {
                            end = mid - 1;
                        } else {
                            break;
                        }
                    }

                    list.set(mid, arr[i]);
                } else {
                    list.add(arr[i]);
                }
            }

            System.out.println(list.size());
        }
    }
}


