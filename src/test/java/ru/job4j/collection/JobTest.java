package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.core.Is.is;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmpPriority = new JobDescByName(); // по убыванию имени
        int rsl = cmpPriority.compare(
                new Job("Aaa", 0),
                new Job("Bbb", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAscend() {
        Comparator<Job> cmpPriority = new JobIncreaseByName(); // по возрастанию имени
        int rsl = cmpPriority.compare(
                new Job("Aaaaa", 0),
                new Job("Bb", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByProrityDesc() {
        Comparator<Job> cmpPriority = new JobDescByPriority(); // по убыванию приоритета
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityAscend() {
        Comparator<Job> cmpPriority = new JobIncreaseByPriority(); // по возрастанию приоритета
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityDesc() { // По убыванию имени, по убыванию приоритета
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAscend() { // по возрастанию приоритета, по возрастанию имени
        Comparator<Job> cmpNamePriority = new JobIncreaseByPriority().thenComparing(new JobIncreaseByName());
        int rsl = cmpNamePriority.compare(
                new Job("Aa", 1),
                new Job("B", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityEqual() { // по приоритету и имени
        Comparator<Job> cmpNamePriority = new JobIncreaseByPriority().thenComparing(new JobIncreaseByName());
        int rsl = cmpNamePriority.compare(
                new Job("Ticket", 262),
                new Job("Ticket", 262)
        );
        assertThat(rsl, is(0));
    }


}
