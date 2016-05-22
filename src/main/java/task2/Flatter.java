package task2;

import java.util.LinkedList;
import java.util.List;

public class Flatter {

    public static Object[] flatMap(Object[] nestedArray) {
        if (nestedArray == null) {
            return null;
        }

        List<Integer> flattenArray = new LinkedList();

        flatMapRecursive(nestedArray, flattenArray);

        return flattenArray.toArray();
    }

    private static void flatMapRecursive(Object[] nestedArray, List flattenArray) {
        if (nestedArray == null) {
            return;
        }
        for (Object curr : nestedArray) {
            if (curr instanceof Integer) {
                flattenArray.add(curr);
            } else {
                flatMapRecursive((Object[]) curr, flattenArray);
            }
        }
    }

}
