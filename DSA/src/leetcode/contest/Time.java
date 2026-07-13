package leetcode.contest;

public class Time {
    public static void main(String[] args) {
//        System.out.println(secondsBetweenTimes("01:00:00","01:00:25"));
//        System.out.println(secondsBetweenTimes("12:34:56","13:00:00"));
//        System.out.println(secondsBetweenTimes("23:00:00","24:00:00"));
//        System.out.println(secondsBetweenTimes("24:00:00","00:30:00"));

        System.out.println(minimumCost(new int[]{1,2,3,4},4));
        System.out.println(minimumCost(new int[]{1,1,7,14},4));
        System.out.println(minimumCost(new int[]{1,2,3,4},10));
    }
    public static int secondsBetweenTimes(String startTime, String endTime) {
        String s1[]=startTime.split(":");
        String s2[]=endTime.split(":");

        int h1 = Integer.parseInt(s1[0]) * 60 * 60;
        int h2 = Integer.parseInt(s2[0]) * 60 * 60;

        int m1 = Integer.parseInt(s1[1])* 60;
        int m2 = Integer.parseInt(s2[1])* 60;

        int se1 = Integer.parseInt(s1[2]);
        int se2 = Integer.parseInt(s2[2]);

        int totalMinutes = (h2+m2+se2) - (h1+m1+se1);

        return totalMinutes;

    }

    public static int minimumCost(int[] nums, int K) {
        long mod = 1_000_000_007L;

        long res = K;
        long totalCost = 0;
        long op = 0;

        for (int x : nums) {

            if (res < x) {

                long cnt = (x - res + K - 1L) / K;

                totalCost = (totalCost + cnt * (2 * op + cnt + 1) / 2) % mod;

                op += cnt;
                res += cnt * K;
            }

            res -= x;
        }

        return (int) (totalCost % mod);
    }
}
