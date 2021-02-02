package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        return SearchAtt.filter(list, attachment -> attachment.getSize() > 100);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        return SearchAtt.filter(list, attachment -> attachment.getName().contains("bug"));
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        UnaryOperator<List<Attachment>> filter = attachments -> {
            List<Attachment> rsl = new ArrayList<>();
            for (Attachment att : attachments) {
                if (predicate.test(att)) {
                    rsl.add(att);
                }
            }
            return rsl;
        };
        return filter.apply(list);
    }
}
