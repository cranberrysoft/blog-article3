package com.cranberrysoft.blog.article.trapadvisor.problem2.imperative;

import com.cranberrysoft.blog.article.trapadvisor.problem2.Solution;

import java.util.HashSet;
import java.util.Set;

public class ImperativeSolution implements Solution {

    @Override
    public long find(int[] a, int n) {
        long result = 0;
        for( int[] pair: pairsNoRepetition(distinct(lessEqThen(a,n)))){
            if(pair[0]+pair[1] == n) result++;
        }
        return result;
    }

    private static Integer[] lessEqThen(int a[], int n){
        final Set<Integer> resultSet = new HashSet<>();
        for(int someInt: a){
            if(someInt <= n) {
                resultSet.add(someInt);
            }
        }
        return resultSet.toArray(new Integer[0]);
    }

    private static Integer[] distinct(Integer a[]){
        final Set<Integer> resultSet = new HashSet<>();
        for(Integer someInt: a){
            resultSet.add(someInt);
        }
        return resultSet.toArray(new Integer[0]);
    }

    private static int[][] pairsNoRepetition(Integer a[]){
        int pairs[][] = new int[numOfCombinations(a.length,2)][2];

        int n = 0;
        for(int i =0 ; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                 pairs[n] = new int [] {a[i],a[j]};
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
