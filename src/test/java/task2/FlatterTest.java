package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class FlatterTest {

    @Test
    public void testFlatMap() {
        //given
        Object[] nestedArray = { new Object[] {1,2, new Object[]{3}}, 4};

        //when
        // [[1,2,[3]],4] → [1,2,3,4].
        Object[] flattenArray = Flatter.flatMap(nestedArray);

        //then
        assertThat(flattenArray).hasSize(4);
        assertThat(flattenArray).containsExactly(1,2,3,4);
    }

    @Test
    public void testFlatMap_shouldReturnNull_whenNestedArrayIsNull() {
        //given
        Object[] nestedArray = null;

        //when
        Object[] flattenArray = Flatter.flatMap(nestedArray);

        //then
        assertThat(flattenArray).isNull();
    }

}