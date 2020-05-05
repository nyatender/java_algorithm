package StackAndQueue;

import java.lang.Object;
import java.util.*;
import javafx.util.Pair;

import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class virusTransmission {

    static int arr[] = {12,3,4,15};

    // method for sum of elements in an array
    static Boolean isSafe(Integer ROW, Integer COL, Integer row, Integer col)
    {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }
    static boolean isAnyHealtyhCell(String[] Matrix)
    {
            for(int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length(); j++) {
                if(Matrix[i].charAt(j) == '1' || Matrix[i].charAt(j) == '2')
                    return true;
            }
        }
        return false;
    }
    static void updateMatrixValues(String[] Matrix, Pair<Integer, Integer> it)
    {
        char[] arrs = Matrix[it.getKey()].toCharArray();
        if(Matrix[it.getKey()].charAt(it.getValue()) == '2') {
            arrs[it.getValue()] = '1';
            Matrix[it.getKey()] = String.valueOf(arrs);
        }
        else {
            arrs[it.getValue()] = '0';
            Matrix[it.getKey()] = String.valueOf(arrs);
        }
    }
    static void pushInQueue(String[] Matrix, Queue < Pair<Integer, Integer>> Queue, Pair<Integer, Integer> it,
                            Integer m, Integer n, AtomicBoolean isTrue, Set<Pair<Integer, Integer>> visited)
    {
        if (Matrix[it.getKey()].charAt(it.getValue()) != '0')
        {
            if(isTrue.get() == false)
                isTrue.set(true);
            updateMatrixValues(Matrix, new Pair(it.getKey(), it.getValue()));
            Queue.add(new Pair(it.getKey(), it.getValue()));
            return;
        }
        if (isSafe(m, n, it.getKey() + 1, it.getValue()) &&
            Matrix[it.getKey()+1].charAt(it.getValue()) != '0' &&
            Matrix[it.getKey()+1].charAt(it.getValue()) != '_' &&
                visited.contains(new Pair(it.getKey()+1, it.getValue())) != true
        )
        {
            visited.add(new Pair(it.getKey()+1, it.getValue()));
            if(isTrue.get() == false)
                isTrue.set(true);
            updateMatrixValues(Matrix, new Pair(it.getKey() + 1, it.getValue()));
            Queue.add(new Pair(it.getKey() + 1, it.getValue()));
        }
        if (isSafe(m, n, it.getKey() - 1, it.getValue()) &&
                Matrix[it.getKey() - 1].charAt(it.getValue()) != '0' &&
                Matrix[it.getKey() - 1].charAt(it.getValue()) != '_' &&
                visited.contains(new Pair(it.getKey()-1, it.getValue())) != true
        )
        {
            visited.add(new Pair(it.getKey()-1, it.getValue()));
            if(isTrue.get() == false)
                isTrue.set(true);
            updateMatrixValues(Matrix, new Pair(it.getKey() - 1, it.getValue()));
            Queue.add(new Pair(it.getKey() - 1, it.getValue()));
        }
        if ( isSafe(m, n, it.getKey(), it.getValue() + 1) &&
                Matrix[it.getKey()].charAt(it.getValue() + 1) != '0' &&
                Matrix[it.getKey()].charAt(it.getValue() + 1) != '_' &&
                visited.contains(new Pair(it.getKey(), it.getValue()+1)) != true
        )
        {
            visited.add(new Pair(it.getKey(), it.getValue()+1));
            if(isTrue.get() == false)
                isTrue.set(true);
            updateMatrixValues(Matrix, new Pair(it.getKey(), it.getValue()+1));
            Queue.add(new Pair(it.getKey(), it.getValue() + 1));
        }
        if (isSafe(m, n, it.getKey(), it.getValue() - 1) &&
                Matrix[it.getKey()].charAt(it.getValue()-1) != '0' &&
                Matrix[it.getKey()].charAt(it.getValue()-1) != '_' &&
                visited.contains(new Pair(it.getKey(), it.getValue()-1)) != true)
        {
            visited.add(new Pair(it.getKey(), it.getValue()-1));
            if(isTrue.get() == false)
                isTrue.set(true);
            updateMatrixValues(Matrix, new Pair(it.getKey(), it.getValue()-1));
            Queue.add(new Pair(it.getKey(), it.getValue() - 1));
        }
    }
    static int findInfectedDays(String[] Matrix)
    {
        //Rows
        int m = Matrix.length;
        //Column
        int n = Matrix[0].length();

        Queue < Pair<Integer, Integer>>Queue1 = new LinkedList<>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (Matrix[i].charAt(j) == '0')
                    Queue1.add(new Pair(i, j));
            }
        }
        int result = 0;
        if(!Queue1.isEmpty())
        {
            Queue1.add(new Pair(-1,-1));
        }
        else
            return result;

        while (!Queue1.isEmpty())
        {
            Pair p = Queue1.peek();
            Queue1.remove();
            AtomicBoolean isTrue = new AtomicBoolean(false);
            Set<Pair<Integer, Integer>> visited = new HashSet<Pair<Integer, Integer>>();
            while(!p.equals(new Pair(-1,-1))) {
                pushInQueue(Matrix, Queue1, p, m, n, isTrue, visited);
                p = Queue1.peek();
                Queue1.remove();
            }
            if(!Queue1.isEmpty())
                Queue1.add(new Pair(-1,-1));

            if(isTrue.get() == true)
                result++;
        }
        if(result == 0 && isAnyHealtyhCell(Matrix) == true)
        {
            result = -1;
        }

        return result;
    }
    // Driver method
    public static void main(String[] args)
    {
        String[] arr1 = new String[] { "02_20",
                                      "21212",
                                      "_121_",
                                      "__2__"
                                      };
        String[] arr2 = new String[] { "_1_",
            "101",
            "_1_"};
        String[] arr3 = new String[] { "_1_",
                "1_2",
                "_0_"
        };
        String[] arr4 = new String[] { "0_"
        };
        ArrayList<String[]> input = new ArrayList<String[]>() {
                            {
                                add(arr1);
                                add(arr2);
                                add(arr3);
                                add(arr4);
                            };
        };
        Iterator it = input.iterator();
        while(it.hasNext()) {
            //int result = findInfectedDays((String[])it.next());
            //System.out.println("result " + " = " + result);
        }
    }
}
