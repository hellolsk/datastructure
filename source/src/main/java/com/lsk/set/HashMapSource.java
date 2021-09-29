package com.lsk.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:林立可
 * @Date:2021/8/11 13:01
 * @PackageName:20data_structure com.lsk.set
 * @Description:
 */
public class HashMapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "llk");
        hashMap.put(2, "cqupt");
        hashMap.put(3, "ccc");
        hashMap.put(4, new Student("h1", 16));
        hashMap.put(5, new Student("h2", 19));
        Set set1 = hashMap.keySet();
        Collection values = hashMap.values();
        for(Object set : set1){
            for(Object value:values){
                System.out.println(set+"-"+value);
            }
        }
        Set set = hashMap.entrySet();
        for(Object entry:set){
            Map.Entry m = (Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }

    }
}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
