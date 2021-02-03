package ru.job4j.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testConvertToList() {
        Matrix matrix = new Matrix();
        List<List<Integer>> listMatrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> rsl = Arrays.asList(1, 2, 3, 4);
        assertThat(rsl, is(matrix.convertToList(listMatrix)));
    }
}
