package com.cranberrysoft.blog.article.trapadvisor.problem2;

public interface Solution {


    /**
     * Find number of pairs in a given array {@param a} which sum up to the defined number {@param n}
     * @param a array of integer
     * @param n sum to which numbers should sum up
     * @return number of pairs, we count only combinations(order does not matter) e.g for
     * the array {1,2,3,4} and n = 5 we have pairs {1,2},{1,3},{1,4},{2,3},{2,4},{3,4} and only pars
     * {1,4},{2,3} sums up to n = 5 so we return 2
     */
    long find(int a[], int n);
}
