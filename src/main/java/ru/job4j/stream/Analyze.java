package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    /**
     * вычисляет общий средний балл
     * @param stream
     * @return
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects()
                .stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * вычисляет средний балл ученика по его предметам.
     * Возвращает список из объекта Tuple (имя ученика и средний балл).
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(
                x.getName(), x.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * вычисляет средний балл по всем предметам для каждого ученика.
     * Возвращает список из объекта Tuple (название предмета и средний балл).
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {

        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам.
     * @param stream
     * @return
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects()
                .stream()
                .mapToInt(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     * возвращает предмет с наибольшим баллом для всех студентов.
     * Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     * @param stream
     * @return
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }
}
