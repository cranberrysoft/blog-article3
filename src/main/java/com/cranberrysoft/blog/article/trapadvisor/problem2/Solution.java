package com.cranberrysoft.blog.article.trapadvisor.problem2;

public interface Solution {


    /**
     * Find number of pairs in a given array {@param a} which sum up to the defined number {@param n}
     * @param a array of integer
     * @param n sum to which numbers should sum up
     * @return number of pairs, we count only combinations(order does not matter) e.g for
     * the array {2,3,3,3,4} and n = 6 we have unique pairs {2,3},{2,4},{3,3},{3,4} and only pars
     * {3,3},{2,4} sums up to n = 6 so we return 2. Please notice that we do not take into account repetitions like
     * (3,3) and (3,3) or (2,3) and (3,2)
     */
    long find(int a[], int n);
}
