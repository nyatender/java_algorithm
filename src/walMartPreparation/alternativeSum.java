package walMartPreparation;

public class alternativeSum {

    /*Function to return max sum such that no two elements

      are adjacent */

    int FindMaxSum(int arr[], int n)

    {

        int incl = arr[0];

        int excl = 0;

        int excl_new;

        int i;


        for (i = 1; i < n; i++)

        {

            /* current max excluding i */

            excl_new = (incl > excl) ? incl : excl;


            /* current max including i */

            incl = excl + arr[i];

            excl = excl_new;

        }


        /* return max of incl and excl */

        return ((incl > excl) ? incl : excl);

    }

    int findMaxSum(int arr[], int n) {
        int dp[] = new int[n+1];
      return findMaxSumUtils(arr, 0, 0 );
    }

    int findMaxSumUtils(int arr[], int sum, int i) {
        if(i+1 >= arr.length)
            return sum;

        int s1 = findMaxSumUtils(arr, sum+arr[i], i+2);
        int s2 = findMaxSumUtils(arr, sum, i+1);

        return Math.max(s1, s2);
    }
    // Driver program to test above functions

    public static void main(String[] args)

    {

        alternativeSum sum = new alternativeSum();

        int arr[] = new int[]{1, 20, 3};

        System.out.println(sum.FindMaxSum(arr, arr.length));

    }
}