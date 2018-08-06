package com.cranberrysoft.blog.article.trapadvisor.problem2.functional;

import com.cranberrysoft.blog.article.trapadvisor.problem2.Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FunctionalSolution2 implements Solution {
    @Override
    public long find(int[] a, int n) {
        if (Arrays.stream(a).filter( number -> number< 0).count() > 0 ){
            throw new IllegalArgumentException("Integers in the array must be greater or equal 0");
        }

        return Arrays.stream(
                combinationsOfTwo(
                        Arrays.stream(a)
                                .filter(number -> number <= n)
                        .toArray())
                )
                .map(Pair::new)
                .distinct()
                .filter(pair -> pair.isEqualToSum(n))
                .count();

    }

    private static Integer[][] combinationsOfTwo(int a[]){
        return IntStream.range(0, a.length).boxed().flatMap(
                i -> IntStream.range(i+1, a.length).boxed().map(j -> new Integer[]{ a[i],a[j] } )
        ).toArray(Integer[][]::new);
    }

}
