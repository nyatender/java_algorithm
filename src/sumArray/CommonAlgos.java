package sumArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class CommonAlgos {

    String dic[] = {"mobile","samsung","sam","sung",
                    "man","mango","icecream","and",
                    "go","i","like","ice","cream"};

    boolean isContainInDic(String str)
    {
        for(int i = 0; i < dic.length; i++)
        {
            if(dic[i].equals(str))
                return true;
        }
        return false;
    }
    boolean wordBreakProblemRec(String str)
    {
        if(str.isEmpty())
        {
            return true;
        }
        for(int i = 0; i < str.length(); i++)
        {
            if(isContainInDic(str.substring(0, i)))
            {
                if(wordBreakProblemRec(str.substring(i+1, str.length()-1 )))
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[])
    {

    }
}
