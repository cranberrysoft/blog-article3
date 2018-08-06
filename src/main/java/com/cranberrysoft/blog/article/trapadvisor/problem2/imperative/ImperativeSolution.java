package com.cranberrysoft.blog.article.trapadvisor.problem2.imperative;

import com.cranberrysoft.blog.article.trapadvisor.problem2.Solution;

import java.util.*;

public class ImperativeSolution implements Solution {

    @Override
    public long find(int[] a, int n) {
        if(ifContainsNegative(a)){
            throw new IllegalArgumentException("Integers in the array must be greater or equal 0");
        }

        long result = 0;
        for( Integer[] pair: distinct(combinationsOfTwo(lessEqThen(a,n)))){
            if(pair[0]+pair[1] == n) result++;
        }
        return result;
    }

    private boolean ifContainsNegative(int[]a){
        for(int i: a){
            if(i < 0) return true;
        }
        return false;
    }

    private static Integer[] lessEqThen(int a[], int n){
        final List<Integer> resultSet = new ArrayList<>();
        for(int someInt: a){
            if(someInt <= n) {
                resultSet.add(someInt);
            }
        }
        return resultSet.toArray(new Integer[0]);
    }

    private static Integer[][] distinct(Integer[][] array){
        final Set<Integer[]> resultSet = new TreeSet<>( (arr1,arr2) -> Arrays.equals(arr1,arr2) == true ? 0: 1 );
        for(Integer[] someArray: array){
            resultSet.add(someArray);
        }
        return resultSet.toArray(new Integer[0][0]);
    }

    private static Integer[][] combinationsOfTwo(Integer a[]){
        Integer pairs[][] = new Integer[numOfCombinations(a.length,2)][2];

        int n = 0;
        for(int i =0 ; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                 pairs[n] = new Integer [] {a[i],a[j]};
                 n++;
            }
        }
        return pairs;
    }

    private static int numOfCombinations(int n, int k){
        return k <= n ? (factorial(n)/(factorial(k)*factorial(n-k))) : 0;
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
