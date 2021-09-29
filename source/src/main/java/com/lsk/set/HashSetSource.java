package com.lsk.set;

import java.util.HashSet;

/**
 * @Author:林立可
 * @Date:2021/8/3 14:11
 * @PackageName:20data_structure com.lsk.set
 * @Description:
 */
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
       hashSet.add("java");
       hashSet.add(1);
       hashSet.add("go");
        System.out.println(hashSet);
    }
}
//class A{
//    int i;
//    public A(int i){
//        this.i = i;
//    }
//
//    @Override
//    public int hashCode() {
//        return 100;
//    }
//}
