package task3.util;

public class DistanceCalculator {

    private static final int NUMBRER_OF_NAUTICAL_MILES_IN_ONE_DEGREE = 60;
    private static final double NUMBRER_OF_KM_IN_ONE_NAUTICAL_MILE = 1.852;

    public static double calculateDistance(double latitudeX1, double longitudeY1, double latitudeX2, double longitudeY2) {
        double x1 = Math.toRadians(latitudeX1);
        double y1 = Math.toRadians(longitudeY1);
        double x2 = Math.toRadians(latitudeX2);
        double y2 = Math.toRadians(longitudeY2);

        double angle = Math.acos(Math.sin(x1) * Math.sin(x2)
                + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));


        angle = Math.toDegrees(angle);

        return angle * NUMBRER_OF_NAUTICAL_MILES_IN_ONE_DEGREE * NUMBRER_OF_KM_IN_ONE_NAUTICAL_MILE;
    }

}
