package com.cranberrysoft.blog.article.trapadvisor.problem2.functional;

import com.cranberrysoft.blog.article.trapadvisor.problem2.Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FunctionalSolution2 implements Solution {

    @Override
    public long find(int[] a, int n) {
        return Arrays.stream(
                pairsNoRepetition(
                        Arrays.stream(a)
                                .distinct()
                                .filter(number -> number <= n)
                        .toArray())
                )
                .filter(it -> it[0]+ it[1] == n)
                .count();
    }


    private static Integer[][] pairsNoRepetition(int a[]){
        return IntStream.range(0, a.length).boxed().flatMap(
                i -> IntStream.range(i+1, a.length).boxed().map(j -> new Integer[]{ a[i],a[j] } )
        ).toArray(Integer[][]::new);
    }

}
