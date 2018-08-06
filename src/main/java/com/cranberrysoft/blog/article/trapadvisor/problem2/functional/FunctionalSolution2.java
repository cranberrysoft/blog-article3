package com.cranberrysoft.blog.article.trapadvisor.problem2.functional;

import com.cranberrysoft.blog.article.trapadvisor.problem2.Solution;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class FunctionalSolution2 implements Solution {

    class Pair{
        private final int a;
        private final int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public boolean isEqualToSum(int sum){
            return a+b == sum ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    @Override
    public long find(int[] a, int n) {
        return Arrays.stream(
                combinationsOfTwo(
                        Arrays.stream(a)
                                .filter(number -> number <= n)
                        .toArray())
                )
                .map(arr -> new Pair(arr[0],arr[1]))
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
