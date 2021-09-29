package com.lsk.set;

import java.util.HashSet;

/**
 * @Author:林立可
 * @Date:2021/8/4 16:24
 * @PackageName:20data_structure com.lsk.set
 * @Description:
 */
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Employee employee1 = new Employee("llk",23);
        Employee employee2 = employee1;
        Employee employee3 = new Employee("llk", 23);
        hashSet.add(employee1); //true
        boolean add = hashSet.add(employee2);
        System.out.println(add);
        hashSet.add(employee3);
        System.out.println(hashSet);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    认为name和age相同，对象即相同

    /*@Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass()!=obj.getClass()){
            return false;
        }
        Employee employee = (Employee)obj;
        return employee.age == age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }*/
}
