package com.liger.common.common.util;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class PredicateUtils {

    public static <T, R> Predicate<T> fieldNonNull(Function<T, R> fieldFunction) {
        return field(fieldFunction, Objects::nonNull);
    }

    public static <T, R> Predicate<T> fieldIsNull(Function<T, R> fieldFunction) {
        return field(fieldFunction, Objects::isNull);
    }

    public static <T, R> Predicate<T> field(Function<T, R> fieldFunction, Predicate<R> fieldPredicate) {
        return t -> fieldPredicate.test(fieldFunction.apply(t));
    }

}
