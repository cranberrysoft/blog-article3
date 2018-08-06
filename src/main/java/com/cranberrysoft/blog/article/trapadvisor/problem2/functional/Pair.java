package com.cranberrysoft.blog.article.trapadvisor.problem2.functional;

import java.util.Objects;

class Pair{
    private final int a;
    private final int b;

    Pair(Integer[] array) {
        if(array == null || array.length != 2){
            throw new IllegalArgumentException("Pair needs two elements");
        }
        this.a = array[0];
        this.b = array[1];
    }

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
        return ((a == pair.a && b == pair.b) || (a == pair.b && b == pair.a));
    }

    @Override
    public int hashCode() {
        return Objects.hash(a*b);
    }

}