public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour){

        if(kilometersPerHour < 0){
            return -1;
        }
            return Math.round(kilometersPerHour);

    }
    public static void main(String[] args) {
        // Test the method
        System.out.println(toMilesPerHour(1.5)); // Should print 1
        System.out.println(toMilesPerHour(10.25)); // Should print 6
        System.out.println(toMilesPerHour(-5.6)); // Should print -1
    }
}