package com.lsk.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author:林立可
 * @Date:2021/8/21 15:03
 * @PackageName:20data_structure com.lsk.set
 * @Description:
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
//            自定义排序规则
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length()-((String)o2).length();
            }
        });
        treeSet.add("a");
        treeSet.add("bc");
        treeSet.add("bbbb");
        System.out.println(treeSet);
    }
}
