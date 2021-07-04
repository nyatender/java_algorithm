package problems.generalProblemSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortList
{
    public static void main(String[] args)
    {
        ArrayList<Employee> employees = getUnsortedEmployeeList();

        //1. Employee ids in ascending order
        Collections.sort(employees);

        System.out.println(employees);

        //2. Employee ids in reverse order
        Collections.sort(employees, Collections.reverseOrder());

        System.out.print(employees);
    }

    //Returns an unordered list of employees
    private static ArrayList<Employee> getUnsortedEmployeeList()
    {
        ArrayList<Employee> list = new ArrayList<>();
        Random rand = new Random(10);

        for(int i = 0; i < 5; i++)
        {
            Employee e = new Employee();
            e.setId(rand.nextInt(100));
            list.add(e);
        }
        return list;
    }
}

class Employee implements Comparable< Employee >{

    private Integer id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.getId().compareTo(o.getId());
    }
}