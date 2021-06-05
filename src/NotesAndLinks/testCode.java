package NotesAndLinks;

import java.util.*;

class employee implements Cloneable {
    private int age;
    private String name;
    employee(int age, String name) {
        this.age =age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class testCode {

    public static void main(String[] args) throws CloneNotSupportedException {

        employee e1 = new employee(20, "Sachin");

//        employee e2 = e1;
//        System.out.println(" e1 : " + e1);
//        System.out.println(" e2 : " + e2);
//        e1.setAge(30);
//        System.out.println(" e1 : " + e1);
//        System.out.println(" e2 : " + e2);

        employee e3 = (employee) e1.clone();
        System.out.println(" e1 : " + e1);
        System.out.println(" e2 : " + e3);
        e1.setAge(40);
        System.out.println(" e1 : " + e1);
        System.out.println(" e2 : " + e3);

        HashMap<Integer, Integer> hMap = new HashMap<>();
        ArrayList<Map.Entry<Integer, Integer>> Arr = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()) {
            Arr.add(entry);
        }

        Collections.sort(Arr, (i, j) -> i.getValue().compareTo(j.getValue()));
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for(int i = 0; i < Arr.size(); i++) {
            result.put(Arr.get(i).getKey(), Arr.get(i).getValue());
        }

    }
}
