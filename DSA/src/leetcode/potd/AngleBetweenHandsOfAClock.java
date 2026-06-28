package leetcode.potd;

public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        System.out.println(angleClock(3,20));
        System.out.println(angleClock(7,25));
        System.out.println(angleClock(3,15));
        System.out.println(angleClock(12,30));
    }
    public static double angleClock(int hour, int minutes) {
//        double hourAngle= ((double)(hour*60 + minutes)/60)*30;
//        double minAngle = 6*minutes;
//        System.out.println(hourAngle+" "+minAngle);
//        return Math.abs(hourAngle-minAngle);
//        double x = hour + minutes / 60.0;
//        double diff = (11.0 * x) % 12.0;
//        return Math.min(diff, 12.0 - diff) * 30.0;
        double h = (hour%12 + minutes / 60.0)*30;
        double m = minutes * 6;
        double angle = Math.abs(h-m);
        if(angle > 180) angle = 360-angle;
        return angle;
    }
}
