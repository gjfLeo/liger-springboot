package com.liger.common.common.util;

import org.springframework.beans.BeanUtils;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Bean工具类
 */
public abstract class LigerBeanUtils {

    /**
     * Bean转换
     *
     * @param source 来源Bean
     * @param target 目标Bean
     * @param <S>    来源Bean的类型
     * @param <T>    目标Bean的类型
     * @return 目标Bean
     */
    public static <S, T> T convert(S source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 生成一个目标Bean并转换
     *
     * @param source         来源Bean
     * @param targetSupplier 目标Bean的{@link Supplier}
     * @param <S>            来源Bean的类型
     * @param <T>            目标Bean的类型
     * @return 目标Bean
     */
    public static <S, T> T convert(S source, Supplier<T> targetSupplier) {
        return convert(source, targetSupplier.get());
    }

    /**
     * 获取Bean转换器
     *
     * @param targetSupplier 目标Bean的{@link Supplier}
     * @param <S>            来源Bean的类型
     * @param <T>            目标Bean的类型
     * @return 将来源Bean转为目标Bean的转换器函数
     */
    public static <S, T> Function<S, T> converter(Supplier<T> targetSupplier) {
        return s -> convert(s, targetSupplier);
    }

}
