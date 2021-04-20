package problems.SynechronAssignmentJava;

import java.util.ArrayList;
import java.util.List;

public class FirstAssignment_a {
    public static void main(String args[]) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Nataraja G",  10));
        empList.add(new Employee("Sachin N",  28));
        empList.add(new Employee("Ram S",  30));
        empList.add(new Employee("Aman k",  27));
        empList.add(new Employee("Veer",  12));

        // find employees whose age is above 26
       empList.stream().filter(emp->emp.getAge() > 26)
           .sorted((a,b )->a.getName().compareTo(b.getName()))
           .forEach(System.out::println);
    }
}

class Employee {

    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: "+ this.name +" age: "+ this.age;
    }
}
