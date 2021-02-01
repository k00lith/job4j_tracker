package ru.job4j.lambda;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> x);
        List<Double> expected = Arrays.asList(5D, 6D, 7D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(3125D, 46656D, 823543D);
        assertThat(result, is(expected));
    }

}