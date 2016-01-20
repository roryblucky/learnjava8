package com.rory.learnjava8.collectors.customcollector;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by RoryGao on 16/1/20.
 */
public class StringCollector implements Collector<String, StringCombiner, String> {
    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner("[", ",", "]");
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return (stringCombiner, s) -> stringCombiner.add(s);
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        // 特征
        //如果收集器与结果一致 特征为current
        //如果收集器与结果不一致 特征为IDENTITY_FINISH
        //如果不想对原有数据顺序进行改变 特征为 UNORDERED
        return new HashSet<>(Arrays.asList(Characteristics.IDENTITY_FINISH));//当前收集器为StringCombiner 结果为string 所以不一致
    }
}
