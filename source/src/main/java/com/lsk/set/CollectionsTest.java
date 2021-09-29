package com.lsk.set;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author:林立可
 * @Date:2021/8/21 16:00
 * @PackageName:20data_structure com.lsk.set
 * @Description:
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }
}
