package task3.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DistanceCalculatorTest {

    @Test
    public void testCalculateDistance() {
        //given
        double latitudeX1 = 52.986375;
        double longitudeY1 = -10.4240951;
        double latitudeX2 = 51.8856167;
        double longitudeY2 = -10.4240951;

        //when
        double distance = DistanceCalculator.calculateDistance(latitudeX1, longitudeY1, latitudeX2, longitudeY2);

        //then
        String formattedDistance = String.format("%.1f", distance);
        assertThat(formattedDistance).isEqualTo("122,3");
    }

}