public class 예상_대진표 {
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int small = 0;
        int big = 0;

        if (a > b) {
            small = b;
            big = a;
        } else {
            small = a;
            big = b;
        }

        // n을 반으로 쪼갰을 때 a와 b의 값을 보자
        // a와 b가 반대편에 있을땐 결승전에서 만난다는 것을 알 수 있다.
        // 1. 둘이 반대편에 존재한다.
        // 2. 둘이 같은편에 존재한다.
        // 2-1. 왼편에 존재
        // 2-2. 오른편에 존재
        // 이렇게 a, b가 다른편에 존재할때까지 while()문 돌리면서 n을 반으로 나눈다.
        // a,b 가 다른편에 존재할때까지 시행하면서 최종적으로 현 시점 최대 반복횟수를 반환해준다.
        // 가령, a x x b | x x x x 일때 첫 번째 시행에서는 같은편이므로 continue;
        // 두 번째) a x | x b 이므로 2를 return;한다.


        while (n > 0) {
            int half = n / 2;

            if (half >= small && half < big) {
                break;
            } else {
                if (big > half) {
                    small -= half;
                    big -= half;
                }
            }

            n = half;
        }

        return (int) (Math.log(n) / Math.log(2));
    }
}
