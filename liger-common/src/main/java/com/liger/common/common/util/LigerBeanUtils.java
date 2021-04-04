package com.liger.common.common.util;

import org.springframework.beans.BeanUtils;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class LigerBeanUtils {

    public static <S, T> T convert(S source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <S, T> T convert(S source, Supplier<T> targetSupplier) {
        return convert(source, targetSupplier.get());
    }

    public static <S, T> Function<S, T> converter(Supplier<T> targetSupplier) {
        return s -> convert(s, targetSupplier);
    }

}
