package com.cranberrysoft.blog.article.trapadvisor.problem2.functional;

import com.cranberrysoft.blog.article.trapadvisor.problem2.Solution;

import java.util.Arrays;

public class FunctionalSolution implements Solution {

    @Override
    public long find(int[] a, int n) {
        if (Arrays.stream(a).filter( number -> number< 0).count() > 0 ){
            throw new IllegalArgumentException("Integers in the array must be greater or equal 0");
        }

        return Arrays.stream(a).distinct()
                .filter(num -> num <= n)
                .boxed().flatMap(
                        i -> Arrays.stream(a).distinct().filter(num -> num <= n).boxed().map(j -> new Pair(i, j)
                        ))
                .distinct()
                .filter(pair -> pair.isEqualToSum(n))
                .count(); //we do not want to count duplicates like (1,2) (2,1)
    }

}
