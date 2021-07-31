package com.liger.common.common.util;

import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToIntFunction;

public abstract class BatchUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchUtils.class);

    /**
     * 对列表分组批处理
     *
     * @param list      数据列表
     * @param action    对每组的批处理操作，返回处理成功个数
     * @param batchSize 每组批处理个数
     * @param <T>       处理的数据类型
     * @return 处理成功个数
     */
    public static <T> int groupBatch(List<T> list, ToIntFunction<List<T>> action, int batchSize) {
        if (CollectionUtils.isEmpty(list)) return 0;
        List<List<T>> subLists = ListUtils.partition(list, batchSize);
        LOGGER.info("将{}条数据分为{}个批次", list.size(), subLists.size());
        AtomicInteger completed = new AtomicInteger();
        return subLists.stream().parallel()
                .mapToInt(action)
                .peek(completed::addAndGet)
                .sum();
    }

}
