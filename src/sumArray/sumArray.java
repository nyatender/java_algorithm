package sumArray;

import java.util.*;
import javafx.util.Pair;

import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;

public class sumArray {

    static int arr[] = {12,3,4,15};

    // method for sum of elements in an array
    Boolean isSafe(Integer ROW, Integer COL, Integer row, Integer col)
    {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }
    void pushInQueue(ArrayList<String> Matrix, Queue < Pair<Integer, Integer>> Queue, Pair<Integer, Integer> it, Integer m, Integer n)
    {
        if (Matrix.get(it.getKey()).charAt(it.getValue()) == '0')
            return;

        if (isSafe(m, n, it.getKey() + 1, it.getValue()) &&
                Matrix.get(it.getKey()+1).charAt(it.getValue()) != '0')
        {
            Queue.add(new Pair(it.getKey() + 1, it.getValue()));
        }
        if (isSafe(m, n, it.getKey() - 1, it.getValue()) && Matrix.get(it.getKey() - 1).charAt(it.getValue()) != '0')
        {
            Queue.add(new Pair(it.getKey() - 1, it.getValue()));
        }
        if ( isSafe(m, n, it.getKey(), it.getValue() + 1) && Matrix.get(it.getKey()).charAt(it.getValue()+1) == '0')
        {
            Queue.add(new Pair(it.getKey(), it.getValue() + 1));
        }
        if (isSafe(m, n, it.getKey(), it.getValue() - 1) && Matrix.get(it.getKey()).charAt(it.getValue()-1) == '0')
        {
            Queue.add(new Pair(it.getKey(), it.getValue() - 1));
        }

        if (Matrix.get(it.getKey()).charAt(it.getValue()) != '0')
           // Matrix.get(it.getKey()).charAt(it.getValue()) = Matrix.get(it.getKey()).charAt(it.getValue()) - 1;

        if (Matrix.get(it.getKey()).charAt(it.getValue()) != '0')
            Queue.add(it);
    }
    int findInfectedDays(ArrayList<String> Matrix, int m, int n)
    {
        Queue < Pair<Integer, Integer>>Queue1 = new LinkedList<>();
        Queue < Pair<Integer, Integer>>Queue2 = new LinkedList<>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (Matrix.get(i).charAt(j) == '0')
                    Queue1.add(new Pair<Integer, Integer>(i, j));
            }
        }
        int result = 0;
        while (!Queue1.isEmpty())
        {
            while (!Queue1.isEmpty())
            {
                Pair<Integer, Integer> it = Queue1.peek();
                pushInQueue(Matrix, Queue2, it, m, n);
                Queue1.remove();
            }
            result++;
            Queue1.addAll(Queue2);
            Queue2.clear();
        }

        return result;
    }

    // Driver method
    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<String>(){
            {
                add("02_20");
                add("21212");
            }
        };
        for(int j = 0; j < arr.size(); j++) {
            char charArray[] = arr.get(j).toCharArray();
            for (int i = 0; i < charArray.length; i++)
                System.out.println(arr.get(i));
        }
    }
}
