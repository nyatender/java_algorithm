package test;
/*
Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.

Input: {1, 2, 7, 1, 5}
Output: 0
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.

Input: {1, 3, 100, 4}
Output: 92
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.
 */
public class partitionSet {
    public int canPartition(int[] num) {
        // TODO: Write your code here
        if(num.length == 0 || num.length % 2 != 0)
            return 0;
        int sum = 0;
        for(int a : num)
            sum += a;
        sum = sum/2;

        return partitionUtils(num, 0, 0, 0);
    }
    public int partitionUtils(int[] num, int sum1, int sum2, int currIndex) {
        if(currIndex >= num.length)
            return Math.abs(sum1 - sum2);
        int diff1 = partitionUtils(num, sum1, sum2 + num[currIndex], currIndex+1);

        int diff2 = partitionUtils(num, sum1 + num[currIndex], sum2, currIndex+1);

        return Math.min(diff1, diff2);
    }
    public static void main(String[] args) {
        partitionSet ps = new partitionSet();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
