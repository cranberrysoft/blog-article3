package com.cranberrysoft.blog.article.trapadvisor.problem2.functional;

import com.cranberrysoft.blog.article.trapadvisor.problem2.Solution;

import java.util.Arrays;

public class FunctionalSolution implements Solution {

    @Override
    public long find(int[] a, int n) {
        return Arrays.stream(a)
                .filter(num -> num <= n)
                .boxed().flatMap(i -> Arrays.stream(a).distinct().boxed().map(j -> new Integer[]{i, j}))
                .filter(pair -> pair[0] + pair[1] == n)
                .count() / 2; //we do not want to count duplicates like (1,2) (2,1)
    }

}
