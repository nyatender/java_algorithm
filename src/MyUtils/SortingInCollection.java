package MyUtils;

import java.util.*;

//https://www.geeksforgeeks.org/collections-sort-java-examples/
//https://dzone.com/articles/sorting-java-arraylist
public class SortingInCollection {
    static void sortArrayList()
    {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
        Collections.sort(arr);
        Collections.sort(arr, Collections.reverseOrder());
    }
    static void sortArray()
    {
        int[] arr = new int[] { 2,20,10,5,4,23 };
       Arrays.sort(arr);
    }
    static void sortObject()
    {
        class Interval
        {
            int start;
            int end;
            public Interval(int a, int b)
            {
                this.start = a;
                this.end = b;
            }
        };
        ArrayList<Interval> intervals = new ArrayList<Interval>(Arrays.asList(new Interval(3,4)));
        intervals.add(new Interval(5,6));

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    }
    static void sortStringObject()
    {
        class Interval
        {
            String start;
            String end;
            public Interval(String a, String b)
            {
                this.start = a;
                this.end = b;
            }
        };
        ArrayList<Interval> intervals = new ArrayList<Interval>(Arrays.asList(new Interval("3","4")));
        intervals.add(new Interval("5","6"));

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> a.start.compareTo(b.start));
    }
    void usingAnonmous()
    {
        class Person {
            String firstName;
            String SecondName;
            public Person(String a, String b)
            {
                firstName = a;
                SecondName = b;
            }
        }
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Virat", "Kohli"));
        personList.add(new Person("Arun", "Kumar"));
        personList.add(new Person("Rajesh", "Mohan"));
        personList.add(new Person("Rahul", "Dravid"));

        //Sorting using Anonymous Inner class.
        Collections.sort(personList, new Comparator<Person>(){
                public int compare(Person p1, Person p2){
                return p1.firstName.compareTo(p2.firstName);
            }
        });
    }
    public static void main(String args[]) {

    }
}
