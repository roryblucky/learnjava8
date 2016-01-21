package com.rory.learnjava8.parallels;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by RoryGao on 16/1/21.
 */
public class ParallelsTest {
    //https://github.com/RichardWarburton/java-8-lambdas-exercises

    /**
     * 求列表中数字的平方和
     *
     * @param range
     * @return
     */
    public static int SumOfSquares(IntStream range) {
        return range.parallel().map(x -> x * x).sum();
    }

    /**
     * 列表数字相乘,然后结果乘以5
     *
     * @param linkedListOfNumbers
     * @return
     */
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream().reduce(1, (sum, x) -> sum * x) * 5;
    }

    /**
     * 求平法和
     *
     * @param linkedListOfNumbers
     * @return
     */
    public int sumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream().mapToInt(x -> x * x).sum();
    }

}
