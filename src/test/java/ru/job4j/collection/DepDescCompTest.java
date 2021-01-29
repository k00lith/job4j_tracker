package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBeforeSingle() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBeforeMultiple() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBeforeMultipleTreeByTwo() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK2",
                "K1/SK2"
        );
        assertThat(rsl, lessThan(0));
    }

}
